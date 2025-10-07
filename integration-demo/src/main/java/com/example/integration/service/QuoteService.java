package com.example.integration.service;

import com.example.integration.client.ExternalApiClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QuoteService {
    private final ExternalApiClient client;

    public QuoteService(ExternalApiClient client) {
        this.client = client;
    }

    public Mono<String> getQuote() {
        return client.fetch();
    }
}