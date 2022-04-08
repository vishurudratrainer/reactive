package com.vishwa.webfluxsse.producer;

import lombok.Data;

import java.io.Serializable;

@Data
public class Todo implements Serializable {

    private static final String Todo_FORMAT = "Q: %s \nA: %s";

    private String userId;
    private String id;
    private String completed;
    private String title;

    @Override
    public String toString() {
        return String.format(Todo_FORMAT, this.title, this.completed);
    }

}
