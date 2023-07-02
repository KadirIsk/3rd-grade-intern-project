package com.cks.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health-check")
public class PingController {
    @GetMapping("ping")
    public ResponseEntity<String> pong() {
        return ResponseEntity.ok("pong");
    }
}
