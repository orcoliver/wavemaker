/*
 *  Copyright (C) 2009 WaveMaker Software, Inc.
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

package com.wavemaker.runtime.data.sample.orahr;

// Generated Aug 19, 2007 9:06:50 PM by Hibernate Tools 3.2.0.b9

import java.util.HashSet;
import java.util.Set;

/**
 * Countries generated by hbm2java
 */
@SuppressWarnings({ "serial", "unchecked" })
public class Countries implements java.io.Serializable {

    private String countryId;

    private Regions regions;

    private String countryName;

    private Set locationses = new HashSet(0);

    public Countries() {
    }

    public Countries(String countryId) {
        this.countryId = countryId;
    }

    public Countries(String countryId, Regions regions, String countryName, Set locationses) {
        this.countryId = countryId;
        this.regions = regions;
        this.countryName = countryName;
        this.locationses = locationses;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Regions getRegions() {
        return this.regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set getLocationses() {
        return this.locationses;
    }

    public void setLocationses(Set locationses) {
        this.locationses = locationses;
    }

}
