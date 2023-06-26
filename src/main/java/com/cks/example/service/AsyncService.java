package com.cks.example.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncService {
    @Async("customTaskExecutor")
    public CompletableFuture<Void> runAsync(int index) {
        CompletableFuture<Void> feature = new CompletableFuture<>();
        System.out.println("running %d".formatted(index));
        feature.complete(null);
        return feature;
    }
}
