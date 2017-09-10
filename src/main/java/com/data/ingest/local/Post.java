/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.ingest.local;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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
public class Post {

    private static final Gson GSON = new Gson();

    public static void sendPost(String tag, Object message) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("text", String.format("[%s]: %s", tag, GSON.toJson(message)));
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("https://hooks.slack.com/services/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");
            // add header
            post.setHeader("User-Agent", USER_AGENT);
            StringEntity entity = new StringEntity(GSON.toJson(map));
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
