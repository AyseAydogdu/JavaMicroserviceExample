package com.aydogdu.credit_score.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Ayse Aydogdu
 * @Date 8/10/2022 10:35 PM
 */
@Configuration
public class RestTemplateBean {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
