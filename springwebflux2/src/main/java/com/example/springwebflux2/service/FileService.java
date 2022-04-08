package com.example.springwebflux2.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.stream.Stream;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FileService {

    public Mono<ServerResponse> readLinesFromFile(ServerRequest serverRequest){
        String path = "";
        Path file = Paths.get(path);
        Flux<String> lineFlux = Flux.using(() -> Files.lines(file),
                Flux::fromStream,
                Stream::close);
        return ServerResponse.ok().contentType(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE)).body(lineFlux.delayElements(Duration.ofMillis(1000)),String.class);
    }
}
