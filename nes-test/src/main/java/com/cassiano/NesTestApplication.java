package com.cassiano;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class NesTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(NesTestApplication.class, args);
    }
}
