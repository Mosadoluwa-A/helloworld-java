package com.poc.helloworld.service;

import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.text.SimpleDateFormat;

@Service
public class HelloWorldService {

    @SneakyThrows
    public JSONObject fetchRightGreeting() throws JSONException {
        Calendar calendar = Calendar.getInstance();

        // Get current date and time
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
        String currentDate = dateFormatter.format(calendar.getTime());

        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String currentTime = timeFormatter.format(calendar.getTime());

    // Determine the time period (morning afternoon,  evening)
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    String period;
    if (hour >0 && hour < 12) {
            period = "Morning";
    } else if (hour >12 && hour < 16){
            period = "Afternoon";
    } else {
            period = "Evening";
        }

    // Create a JSON object
    JSONObject json = new JSONObject();
    json.put("date", currentDate);
    json.put("time", currentTime);
    json.put("greeting", "Hello World! Good " + period);
    System.out.println ("json response" + json);
    return json;
    }


    public String getTimeOfDay () {
        Calendar calendar = Calendar.getInstance();

        // Get Current Date and Time
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
        String currentDate = dateFormatter.format(calendar.getTime());

        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String currentTime = timeFormatter.format(calendar.getTime());

        //Determine the response Morning, Afternoon, or Evening
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String period;

        if (hour >0 && hour < 12) {
            period = "Morning";
        } else if (hour >12 && hour <16) {
            period = "Afternoon";

        } else {
            period = "Evening";
        }

        // Return Formatted Message
        return  "Hello World! Today's date is " + currentDate + ". The time is " + currentTime + ". Good " + period + ".";
    }



}
