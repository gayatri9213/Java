package com.daily.report.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private static Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping(value = "/health")
    public Health healthCheck() {
        logger.info("Service health check");
        return Health.up().build();
    }
}
