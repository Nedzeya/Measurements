package com.klachkova.spring.SensorImitation.actions.get;

import org.springframework.web.client.RestTemplate;
import java.util.Map;

public class Temperature {
  private final  RestTemplate restTemplate = new RestTemplate();
    public Temperature() {

    }

    public Map getTemperature(String url){
        System.out.println("Temperature chart:");

     return restTemplate.getForObject(url, Map.class);
    }


}
