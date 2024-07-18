package org.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ExchangeService {

    private final String API_URL = "https://api.fastforex.io/time-series?from=CZK&to=HUF&interval=P1D&api_key=395478266a-5ad28f3d5c-sgtkw9";


    public String getExchangeRates() {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL);

        return restTemplate.getForObject(uriBuilder.toUriString(), String.class);
    }
}