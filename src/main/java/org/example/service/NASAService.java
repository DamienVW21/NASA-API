package org.example.service;

import org.example.model.NeoFeedResponse;
import org.springframework.web.client.RestTemplate;

public class NASAService {
    // this class will send requests to NASA API and get back responses
    private RestTemplate restTemplate = new RestTemplate();
    // URL for API
    private final String API_URL = "https://api.nasa.gov/neo/rest/v1/feed?";

    private final String API_KEY = System.getenv("NASA_KEY");


    // Request to get all NEOs for a specified group of days
    public NeoFeedResponse getAllNeos(String startDate, String endDate){
        String url = API_URL + "start_date=" + startDate +
                "&end_date=" + endDate +
                "&api_key=" + API_KEY;

       // String response = restTemplate.getForObject(url, String.class); //.toString();
       // System.out.println(response);

        NeoFeedResponse response = restTemplate.getForObject(url, NeoFeedResponse.class);

        return response;
    }

}
