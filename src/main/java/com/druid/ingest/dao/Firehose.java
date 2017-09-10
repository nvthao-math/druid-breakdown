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
public class Firehose {

    private String type;
    private String baseDir;
    private String filter;

    // constructor
    public Firehose() {
        super();
    }

    public Firehose(String type, String baseDir, String filter) {
        this.type = type;
        this.baseDir = baseDir;
        this.filter = filter;
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
    public Firehose setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return the baseDir
     */
    public String getBaseDir() {
        return baseDir;
    }

    /**
     * @param baseDir the baseDir to set
     */
    public Firehose setBaseDir(String baseDir) {
        this.baseDir = baseDir;
        return this;
    }

    /**
     * @return the filter
     */
    public String getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public Firehose setFilter(String filter) {
        this.filter = filter;
        return this;
    }

}
