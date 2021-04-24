package br.com.lucashenriquedev.companystruct.config.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        Optional<Object> us = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal);

        if (us.isEmpty()) {
            return Optional.empty();
        } else if (us.get() instanceof String) {
            return Optional.of( (String) us.get());
        }

        return Optional.empty();

    }

}
