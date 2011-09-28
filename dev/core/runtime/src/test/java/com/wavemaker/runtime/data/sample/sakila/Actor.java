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
package com.wavemaker.runtime.data.sample.sakila;
// Generated Jul 5, 2007 6:21:54 PM by Hibernate Tools 3.2.0.b9


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Actor generated by hbm2java
 */
@SuppressWarnings({"serial", "unchecked"})
public class Actor  implements java.io.Serializable {


     private Short actorId;
     private String firstName;
     private String lastName;
     private Date lastUpdate;
     private Set filmActors = new HashSet(0);

    public Actor() {
    }
    
    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }    

	
    public Actor(String firstName, String lastName, Date lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }
    public Actor(String firstName, String lastName, Date lastUpdate, Set filmActors) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.lastUpdate = lastUpdate;
       this.filmActors = filmActors;
    }
   
    public Short getActorId() {
        return this.actorId;
    }
    
    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Set getFilmActors() {
        return this.filmActors;
    }
    
    public void setFilmActors(Set filmActors) {
        this.filmActors = filmActors;
    }




}

