package com.svetikov.webfluxtest.webClient;

import com.svetikov.webfluxtest.model.Greeting;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

public class GreetingWebClient {
    private WebClient client=WebClient.create("http://localhost:9000");

    private Mono<ClientResponse> result = client.get()
            .uri("/hello")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    private Mono<ClientResponse> resultGo = client.get()
            .uri("/go")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    private Flux<Greeting> findAll=client.get()
            .uri("/all")
        .retrieve()
          .bodyToFlux(Greeting.class);

    public String getResult(){
        return ">> result = "+result.flatMap(res->res.bodyToMono(String.class)).block()+"  @  "+ Instant.now();
    }
    public String getResultGo(){
        return ">> resultGo = "+resultGo.flatMap(res->res.bodyToMono(String.class)).block()+"  @  "+ Instant.now();
    }
    public Flux<Greeting> getAll(){
        return findAll;
    }
}
