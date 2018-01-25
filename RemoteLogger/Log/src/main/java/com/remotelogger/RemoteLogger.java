package com.remotelogger;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.TableId;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by Aditya on 16/08/17.
 */

public class RemoteLogger {

    private static TableId tableId;
    private static Dataset  ds ;
    private static BigQuery bigquery;

    public static void init(Context cxt)
    {

        GoogleCredentials credentials = null;
        InputStream inputStream = null;
        AssetManager am = cxt.getAssets();
        try {
             inputStream = am.open("Logging Project-4806dced8f35.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            credentials = ServiceAccountCredentials.fromStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //initialize the logger here get reference to Big query database and keep it open

         bigquery = BigQueryOptions.newBuilder().setProjectId("acoustic-realm-176205").setCredentials(credentials).build().getService();
         ds = bigquery.getDataset("applogger");
        tableId = TableId.of("applogger" ,"devicelogs");

    }


    public static void i(String tag, String data)
    {


    }


    public static void d(String tag, String data)
    {

    }

    public static void e(String tag , String data)
    {

    }


    /**
     * 0 - Crash
     * 1 - Operational error
     * 2 - Invalid error code
     * 3 - Operation timed out
     * 4 - test
     * @param tag
     * @param data
     * @param type
     */
    public static void issue(String tag, String data, int type)
    {
        Map<String, Object> myMap=  RemoteLoggerHelper.getTupleContents("TEST_EVENT",type,data);
        InsertAllRequest insertRequest = InsertAllRequest.newBuilder(tableId)
                 .addRow(myMap)
                 .addRow(myMap)
                 .build();


        InsertAllResponse insertResponse = bigquery.insertAll(insertRequest);
        if (insertResponse.hasErrors()) {
            System.out.println("Errors occurred while inserting rows");
        }
    }

}
