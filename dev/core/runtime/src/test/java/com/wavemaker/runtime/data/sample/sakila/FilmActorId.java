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

/**
 * FilmActorId generated by hbm2java
 */
@SuppressWarnings({ "serial" })
public class FilmActorId implements java.io.Serializable {

    private short actorId;

    private short filmId;

    public FilmActorId() {
    }

    public FilmActorId(short actorId, short filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public short getActorId() {
        return this.actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    public short getFilmId() {
        return this.filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof FilmActorId)) {
            return false;
        }
        FilmActorId castOther = (FilmActorId) other;

        return this.getActorId() == castOther.getActorId() && this.getFilmId() == castOther.getFilmId();
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getActorId();
        result = 37 * result + this.getFilmId();
        return result;
    }

}
