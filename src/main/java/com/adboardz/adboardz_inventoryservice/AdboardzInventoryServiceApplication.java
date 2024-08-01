package com.adboardz.adboardz_inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AdboardzInventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdboardzInventoryServiceApplication.class, args);
    }

}
