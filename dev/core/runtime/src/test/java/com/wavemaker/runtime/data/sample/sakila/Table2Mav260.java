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

// Generated Jan 9, 2008 4:21:59 PM by Hibernate Tools 3.2.0.CR1

/**
 * Table2Mav260 generated by hbm2java
 */
@SuppressWarnings({ "serial" })
public class Table2Mav260 implements java.io.Serializable {

    private int id;

    private Table1Mav260 table1Mav260ByFk2;

    private Table1Mav260 table1Mav260ByFk;

    private String companyname;

    public Table2Mav260() {
    }

    public Table2Mav260(int id, Table1Mav260 table1Mav260ByFk) {
        this.id = id;
        this.table1Mav260ByFk = table1Mav260ByFk;
    }

    public Table2Mav260(int id, Table1Mav260 table1Mav260ByFk2, Table1Mav260 table1Mav260ByFk, String companyname) {
        this.id = id;
        this.table1Mav260ByFk2 = table1Mav260ByFk2;
        this.table1Mav260ByFk = table1Mav260ByFk;
        this.companyname = companyname;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Table1Mav260 getTable1Mav260ByFk2() {
        return this.table1Mav260ByFk2;
    }

    public void setTable1Mav260ByFk2(Table1Mav260 table1Mav260ByFk2) {
        this.table1Mav260ByFk2 = table1Mav260ByFk2;
    }

    public Table1Mav260 getTable1Mav260ByFk() {
        return this.table1Mav260ByFk;
    }

    public void setTable1Mav260ByFk(Table1Mav260 table1Mav260ByFk) {
        this.table1Mav260ByFk = table1Mav260ByFk;
    }

    public String getCompanyname() {
        return this.companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

}
