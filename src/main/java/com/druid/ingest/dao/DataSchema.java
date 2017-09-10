/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.druid.ingest.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bigdata
 */
public class DataSchema {

    private String dataSource;
    private Parser parser;
    private List<Metric> metricsSpec;
    private GranularitySpec granularitySpec;

    public DataSchema() {
        super();
    }

    public DataSchema(String dataSource, Parser parser, List<Metric> metricsSpec, GranularitySpec granularitySpec) {
        this.dataSource = dataSource;
        this.parser = parser;
        this.metricsSpec = metricsSpec;
        this.granularitySpec = granularitySpec;
    }

    /**
     * @return the dataSource
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public DataSchema setDataSource(String dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    /**
     * @return the parser
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * @param parser the parser to set
     */
    public DataSchema setParser(Parser parser) {
        this.parser = parser;
        return this;
    }

    /**
     * @return the metricsSpec
     */
    public List<Metric> getMetricsSpec() {
        return metricsSpec;
    }

    /**
     * @param metricsSpec the metricsSpec to set
     */
    public DataSchema setMetricsSpec(List<Metric> metricsSpec) {
        this.metricsSpec = metricsSpec;
        return this;
    }

    public DataSchema setMetric(Metric metric) {
        this.metricsSpec = (this.metricsSpec == null) ? new ArrayList<>() : this.metricsSpec;
        this.metricsSpec.add(metric);
        return this;
    }

    /**
     * @return the granularitySpec
     */
    public GranularitySpec getGranularitySpec() {
        return granularitySpec;
    }

    /**
     * @param granularitySpec the granularitySpec to set
     */
    public DataSchema setGranularitySpec(GranularitySpec granularitySpec) {
        this.granularitySpec = granularitySpec;
        return this;
    }

}
