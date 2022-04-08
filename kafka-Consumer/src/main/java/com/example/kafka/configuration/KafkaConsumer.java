package com.example.kafka.configuration;


import java.util.function.Consumer;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;

@Configuration
@EnableKafkaStreams
public class KafkaConsumer {

    @Bean
    public Consumer<KStream<String, Integer>> cubeConsumer() {
        System.out.println("Outside consumer");
        return stringIntegerKStream -> {
            System.out.println("Inside consumer");
            stringIntegerKStream.foreach((k, v) -> System.out.println(k + " : " + v));
        };
    }
}
