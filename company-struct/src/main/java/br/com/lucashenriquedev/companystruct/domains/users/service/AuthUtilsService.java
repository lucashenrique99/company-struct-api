package br.com.lucashenriquedev.companystruct.domains.users.service;

import br.com.lucashenriquedev.companystruct.domains.users.factory.PermissionFactory;
import br.com.lucashenriquedev.companystruct.domains.users.model.Permission;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthUtilsService {

    public Boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    public Optional<String> getCurrentUsername() {
        if (isAuthenticated()) {
            return Optional.of(SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getName());
        }
        return Optional.empty();
    }

    public Set<Permission> getCurrentAuthorities() {
        if (isAuthenticated()) {
            return SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getAuthorities()
                    .stream()
                    .map(r -> PermissionFactory.create(r.getAuthority()))
                    .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

}
