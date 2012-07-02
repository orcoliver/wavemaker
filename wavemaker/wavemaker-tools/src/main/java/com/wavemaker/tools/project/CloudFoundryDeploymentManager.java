/*
 *  Copyright (C) 2012 VMware, Inc. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.wavemaker.tools.project;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.cloudfoundry.client.lib.CloudFoundryException;
import org.apache.tools.ant.taskdefs.War;
import org.apache.tools.ant.taskdefs.Ear;
import org.apache.tools.ant.*;
import org.apache.tools.ant.types.FileSet;

import com.wavemaker.tools.ant.ServiceCompilerTask;
import com.wavemaker.tools.deployment.DeploymentTarget;
import com.wavemaker.tools.deployment.DeploymentTargetManager;
import com.wavemaker.tools.deployment.DeploymentType;
import com.wavemaker.tools.deployment.cloudfoundry.CloudFoundryDeploymentTarget;
import com.wavemaker.tools.service.DesignServiceManager;
import com.wavemaker.tools.io.local.LocalFolder;
import com.wavemaker.tools.io.local.LocalFile;
import com.wavemaker.tools.io.Folder;
import com.wavemaker.tools.io.File;

public class CloudFoundryDeploymentManager extends StageDeploymentManager {

    private DeploymentTargetManager deploymentTargetManager;

    private DesignServiceManager designServiceManager;

    @Override
    public String testRunStart() {
        ServiceCompilerTask task = new ServiceCompilerTask();
        task.setDesignServiceManager(this.designServiceManager);
        task.doExecute();
        compile();
        CloudFoundryDeploymentTarget cloudFoundryDeploymentTarget = getCloudFoundryDeploymentTarget();
        return cloudFoundryDeploymentTarget.testRunStart(this.projectManager.getCurrentProject());
    }

    @Override
    public String compile() {
        return this.projectCompiler.compile();
    }

    @Override
    public String cleanCompile() {
        clean();
        return compile();
    }

    private void clean() {
        Project project = this.projectManager.getCurrentProject();
        List<Resource> classFiles = getFileSystem().listChildren(project.getWebInfClasses(), new ResourceFilter() {

            @Override
            public boolean accept(Resource resource) {
                return "class".equals(StringUtils.getFilenameExtension(resource.getFilename()));
            }
        });
        for (Resource classFile : classFiles) {
            getFileSystem().deleteFile(classFile);
        }
    }

    @Override
    public String build() {
        return compile();
    }

    @Override
    public String generateRuntime() {
        throw new UnsupportedOperationException("Haven't implemented this yet.");
    }

    @Override
    public String cleanBuild() {
        return cleanCompile();
    }

    @Override
    public com.wavemaker.tools.io.File buildWar(com.wavemaker.tools.io.File warFile, java.io.File tempWebAppRoot,
                                                boolean includeEar) throws IOException {
        LocalFolder buildDir = new LocalFolder(tempWebAppRoot);
        Folder dist = warFile.getParent();
        dist.createIfMissing();
        buildWar(getProjectDir(), buildDir,  warFile, includeEar, this.projectManager, this.projectManager.getFileSystem());
        return warFile;
    }

    @Override
    public com.wavemaker.tools.io.File buildWar(com.wavemaker.tools.io.File warFile, java.io.File tempWebAppRoot,
                                                boolean includeEar, ProjectManager origProjMgr) throws IOException {
        LocalFolder buildDir = new LocalFolder(tempWebAppRoot);
        Folder dist = warFile.getParent();
        dist.createIfMissing();
        buildWar(getProjectDir(), buildDir,  warFile, includeEar, origProjMgr, this.projectManager.getFileSystem());
        return warFile;
    }

    public LocalFile assembleWar(Map<String, Object> properties) {
        File warFile = (LocalFile)properties.get(WAR_FILE_NAME_PROPERTY);
        LocalFolder buildAppWebAppRoot = (LocalFolder)properties.get(BUILD_WEBAPPROOT_PROPERTY);
        LocalFolder tempDistFolder = (LocalFolder)buildAppWebAppRoot.getFolder(DeploymentManager.DIST_DIR_DEFAULT);
        tempDistFolder.createIfMissing();
        LocalFile tempWarFile = (LocalFile)tempDistFolder.getFile(warFile.getName());
        War warTask = new War();
        warTask.setBasedir(buildAppWebAppRoot.getLocalFile());

        warTask.setDestFile(tempWarFile.getLocalFile());
        //warTask.setDestFile(((LocalFile)properties.get(WAR_FILE_NAME_PROPERTY)).getLocalFile());
        warTask.setExcludes("**/application.xml, **/*.documentation.json");
        org.apache.tools.ant.Project ant = new org.apache.tools.ant.Project();
        warTask.setProject(ant);
        warTask.execute();

        tempWarFile.copyTo(warFile.getParent());
        return tempWarFile;
    }

    public void assembleEar(Map<String, Object> properties) {
        Ear earTask = new Ear();
        FileSet fs = new FileSet();
        LocalFile warFile = (LocalFile)properties.get(WAR_FILE_NAME_PROPERTY);
        fs.setFile(warFile.getLocalFile());
        LocalFile earFile = (LocalFile)properties.get(EAR_FILE_NAME_PROPERTY);
        LocalFolder buildAppWebAppRoot = (LocalFolder)properties.get(BUILD_WEBAPPROOT_PROPERTY);
        LocalFolder tempDistFolder = (LocalFolder)buildAppWebAppRoot.getFolder(DeploymentManager.DIST_DIR_DEFAULT);
        tempDistFolder.createIfMissing();
        LocalFile tempEarFile = (LocalFile)tempDistFolder.getFile(earFile.getName());
        earTask.setDestFile(tempEarFile.getLocalFile());
        LocalFolder webInf = (LocalFolder)((Folder)properties.get(BUILD_WEBAPPROOT_PROPERTY)).getFolder("WEB-INF");
        LocalFile appXml = (LocalFile)webInf.getFile("application.xml");
        earTask.setAppxml(appXml.getLocalFile());
        org.apache.tools.ant.Project ant = new org.apache.tools.ant.Project();
        earTask.setProject(ant);
        earTask.execute();

        tempEarFile.copyTo(earFile.getParent());
    }

    @Override
    public void testRunClean() {
        try {
            undeploy();
        } catch (CloudFoundryException ex) {
            if (HttpStatus.NOT_FOUND != ex.getStatusCode()) {
                throw ex;
            }
        }
    }

    @Override
    public void testRunClean(Project project) {
        CloudFoundryDeploymentTarget target = getCloudFoundryDeploymentTarget();
        target.undeploy(project);
    }

    @Override
    public void undeploy() {
        Project project = this.projectManager.getCurrentProject();
        CloudFoundryDeploymentTarget target = getCloudFoundryDeploymentTarget();
        target.undeploy(project);
    }

    private CloudFoundryDeploymentTarget getCloudFoundryDeploymentTarget() {
        DeploymentTarget deploymentTarget = this.deploymentTargetManager.getDeploymentTarget(DeploymentType.CLOUD_FOUNDRY);
        Assert.isInstanceOf(CloudFoundryDeploymentTarget.class, deploymentTarget);
        return (CloudFoundryDeploymentTarget) deploymentTarget;
    }

    public void setDeploymentTargetManager(DeploymentTargetManager deploymentTargetManager) {
        this.deploymentTargetManager = deploymentTargetManager;
    }

    public void setDesignServiceManager(DesignServiceManager designServiceManager) {
        this.designServiceManager = designServiceManager;
    }

}
