package com.logikcode.movieservicewithwebflux.controller;

import com.logikcode.movieservicewithwebflux.config.ServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor

public class MovieController {
private final ServiceClient service;
    @GetMapping("/flux")
    public Flux<Integer> flux(){
        return Flux.just(1,2,3).log();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Long> stream(){
        return Flux.interval(Duration.ofSeconds(1)).log();
    }

    @GetMapping("/movies")
    public void handleMovieRetrieval(@RequestParam("id") String id){
        // simulate calling another service

    }
}
