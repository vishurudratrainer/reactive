package com.example.springwebflux2.config;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

import com.example.springwebflux2.service.FileService;
import com.example.springwebflux2.service.NonControllerReactiveService;
import com.example.springwebflux2.service.ReactiveService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration(proxyBeanMethods = false)
public class AppConfig {
    @Bean
    public RouterFunction<ServerResponse> route(
            NonControllerReactiveService nonControllerReactiveService, ReactiveService reactiveService, FileService fileService){
        return RouterFunctions.route(
                GET("/sample").and(accept(MediaType.ALL)), nonControllerReactiveService::sendResponce)
                .andRoute(GET("/fluxStream"), reactiveService::getAll)
                .andRoute(GET("/readLines"), fileService::readLinesFromFile);
    }
}
