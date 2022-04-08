package com.example.kafka.configuration;


import java.util.function.Function;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProcessor {

    @Bean
    public Function<KStream<String, Integer>, KStream<String, Integer>> cubeProcessor() {
        return stringIntegerKStream -> {
            System.out.println("Inside cubeProcessor");
            return  stringIntegerKStream.mapValues(integer -> integer * integer * integer);
        };
    }
}
