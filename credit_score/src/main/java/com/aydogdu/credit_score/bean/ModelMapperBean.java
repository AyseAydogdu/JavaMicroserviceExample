package com.aydogdu.creditscore.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 7:47 PM
 */
@Configuration
public class ModelMapperBean {
    @Bean
    ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
