package org.example.service;

import org.springframework.web.client.RestTemplate;

public class NASAService {
    // this class will send requests to NASA API and get back responses
    private RestTemplate restTemplate = new RestTemplate();
    // URL for API
    private final String API_URL = "https://api.nasa.gov/neo/rest/v1/feed?";

    private final String API_KEY = System.getenv("NASA_KEY");

}
