package com.project.chatconnect.configs.security.auditing;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The type Spring security auditor aware.
 *
 * @author Huy Dang
 */
@Component
@Primary
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    /**
     * get current auditor.
     *
     * @return the current auditor
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("System");
        }
        return Optional.of(authentication.getName());
    }
}
