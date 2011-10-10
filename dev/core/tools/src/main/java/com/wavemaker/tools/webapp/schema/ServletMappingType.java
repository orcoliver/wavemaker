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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * 
 * The servlet-mappingType defines a mapping between a servlet and a url pattern.
 * 
 * Used in: web-app
 * 
 * 
 * 
 * <p>
 * Java class for servlet-mappingType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="servlet-mappingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="servlet-name" type="{http://java.sun.com/xml/ns/j2ee}servlet-nameType"/>
 *         &lt;element name="url-pattern" type="{http://java.sun.com/xml/ns/j2ee}url-patternType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servlet-mappingType", propOrder = { "servletName", "urlPattern" })
public class ServletMappingType {

    @XmlElement(name = "servlet-name", required = true)
    protected ServletNameType servletName;

    @XmlElement(name = "url-pattern", required = true)
    protected UrlPatternType urlPattern;

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the servletName property.
     * 
     * @return possible object is {@link ServletNameType }
     * 
     */
    public ServletNameType getServletName() {
        return this.servletName;
    }

    /**
     * Sets the value of the servletName property.
     * 
     * @param value allowed object is {@link ServletNameType }
     * 
     */
    public void setServletName(ServletNameType value) {
        this.servletName = value;
    }

    /**
     * Gets the value of the urlPattern property.
     * 
     * @return possible object is {@link UrlPatternType }
     * 
     */
    public UrlPatternType getUrlPattern() {
        return this.urlPattern;
    }

    /**
     * Sets the value of the urlPattern property.
     * 
     * @param value allowed object is {@link UrlPatternType }
     * 
     */
    public void setUrlPattern(UrlPatternType value) {
        this.urlPattern = value;
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
