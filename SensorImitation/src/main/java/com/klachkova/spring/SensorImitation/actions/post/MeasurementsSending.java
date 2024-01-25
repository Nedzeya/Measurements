package com.klachkova.spring.SensorImitation.actions.post;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.klachkova.spring.SensorImitation.actions.post.PostRequestWithJSONData.makePostRequestWithJSONData;

public class MeasurementsSending {
    private final Random random = new Random();

    private final SensorRegistration sensorRegistration;
    private String response = "";


    public MeasurementsSending(SensorRegistration sensorRegistration) {
        this.sensorRegistration = sensorRegistration;
    }

    public void send10TimesRandom(String url) {
        System.out.println("Measurements sending: ");
        Map<String, Object> jsonToSendMeasurements = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            //min -100 max 100
            jsonToSendMeasurements.put("value", random.nextFloat() * 200 - 100);
            jsonToSendMeasurements.put("raining", random.nextBoolean());
            jsonToSendMeasurements.put("sensor", this.sensorRegistration.getSensorJsonToSend());

            makePostRequestWithJSONData(jsonToSendMeasurements, url);
            jsonToSendMeasurements.clear();
        }
        System.out.println(response);
    }
}
