package com.tinqin.academy.piim.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.tinqin.academy.piim.ext"})
@ComponentScan(basePackages = {"com.tinqin.academy.piim"})
@EntityScan(basePackages = {"com.tinqin.academy.piim.data.models"})
@EnableJpaRepositories(basePackages = {"com.tinqin.academy.piim.data.repositories"})
public class PiimApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiimApplication.class, args);
    }
}
