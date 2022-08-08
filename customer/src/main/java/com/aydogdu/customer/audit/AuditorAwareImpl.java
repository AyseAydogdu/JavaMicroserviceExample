package com.aydogdu.customer.audit;

/**
 * @Author Ayse Aydogdu
 * @Date 7/21/2022 10:59 AM
 */

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Ayse Aydogdu");
    }
}
