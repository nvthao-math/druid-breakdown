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
public class TuningConfig {

    private Integer numShards;
    private String type;
    private Integer targetPartitionSize;
    private Integer maxRowsInMemory;

    public TuningConfig() {
        super();
    }

    public TuningConfig(String type, Integer numShards, Integer maxRowsInMemory) {
        this.type = type;
        this.numShards = numShards;
        this.maxRowsInMemory = maxRowsInMemory;
    }

    /**
     * @return the numShards
     */
    public Integer getNumShards() {
        return numShards;
    }

    /**
     * @param numShards the numShards to set
     */
    public TuningConfig setNumShards(Integer numShards) {
        this.numShards = numShards;
        return this;
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
    public TuningConfig setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return the targetPartitionSize
     */
    public Integer getTargetPartitionSize() {
        return targetPartitionSize;
    }

    /**
     * @param targetPartitionSize the targetPartitionSize to set
     */
    public TuningConfig setTargetPartitionSize(Integer targetPartitionSize) {
        this.targetPartitionSize = targetPartitionSize;
        return this;
    }

    /**
     * @return the maxRowsInMemory
     */
    public Integer getMaxRowsInMemory() {
        return maxRowsInMemory;
    }

    /**
     * @param maxRowsInMemory the maxRowsInMemory to set
     */
    public TuningConfig setMaxRowsInMemory(Integer maxRowsInMemory) {
        this.maxRowsInMemory = maxRowsInMemory;
        return this;
    }

}
