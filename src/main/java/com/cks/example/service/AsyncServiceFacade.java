package com.cks.example.service;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class AsyncServiceFacade {
    private final AsyncService asyncService;

    public void run(int count) {
        List<CompletableFuture<Void>> futureList = Lists.newArrayList();

        for (int i = 0; i < count; i++) {
            CompletableFuture<Void> future = asyncService.runAsync(i);
            futureList.add(future);
        }

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
    }
}
