package com.aydogdu.customer.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Ayse Aydogdu
 * @Date 7/21/2022 11:16 AM
 */
@Configuration
public class ModelMapperBean {
    @Bean
    ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
