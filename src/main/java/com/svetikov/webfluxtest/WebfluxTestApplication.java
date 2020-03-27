package com.svetikov.webfluxtest;

import com.svetikov.webfluxtest.webClient.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;

@SpringBootApplication
public class WebfluxTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxTestApplication.class, args);
        GreetingWebClient gwc=new GreetingWebClient();
        System.out.println(gwc.getResult());
        System.out.println(gwc.getResultGo());
     gwc.getAll().toStream().forEach(System.out::println);
    }

}
