package com.tinqin.academy.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.tinqin.academy"})
@EntityScan(basePackages = {"com.tinqin.academy.data.models"})
@EnableJpaRepositories(basePackages = {"com.tinqin.academy.data.repositories"})
public class PiimApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiimApplication.class, args);
    }

}