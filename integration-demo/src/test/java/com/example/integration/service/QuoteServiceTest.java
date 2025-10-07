package com.example.integration.service;

import com.example.integration.client.ExternalApiClient;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

class QuoteServiceTest {

    static class StubClient extends ExternalApiClient {
        public StubClient() {
            super();
        }
        @Override
        public Mono<String> fetch() {
            return Mono.just("{\"quote\":\"stub-quote\"}");
        }
    }

    @Test
    void returnsDataFromClient() {
        var service = new QuoteService(new StubClient());
        var json = service.getQuote().block();
        assertThat(json).contains("stub-quote");
    }
}