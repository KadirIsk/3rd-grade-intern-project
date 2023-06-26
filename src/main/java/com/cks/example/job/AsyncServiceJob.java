package com.cks.example.job;

import com.cks.example.service.AsyncServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AsyncServiceJob {
    private final AsyncServiceFacade asyncServiceFacade;

    @Scheduled(cron = "0 * * * * ?")
    public void run() {
        asyncServiceFacade.run(8);
    }
}
