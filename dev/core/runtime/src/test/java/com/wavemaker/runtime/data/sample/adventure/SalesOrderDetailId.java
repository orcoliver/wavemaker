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

package com.wavemaker.runtime.data.sample.adventure;

// Generated Aug 18, 2007 5:20:14 PM by Hibernate Tools 3.2.0.b9

/**
 * SalesOrderDetailId generated by hbm2java
 */
@SuppressWarnings("serial")
public class SalesOrderDetailId implements java.io.Serializable {

    private int salesOrderId;

    private int salesOrderDetailId;

    public SalesOrderDetailId() {
    }

    public SalesOrderDetailId(int salesOrderId, int salesOrderDetailId) {
        this.salesOrderId = salesOrderId;
        this.salesOrderDetailId = salesOrderDetailId;
    }

    public int getSalesOrderId() {
        return this.salesOrderId;
    }

    public void setSalesOrderId(int salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public int getSalesOrderDetailId() {
        return this.salesOrderDetailId;
    }

    public void setSalesOrderDetailId(int salesOrderDetailId) {
        this.salesOrderDetailId = salesOrderDetailId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof SalesOrderDetailId)) {
            return false;
        }
        SalesOrderDetailId castOther = (SalesOrderDetailId) other;

        return this.getSalesOrderId() == castOther.getSalesOrderId() && this.getSalesOrderDetailId() == castOther.getSalesOrderDetailId();
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getSalesOrderId();
        result = 37 * result + this.getSalesOrderDetailId();
        return result;
    }

}
