/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.ingest.local;

import com.druid.ingest.dao.BatchIngestion;
import com.druid.ingest.dao.DataSchema;
import com.druid.ingest.dao.DimensionsSpec;
import com.druid.ingest.dao.Firehose;
import com.druid.ingest.dao.GranularitySpec;
import com.druid.ingest.dao.IoConfig;
import com.druid.ingest.dao.Metric;
import com.druid.ingest.dao.ParseSpec;
import com.druid.ingest.dao.Parser;
import com.druid.ingest.dao.Spec;
import com.druid.ingest.dao.TimestampSpec;
import com.druid.ingest.dao.TuningConfig;
import com.druid.utils.Ingestion;
import com.google.gson.JsonObject;
import java.util.Arrays;
import org.json.JSONObject;

/**
 *
 * @author bigdata
 */
public class WikiIngestion {

    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        String dataSource = "wikipedia-tx-00";
        String dir = "/home/bigdata/workspace/java/druid-breakdown/data/wiki/";
        Parser parser = new Parser()
                .setType("string")
                .setParseSpec(new ParseSpec()
                        .setFormat("json")
                        .setTimestampSpec(new TimestampSpec("time", "auto"))
                        .setDimensionsSpec(new DimensionsSpec(Arrays.asList("url", "user"))));
        GranularitySpec granularitySpec = new GranularitySpec().setType("uniform")
                .setSegmentGranularity("hour")
                .setQueryGranularity("hour")
                .setIntervals("2015-09-01T00/2015-09-01T04")
                .setRollup(true);
        DataSchema dataSchema = new DataSchema().setDataSource(dataSource)
                .setParser(parser)
                .setGranularitySpec(granularitySpec)
                .setMetric(new Metric("views", "count"))
                .setMetric(new Metric("latencyMs", "doubleSum", "latencyMs"));
        // 
        IoConfig ioConfig = new IoConfig()
                .setType("index")
                .setFirehose(new Firehose()
                        .setType("local")
                        .setBaseDir(dir)
                        .setFilter("*.json"));
        TuningConfig tuningConfig = new TuningConfig()
                .setType("index")
                //                .setMaxRowsInMemory(75000)
                .setNumShards(8);
        BatchIngestion wikiIngest = new BatchIngestion()
                .setType("index")
                .setSpec(new Spec()
                        .setDataSchema(dataSchema)
                        .setIoConfig(ioConfig)
                        .setTuningConfig(tuningConfig));
        String response = Ingestion.ingestData(new JSONObject(wikiIngest).toString());
        System.out.println(response);
    }

}
