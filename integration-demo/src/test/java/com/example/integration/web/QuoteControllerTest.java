package com.example.integration.web;

import com.example.integration.service.QuoteService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@WebFluxTest(controllers = QuoteController.class)
class QuoteControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private QuoteService quoteService;

    @Test
    void get_returnsQuote() {
        BDDMockito.given(quoteService.getQuote()).willReturn(Mono.just("{\"quote\":\"ok\"}"));

        webTestClient.get()
                .uri("/api/quote")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> {
                    org.assertj.core.api.Assertions.assertThat(body).contains("\"quote\":\"ok\"");
                });
    }
}