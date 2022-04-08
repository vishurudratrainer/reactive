package com.example.springwebflux1.service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlternateReactiveService {

    public List<Mono<String>> getAll(){
        List<Mono<String>> list = new ArrayList<>();
        for(int i = 0 ; i<5 ; i++){
            list.add(Mono.just(i+""));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


}
