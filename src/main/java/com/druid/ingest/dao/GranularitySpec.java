/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.druid.ingest.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bigdata
 */
public class GranularitySpec {

    private String type;
    private String segmentGranularity;
    private String queryGranularity;
    private List<String> intervals;
    private boolean rollup = true;

    public GranularitySpec() {
        super();
    }

    public GranularitySpec(String type, String segmentGranularity, String queryGranularity, List<String> intervals) {
        this.type = type;
        this.segmentGranularity = segmentGranularity;
        this.queryGranularity = queryGranularity;
        this.intervals = intervals;
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
    public GranularitySpec setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return the segmentGranularity
     */
    public String getSegmentGranularity() {
        return segmentGranularity;
    }

    /**
     * @param segmentGranularity the segmentGranularity to set
     */
    public GranularitySpec setSegmentGranularity(String segmentGranularity) {
        this.segmentGranularity = segmentGranularity;
        return this;
    }

    /**
     * @return the queryGranularity
     */
    public String getQueryGranularity() {
        return queryGranularity;
    }

    /**
     * @param queryGranularity the queryGranularity to set
     */
    public GranularitySpec setQueryGranularity(String queryGranularity) {
        this.queryGranularity = queryGranularity;
        return this;
    }

    /**
     * @return the intervals
     */
    public List<String> getIntervals() {
        return intervals;
    }

    /**
     * @param intervals the intervals to set
     */
    public void setIntervals(List<String> intervals) {
        this.intervals = intervals;
    }

    public GranularitySpec setIntervals(String... intervals) {
        if (intervals != null) {
            this.intervals = new ArrayList<>();
            this.intervals.addAll(Arrays.asList(intervals));
        }
        return this;
    }

    /**
     * @return the rollup
     */
    public boolean isRollup() {
        return rollup;
    }

    /**
     * @param rollup the rollup to set
     */
    public GranularitySpec setRollup(boolean rollup) {
        this.rollup = rollup;
        return this;
    }

}
