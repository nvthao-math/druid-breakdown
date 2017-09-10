/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.druid.ingest.dao;

/**
 *
 * @author bigdata
 */
public class Metric {

    private String name;
    private String type;
    private String fieldName;

    public Metric() {
        super();
    }

    public Metric(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Metric(String name, String type, String fieldName) {
        this.name = name;
        this.type = type;
        this.fieldName = fieldName;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

}
