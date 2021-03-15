package com.example.demo;

import io.micrometer.core.instrument.Tag;
import org.springframework.boot.actuate.metrics.web.reactive.server.WebFluxTagsContributor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdditionalTagsContributor implements WebFluxTagsContributor {
    @Override
    public Iterable<Tag> httpRequestTags(ServerWebExchange exchange, Throwable ex) {
        List<Tag> additionalTags = new ArrayList<>();
        exchange.getPrincipal().subscribe(principal -> {
           additionalTags.add(Tag.of("user", principal.getName()));
        });
        return additionalTags;
    }
}
