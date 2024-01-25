package com.klachkova.spring.SensorImitation.actions.get;

import com.klachkova.spring.SensorImitation.models.MeasurementResponse;
import org.springframework.web.client.RestTemplate;
public class AllMeasurements {
    private final RestTemplate restTemplate = new RestTemplate();
    public AllMeasurements() {
    }
    public int count(String url){
        System.out.println("Getting all measurements: ");
       return restTemplate.getForObject(url, MeasurementResponse.class).getMeasurements().size();
    }
}
