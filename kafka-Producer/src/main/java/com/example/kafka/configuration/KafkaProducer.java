package com.example.kafka.configuration;


import java.time.Duration;
import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class KafkaProducer {

    @Bean
    public Supplier<Flux<Integer>> integerProducer() {
        return () -> {
            System.out.println("Inside integerProducer");
            return Flux.range(1, 500).log().delayElements(Duration.ofMillis(500));

        };
    }
}
