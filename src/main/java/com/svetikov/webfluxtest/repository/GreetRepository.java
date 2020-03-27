package com.svetikov.webfluxtest.repository;


import com.svetikov.webfluxtest.model.Greeting;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


import java.util.List;
import java.util.UUID;

@Repository
public class GreetRepository {

 List<Greeting> greetingList= List.of(new Greeting(UUID.randomUUID().toString(),"hi spring"),
            new Greeting(UUID.randomUUID().toString(),"hello rSocket spring"),
            new Greeting(UUID.randomUUID().toString(),"go to java"));

    public Flux<Greeting> allGreet(){
        return Flux.fromStream(greetingList.stream());
    }
}
