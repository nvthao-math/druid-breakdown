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
public class IoConfig {

    private String type;
    private Firehose firehose;

    public IoConfig() {
        super();
    }

    public IoConfig(String type, Firehose firehose) {
        this.type = type;
        this.firehose = firehose;
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
    public IoConfig setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return the firehose
     */
    public Firehose getFirehose() {
        return firehose;
    }

    /**
     * @param firehose the firehose to set
     */
    public IoConfig setFirehose(Firehose firehose) {
        this.firehose = firehose;
        return this;
    }

}
