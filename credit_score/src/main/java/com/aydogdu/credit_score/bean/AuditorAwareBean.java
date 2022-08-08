package com.aydogdu.creditscore.bean;

import com.aydogdu.creditscore.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * @Author Ayse Aydogdu
 * @Date 7/21/2022 11:25 AM
 */
@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorAware")
public class AuditorAwareBean {

    @Bean
    public AuditorAware<String> auditorAware(){

        return new AuditorAwareImpl();
    }
}
