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
public class DimensionsSpec {

    private List<String> dimensions;
    private List<String> dimensionExclusions;
    private List<String> spatialDimensions;

    public DimensionsSpec() {
        super();
    }

    public DimensionsSpec(List<String> dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * @return the dimensions
     */
    public List<String> getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(List<String> dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * @return the dimensionExclusions
     */
    public List<String> getDimensionExclusions() {
        return dimensionExclusions;
    }

    /**
     * @param dimensionExclusions the dimensionExclusions to set
     */
    public void setDimensionExclusions(List<String> dimensionExclusions) {
        this.dimensionExclusions = dimensionExclusions;
    }

    /**
     * @return the spatialDimensions
     */
    public List<String> getSpatialDimensions() {
        return spatialDimensions;
    }

    /**
     * @param spatialDimensions the spatialDimensions to set
     */
    public void setSpatialDimensions(List<String> spatialDimensions) {
        this.spatialDimensions = spatialDimensions;
    }

}
