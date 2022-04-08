package com.tcs;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class FutureEG implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Hello";
    }
}
