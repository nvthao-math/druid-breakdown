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
public class Spec {

    private DataSchema dataSchema;
    private IoConfig ioConfig;
    private TuningConfig tuningConfig;

    public Spec() {
        super();
    }

    public Spec(DataSchema dataSchema, IoConfig ioConfig, TuningConfig tuningConfig) {
        this.dataSchema = dataSchema;
        this.ioConfig = ioConfig;
        this.tuningConfig = tuningConfig;
    }

    /**
     * @return the dataSchema
     */
    public DataSchema getDataSchema() {
        return dataSchema;
    }

    /**
     * @param dataSchema the dataSchema to set
     */
    public Spec setDataSchema(DataSchema dataSchema) {
        this.dataSchema = dataSchema;
        return this;
    }

    /**
     * @return the ioConfig
     */
    public IoConfig getIoConfig() {
        return ioConfig;
    }

    /**
     * @param ioConfig the ioConfig to set
     */
    public Spec setIoConfig(IoConfig ioConfig) {
        this.ioConfig = ioConfig;
        return this;
    }

    /**
     * @return the tuningConfig
     */
    public TuningConfig getTuningConfig() {
        return tuningConfig;
    }

    /**
     * @param tuningConfig the tuningConfig to set
     */
    public Spec setTuningConfig(TuningConfig tuningConfig) {
        this.tuningConfig = tuningConfig;
        return this;
    }

}
