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
public class BatchIngestion {

    private String type;
    private Spec spec;

    public BatchIngestion() {
        super();
    }

    public BatchIngestion(String type, Spec spec) {
        this.type = type;
        this.spec = spec;
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
    public BatchIngestion setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return the spec
     */
    public Spec getSpec() {
        return spec;
    }

    /**
     * @param spec the spec to set
     */
    public BatchIngestion setSpec(Spec spec) {
        this.spec = spec;
        return this;
    }

}
