package com.example.springwebflux1.config;



import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import com.example.springwebflux1.service.NonControllerReactiveService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration(proxyBeanMethods = false)
public class AppConfig {
    @Bean
    public RouterFunction<ServerResponse> route(NonControllerReactiveService nonControllerReactiveService){
        return RouterFunctions.route(
                GET("/sample").and(accept(MediaType.ALL)), nonControllerReactiveService::sendResponce);
    }
}
