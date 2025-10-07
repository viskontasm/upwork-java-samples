package com.example.integration.web;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.example.integration.service.QuoteService;

@RestController
public class QuoteController {
    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping("/api/quote")
    public Mono<String> get() {
        return service.getQuote();
    }
}