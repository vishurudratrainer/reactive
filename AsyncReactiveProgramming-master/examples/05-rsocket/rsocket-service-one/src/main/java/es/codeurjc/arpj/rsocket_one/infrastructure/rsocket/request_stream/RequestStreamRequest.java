package es.codeurjc.arpj.rsocket_one.infrastructure.rsocket.request_stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestStreamRequest {

    private String message;

    private String author;
}
