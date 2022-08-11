package com.aydogdu.credit_score.audit;

/**
 * @Author Ayse Aydogdu
 * @Date 7/21/2022 11:24 AM
 */
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Ayse Aydogdu");
    }
}
