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
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author bigdata
 */
public class ChatSendIngestJob {

    public static void main(String[] args) {
        List<String> listHour = Arrays.asList("07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
        for (String hour : listHour) {
            execute(hour);
        }
    }

    private static void execute(String hour) {
        String dataSource = "chat-sendxyz";
        String dir = String.format("/home/bigdata/workspace/data/CHAT-SEND/2017-22-08/hour=%s/", hour);
//        String dir = "/home/bigdata/workspace/data/CHAT-SEND/2017-22-08/test/";
        List<String> columns = Arrays.asList("log_time", "app_name", "app_mode", "server_ip", "src_id", "des_id", "command", "sub_command",
                "result", "start_time", "execute_time", "param", "extra_param", "client_type", "version", "msg_id", "type", "operator", "network",
                "model", "imei", "client_version", "client_ip", "port", "server_id", "router_name", "country", "birthday", "age", "gender",
                "living_location", "phonenumber_detail");
        List<String> dimensions = Arrays.asList("app_name", "app_mode", "server_ip", "src_id", "des_id", "command", "sub_command",
                "result", "start_time", "execute_time", "param", "extra_param", "client_type", "version", "msg_id", "type", "operator", "network",
                "model", "imei", "client_version", "client_ip", "port", "server_id", "router_name", "country", "birthday", "age", "gender",
                "living_location", "phonenumber_detail");
        Parser parser = new Parser()
                .setType("string")
                .setParseSpec(new ParseSpec()
                        .setFormat("tsv")
                        .setTimestampSpec(new TimestampSpec("log_time", "auto"))
                        .setDelimiter("\t")
                        .setColumns(columns)
                        .setDimensionsSpec(new DimensionsSpec(dimensions)));
        GranularitySpec granularitySpec = new GranularitySpec().setType("uniform")
                .setSegmentGranularity("hour")
                .setQueryGranularity("hour")
                .setIntervals("2017-08-21/2017-08-23")
                .setRollup(true);
        DataSchema dataSchema = new DataSchema().setDataSource(dataSource)
                .setParser(parser)
                .setGranularitySpec(granularitySpec)
                .setMetric(new Metric("chats", "count"));
        // 
        IoConfig ioConfig = new IoConfig()
                .setType("index")
                .setFirehose(new Firehose()
                        .setType("local")
                        .setBaseDir(dir)
                        .setFilter("*.log"));
        TuningConfig tuningConfig = new TuningConfig()
                .setType("index")
                .setMaxRowsInMemory(75000)
                //                .setTargetPartitionSize(100);
                .setNumShards(8);
        BatchIngestion chatsendIngest = new BatchIngestion()
                .setType("index")
                .setSpec(new Spec()
                        .setDataSchema(dataSchema)
                        .setIoConfig(ioConfig)
                        .setTuningConfig(tuningConfig));
        String response = Ingestion.ingestData(new JSONObject(chatsendIngest).toString());
        System.out.println(response);
    }

}

//   private static void execute() {
//        String dataSource = "wikipedia-tx-10";
//        String dir = "/home/bigdata/workspace/java/druid-breakdown/data/wiki/";
//        Parser parser = new Parser()
//                .setType("string")
//                .setParseSpec(new ParseSpec()
//                        .setFormat("json")
//                        .setTimestampSpec(new TimestampSpec("time", "auto"))
//                        .setDimensionsSpec(new DimensionsSpec(Arrays.asList("url", "user"))));
//        GranularitySpec granularitySpec = new GranularitySpec().setType("uniform")
//                .setSegmentGranularity("hour")
//                .setQueryGranularity("hour")
//                //                .setIntervals("2017-08-20/2017-08-23")
//                .setRollup(true);
//        DataSchema dataSchema = new DataSchema().setDataSource(dataSource)
//                .setParser(parser)
//                .setGranularitySpec(granularitySpec)
//                .setMetric(new Metric("views", "count"))
//                .setMetric(new Metric("latencyMs", "doubleSum", "latencyMs"));
//        // 
//        IoConfig ioConfig = new IoConfig()
//                .setType("index")
//                .setFirehose(new Firehose()
//                        .setType("local")
//                        .setBaseDir(dir)
//                        .setFilter("*.log"));
//        TuningConfig tuningConfig = new TuningConfig()
//                .setType("index")
//                .setMaxRowsInMemory(75000)
//                .setTargetPartitionSize(10000);
////                .setNumShards(8);
//        BatchIngestion wikiIngest = new BatchIngestion()
//                .setType("index")
//                .setSpec(new Spec()
//                        .setDataSchema(dataSchema)
//                        .setIoConfig(ioConfig)
//                        .setTuningConfig(tuningConfig));
//        String response = Ingestion.ingestData(new JSONObject(wikiIngest).toString());
//        System.out.println(response);
//    }
