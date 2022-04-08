package com.vishwa.webfluxsse.config;

import com.vishwa.webfluxsse.producer.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class AppConfiguration {

    private static final String API_ENDPOINT =
            "https://jsonplaceholder.typicode.com/todos";

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                    .baseUrl(API_ENDPOINT)
                    .build();
    }

    @Bean
    public Sinks.Many<Todo> sink(){
        return Sinks.many().replay().latest();
    }

    @Bean
    public Flux<Todo> flux(Sinks.Many<Todo> sink){
        return sink.asFlux().cache();
    }

}
