/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.druid.ingest.dao;

import java.util.List;

/**
 *
 * @author bigdata
 */
public class ParseSpec {

    private String format;
    private TimestampSpec timestampSpec;
    private DimensionsSpec dimensionsSpec;
    private List<String> columns;
    private String delimiter;

    public ParseSpec() {
        super();
    }

    public ParseSpec(String format, TimestampSpec timestampSpec, DimensionsSpec dimensionsSpec) {
        this.format = format;
        this.timestampSpec = timestampSpec;
        this.dimensionsSpec = dimensionsSpec;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public ParseSpec setFormat(String format) {
        this.format = format;
        return this;
    }

    /**
     * @return the timestampSpec
     */
    public TimestampSpec getTimestampSpec() {
        return timestampSpec;
    }

    /**
     * @param timestampSpec the timestampSpec to set
     */
    public ParseSpec setTimestampSpec(TimestampSpec timestampSpec) {
        this.timestampSpec = timestampSpec;
        return this;
    }

    /**
     * @return the dimensionsSpec
     */
    public DimensionsSpec getDimensionsSpec() {
        return dimensionsSpec;
    }

    /**
     * @param dimensionsSpec the dimensionsSpec to set
     */
    public ParseSpec setDimensionsSpec(DimensionsSpec dimensionsSpec) {
        this.dimensionsSpec = dimensionsSpec;
        return this;
    }

    /**
     * @return the columns
     */
    public List<String> getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public ParseSpec setColumns(List<String> columns) {
        this.columns = columns;
        return this;
    }

    /**
     * @return the delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * @param delimiter the delimiter to set
     */
    public ParseSpec setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

}
