package com.svetikov.webfluxtest.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class GreetingRouter {
    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),greetingHandler::hello);
    }
    @Bean
    public RouterFunction<ServerResponse> routeGo(GreetingHandler greetingHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/go").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),greetingHandler::go);
    }


}
