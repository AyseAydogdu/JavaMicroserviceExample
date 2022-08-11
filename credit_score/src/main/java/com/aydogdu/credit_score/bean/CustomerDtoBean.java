package com.aydogdu.credit_score.bean;

import com.aydogdu.customer.business.dto.CustomerDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Ayse Aydogdu
 * @Date 8/11/2022 3:49 PM
 */
@Configuration
public class CustomerDtoBean {

    @Bean
    CustomerDto customerDto()
    {
        return new CustomerDto();
    }
}
