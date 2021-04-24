package br.com.lucashenriquedev.companystruct.config.db;

import br.com.lucashenriquedev.companystruct.config.audit.AuditorAwareImpl;
import br.com.lucashenriquedev.companystruct.modules.employees.repository.EmployeeRepository;
import br.com.lucashenriquedev.companystruct.modules.squads.repository.SquadMemberRepository;
import br.com.lucashenriquedev.companystruct.modules.squads.repository.SquadRepository;
import br.com.lucashenriquedev.companystruct.modules.users.repository.AbstractUserRepository;
import br.com.lucashenriquedev.companystruct.modules.users.repository.PermissionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.ZonedDateTime;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@EnableJpaRepositories(basePackageClasses = {
        AbstractUserRepository.class,
        PermissionRepository.class,
        EmployeeRepository.class,
        SquadRepository.class,
        SquadMemberRepository.class
})

public class DBConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }
}
