/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.druid.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static org.apache.http.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author bigdata
 */
public class Ingestion {

    private static final String INGESTION_URL = "http://localhost:8090/druid/indexer/v1/task";

    public static String ingestData(String command) {
        StringBuilder respInfo = new StringBuilder();
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(INGESTION_URL);
            // add header
            post.setHeader("User-Agent", USER_AGENT);
            StringEntity entity = new StringEntity(command);
            post.setEntity(entity);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = client.execute(post);
            respInfo.append(String.format("Response code: %s", response.getStatusLine().getStatusCode())).append("\n");
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = null;
            while ((line = rd.readLine()) != null) {
                respInfo.append(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respInfo.toString();
    }

}
