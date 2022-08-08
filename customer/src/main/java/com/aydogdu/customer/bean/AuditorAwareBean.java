package com.aydogdu.customer.bean;

/**
 * @Author Ayse Aydogdu
 * @Date 7/21/2022 11:02 AM
 */
import com.aydogdu.customer.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorAwareBean {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
