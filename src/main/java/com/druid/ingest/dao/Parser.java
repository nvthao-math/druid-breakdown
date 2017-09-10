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
public class Parser {

    private String type;
    private ParseSpec parseSpec;

    public Parser() {
        super();
    }

    public Parser(String type, ParseSpec parseSpec) {
        this.type = type;
        this.parseSpec = parseSpec;
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
    public Parser setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return the parseSpec
     */
    public ParseSpec getParseSpec() {
        return parseSpec;
    }

    /**
     * @param parseSpec the parseSpec to set
     */
    public Parser setParseSpec(ParseSpec parseSpec) {
        this.parseSpec = parseSpec;
        return this;
    }

}
