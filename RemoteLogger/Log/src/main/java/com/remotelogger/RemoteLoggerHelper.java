package com.remotelogger;

import android.os.Build;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Aditya on 16/08/17.
 */

public class RemoteLoggerHelper {



    public static int i=0;


    public static Map<String ,Object> getTupleContents(String eventId, int eventType , String data)
    {

        Map<String, Object> firstRow = new HashMap<>();
        firstRow.put("event_name", "Sample event");
        firstRow.put("event_id", eventId);
        firstRow.put("identifier", new Random().nextInt(1000));
        firstRow.put("device_name", "Aditya_testdevice");
         if(i%2 == 0)
            firstRow.put("appversion", "4.3");
        else
             firstRow.put("appversion", "4.1");

        firstRow.put("type", eventType);
        firstRow.put("payload",data);
        firstRow.put("osversion", "Android : " + Build.VERSION.SDK_INT);
        i++;
        return firstRow;
    }

}
