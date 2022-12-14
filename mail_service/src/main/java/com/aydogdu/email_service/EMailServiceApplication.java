package com.aydogdu.email_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories
public class EMailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EMailServiceApplication.class, args);
    }

}
