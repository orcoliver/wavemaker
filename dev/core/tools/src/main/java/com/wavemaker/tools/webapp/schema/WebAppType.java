/*
 *  Copyright (C) 2008-2011 VMWare, Inc. All rights reserved.
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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.4-10/02/2007 10:39 AM(ffu)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.12.20 at 10:31:30 AM PST 
//

package com.wavemaker.tools.webapp.schema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for web-appType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="web-appType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{http://java.sun.com/xml/ns/j2ee}descriptionGroup"/>
 *         &lt;element name="distributable" type="{http://java.sun.com/xml/ns/j2ee}emptyType"/>
 *         &lt;element name="context-param" type="{http://java.sun.com/xml/ns/j2ee}param-valueType"/>
 *         &lt;element name="filter" type="{http://java.sun.com/xml/ns/j2ee}filterType"/>
 *         &lt;element name="filter-mapping" type="{http://java.sun.com/xml/ns/j2ee}filter-mappingType"/>
 *         &lt;element name="listener" type="{http://java.sun.com/xml/ns/j2ee}listenerType"/>
 *         &lt;element name="servlet" type="{http://java.sun.com/xml/ns/j2ee}servletType"/>
 *         &lt;element name="servlet-mapping" type="{http://java.sun.com/xml/ns/j2ee}servlet-mappingType"/>
 *         &lt;element name="session-config" type="{http://java.sun.com/xml/ns/j2ee}session-configType"/>
 *         &lt;element name="mime-mapping" type="{http://java.sun.com/xml/ns/j2ee}mime-mappingType"/>
 *         &lt;element name="welcome-file-list" type="{http://java.sun.com/xml/ns/j2ee}welcome-file-listType"/>
 *         &lt;element name="error-page" type="{http://java.sun.com/xml/ns/j2ee}error-pageType"/>
 *         &lt;element name="jsp-config" type="{http://java.sun.com/xml/ns/j2ee}jsp-configType"/>
 *         &lt;element name="security-constraint" type="{http://java.sun.com/xml/ns/j2ee}security-constraintType"/>
 *         &lt;element name="login-config" type="{http://java.sun.com/xml/ns/j2ee}login-configType"/>
 *         &lt;element name="security-role" type="{http://java.sun.com/xml/ns/j2ee}security-roleType"/>
 *         &lt;group ref="{http://java.sun.com/xml/ns/j2ee}jndiEnvironmentRefsGroup"/>
 *         &lt;element name="message-destination" type="{http://java.sun.com/xml/ns/j2ee}message-destinationType"/>
 *         &lt;element name="locale-encoding-mapping-list" type="{http://java.sun.com/xml/ns/j2ee}locale-encoding-mapping-listType"/>
 *       &lt;/choice>
 *       &lt;attribute name="version" use="required" type="{http://java.sun.com/xml/ns/j2ee}web-app-versionType" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "web-appType", propOrder = { "descriptionAndDisplayNameAndIcon" })
public class WebAppType {

    @XmlElements({ @XmlElement(name = "locale-encoding-mapping-list", type = LocaleEncodingMappingListType.class),
        @XmlElement(name = "icon", type = IconType.class), @XmlElement(name = "ejb-ref", type = EjbRefType.class),
        @XmlElement(name = "context-param", type = ParamValueType.class),
        @XmlElement(name = "message-destination-ref", type = MessageDestinationRefType.class),
        @XmlElement(name = "session-config", type = SessionConfigType.class), @XmlElement(name = "servlet", type = ServletType.class),
        @XmlElement(name = "security-constraint", type = SecurityConstraintType.class), @XmlElement(name = "error-page", type = ErrorPageType.class),
        @XmlElement(name = "jsp-config", type = JspConfigType.class), @XmlElement(name = "resource-env-ref", type = ResourceEnvRefType.class),
        @XmlElement(name = "distributable", type = EmptyType.class), @XmlElement(name = "filter-mapping", type = FilterMappingType.class),
        @XmlElement(name = "listener", type = ListenerType.class), @XmlElement(name = "mime-mapping", type = MimeMappingType.class),
        @XmlElement(name = "servlet-mapping", type = ServletMappingType.class), @XmlElement(name = "service-ref", type = ServiceRefType.class),
        @XmlElement(name = "filter", type = FilterType.class), @XmlElement(name = "login-config", type = LoginConfigType.class),
        @XmlElement(name = "env-entry", type = EnvEntryType.class), @XmlElement(name = "security-role", type = SecurityRoleType.class),
        @XmlElement(name = "ejb-local-ref", type = EjbLocalRefType.class), @XmlElement(name = "resource-ref", type = ResourceRefType.class),
        @XmlElement(name = "welcome-file-list", type = WelcomeFileListType.class), @XmlElement(name = "display-name", type = DisplayNameType.class),
        @XmlElement(name = "description", type = DescriptionType.class),
        @XmlElement(name = "message-destination", type = MessageDestinationType.class) })
    protected List<Object> descriptionAndDisplayNameAndIcon;

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String version;

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the descriptionAndDisplayNameAndIcon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the descriptionAndDisplayNameAndIcon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getDescriptionAndDisplayNameAndIcon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link LocaleEncodingMappingListType } {@link IconType }
     * {@link EjbRefType } {@link ParamValueType } {@link MessageDestinationRefType } {@link SessionConfigType }
     * {@link ServletType } {@link SecurityConstraintType } {@link ErrorPageType } {@link JspConfigType }
     * {@link ResourceEnvRefType } {@link EmptyType } {@link FilterMappingType } {@link ListenerType }
     * {@link MimeMappingType } {@link ServletMappingType } {@link ServiceRefType } {@link FilterType }
     * {@link LoginConfigType } {@link EnvEntryType } {@link SecurityRoleType } {@link EjbLocalRefType }
     * {@link ResourceRefType } {@link WelcomeFileListType } {@link DisplayNameType } {@link DescriptionType }
     * {@link MessageDestinationType }
     * 
     * 
     */
    public List<Object> getDescriptionAndDisplayNameAndIcon() {
        if (this.descriptionAndDisplayNameAndIcon == null) {
            this.descriptionAndDisplayNameAndIcon = new ArrayList<Object>();
        }
        return this.descriptionAndDisplayNameAndIcon;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return possible object is {@link java.lang.String }
     * 
     */
    public java.lang.String getVersion() {
        return this.version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value allowed object is {@link java.lang.String }
     * 
     */
    public void setVersion(java.lang.String value) {
        this.version = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return possible object is {@link java.lang.String }
     * 
     */
    public java.lang.String getId() {
        return this.id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value allowed object is {@link java.lang.String }
     * 
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

}
