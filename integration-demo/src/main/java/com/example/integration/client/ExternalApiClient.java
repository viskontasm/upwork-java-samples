package com.example.integration.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ExternalApiClient {
    private final WebClient client = WebClient.create("https://httpbin.org");

    public Mono<String> fetch() {
        return client.get().uri("/uuid").retrieve().bodyToMono(String.class);
    }
}