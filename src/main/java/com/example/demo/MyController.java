package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class MyController {

    @GetMapping
    public Mono<String> greet(ServerWebExchange exchange) {
        return exchange.getPrincipal().map(principal -> "hello " + principal.getName());
    }
}
