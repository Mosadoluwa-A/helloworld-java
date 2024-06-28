package com.poc.helloworld.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldServiceTest {

    private HelloWorldService helloWorldService;

    @BeforeEach
    void setUp() {
        helloWorldService = new HelloWorldService();
    }

    @SneakyThrows
    @Test
    void testFetchRightGreeting() throws JSONException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");

        String currentDate = dateFormatter.format(calendar.getTime());
        String currentTime = timeFormatter.format(calendar.getTime());

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String period;
        if (hour >= 0 && hour < 12) {
            period = "Morning";
        } else if (hour >= 12 && hour < 16) {
            period = "Afternoon";
        } else {
            period = "Evening";
        }

        JSONObject expectedJson = new JSONObject();
        expectedJson.put("date", currentDate);
        expectedJson.put("time", currentTime);
        expectedJson.put("greeting", "Hello World! Good " + period);

        JSONObject actualJson = helloWorldService.fetchRightGreeting();

        assertEquals(expectedJson.toString(), actualJson.toString());
    }

    @Test
    void testGetTimeOfDay() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");

        String currentDate = dateFormatter.format(calendar.getTime());
        String currentTime = timeFormatter.format(calendar.getTime());

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String period;
        if (hour >= 0 && hour < 12) {
            period = "Morning";
        } else if (hour >= 12 && hour < 16) {
            period = "Afternoon";
        } else {
            period = "Evening";
        }

        String expectedGreeting = "Hello World! Today's date is " + currentDate + ". The time is " + currentTime + ". Good " + period + ".";

        String actualGreeting = helloWorldService.getTimeOfDay();

        assertEquals(expectedGreeting, actualGreeting);
    }
}
