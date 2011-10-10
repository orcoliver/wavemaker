/*
 *  Copyright (C) 2008-2009 WaveMaker Software, Inc.
 *
 *  This file is part of the WaveMaker Server Runtime.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.wavemaker.runtime.data;

import java.util.Properties;
import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wavemaker.common.util.SpringUtils;
import com.wavemaker.infra.WMTestCase;
import com.wavemaker.runtime.data.util.DataServiceUtils;

/**
 * Tests Hibernate directly without using any wm infrastucture.
 * 
 */
public abstract class BaseHibernateTest extends WMTestCase {

    protected static SessionFactory sessionFactory = null;

    protected static Session session = null;

    static {
        Properties p = DataServiceUtils.loadDBProperties(DataServiceTestConstants.MYSQL_SAKILA_PROPERTIES);

        Configuration cfg = DataServiceUtils.initConfiguration(DataServiceTestConstants.SAKILA_HIBERNATE_CFG, p);

        sessionFactory = cfg.buildSessionFactory();
    }

    @Override
    public void setUp() {
        session = sessionFactory.openSession();
    }

    @Override
    public void tearDown() {
        if (session.isOpen()) {
            session.close();
        }
    }

    public BaseHibernateTest() {
        super(Level.OFF);
        SpringUtils.initSpringConfig();
    }

}
