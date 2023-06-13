package com.tinqin.academy.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tinqin.academy"})
@EntityScan(basePackages = {"com.tinqin.academy.data.models"})
@EnableJpaRepositories(basePackages = {"com.tinqin.academy.data.repositories"})
public class PiimApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiimApplication.class, args);
    }

}
