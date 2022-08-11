package com.aydogdu.email_service.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Ayse Aydogdu
 * @Date 8/10/2022 9:17 AM
 */
@Configuration
public class ModelMapperBean {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
