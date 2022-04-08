package com.example.springwebflux1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NormalService {

    public List<String> getAll() {
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i<5 ; i++){
            list.add(i+"");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
