package com.klachkova.spring.SensorImitation.actions.post;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

public class PostRequestWithJSONData {
    public static void makePostRequestWithJSONData(Map<String, Object> map, String url) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(map, headers);
        try {
            restTemplate.postForObject(url, request, String.class);
            System.out.println("...");
        } catch (
                HttpClientErrorException e) {
            System.out.println("Error! " + e.getMessage());
        }

    }
}
