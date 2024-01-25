package com.klachkova.spring.SensorImitation.actions.post;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.klachkova.spring.SensorImitation.actions.post.PostRequestWithJSONData.makePostRequestWithJSONData;

public class SensorRegistration {

    private String response = "";
    private Map<String, Object> sensorJsonToSend = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public SensorRegistration() {
    }

    public Map<String, Object> getSensorJsonToSend() {
        return sensorJsonToSend;
    }

    public void register ( String url) {
        System.out.println("Sensor registration: ");

        System.out.println("Enter new sensor's name: ");

        String sensorName = scanner.nextLine();

        sensorJsonToSend.put("name", sensorName);

        makePostRequestWithJSONData(sensorJsonToSend,url);
        }
    }

