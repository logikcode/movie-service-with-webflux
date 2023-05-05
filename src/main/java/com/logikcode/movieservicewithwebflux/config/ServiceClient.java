package com.logikcode.movieservicewithwebflux.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class ServiceClient {
    @Value("${restClient.serviceUrl}")
    private String baseUrl;

    private  WebClient webClient;

    public ServiceClient(WebClient webClient){
        this.webClient = webClient;
    }

    public Flux<List<Object>> retrieveAllFilesById(long id){

        /* dynamically building url for webclient use */
        String dynamicallyUrl = UriComponentsBuilder.fromHttpUrl("theUrl")
                .queryParam("theParamKey", id)
                .buildAndExpand().toUriString();


        Flux<Object[]> response = webClient
                .get()
                .uri(dynamicallyUrl)
                .retrieve()
                .bodyToFlux(Object[].class)
                .log();
        List<Object> objectList= Arrays.asList(response);
        return null;
    }

    public Mono<Object> retrieveImagesById(long id){

        /* building web client url with PathVariable ex */
        String url = baseUrl.concat("/{id}");

        Mono<Object> response = webClient
                .get()
                .uri(url, id)
                .retrieve()// retrieve func is actually one making the call to get data
                .bodyToMono(Object.class)
                .log();

        return null;
    }
}
