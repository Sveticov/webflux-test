package com.svetikov.webfluxtest.rescontroller;

import com.svetikov.webfluxtest.model.Greeting;
import com.svetikov.webfluxtest.repository.GreetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class GreetController {
    private final GreetRepository greetRepository;

    public GreetController(GreetRepository greetRepository) {
        this.greetRepository = greetRepository;
    }

    @GetMapping("/all")
    public Flux<Greeting> findAll(){
        return greetRepository.allGreet();
    }
}
