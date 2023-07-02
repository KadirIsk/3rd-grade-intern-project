package com.cks.example.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class PingJob {
    private final WebClient customWebClient;

    @Scheduled(cron = "0 * * * * ?")
    public void run() {
        log.info("Ping servis cagirimi yapiliyor...");

        String resp = customWebClient
                .get()
                .uri(uriBuilder -> uriBuilder.pathSegment("health-check","ping").build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> Mono.error(new RuntimeException("Ping servisi cagirimi hatali!")))
                .bodyToMono(String.class)
                .block();

        log.info("Ping servis cagirim sonucu: {}", resp);
    }
}
