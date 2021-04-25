package br.com.lucashenriquedev.companystruct.config.db;

import br.com.lucashenriquedev.companystruct.config.audit.AuditorAwareImpl;
import br.com.lucashenriquedev.companystruct.domains.communication.repository.PostCommentRepository;
import br.com.lucashenriquedev.companystruct.domains.communication.repository.PostFeedRepository;
import br.com.lucashenriquedev.companystruct.domains.communication.repository.PostReactionRepository;
import br.com.lucashenriquedev.companystruct.domains.communities.repository.CommunityRepository;
import br.com.lucashenriquedev.companystruct.domains.employees.repository.EmployeeRepository;
import br.com.lucashenriquedev.companystruct.domains.release_trains.repository.ReleaseTrainRepository;
import br.com.lucashenriquedev.companystruct.domains.release_trains.repository.ReleaseTrainResponsibleRepository;
import br.com.lucashenriquedev.companystruct.domains.release_trains.repository.ReleaseTrainSquadRepository;
import br.com.lucashenriquedev.companystruct.domains.squads.repository.SquadMemberRepository;
import br.com.lucashenriquedev.companystruct.domains.squads.repository.SquadRepository;
import br.com.lucashenriquedev.companystruct.domains.users.repository.AbstractUserRepository;
import br.com.lucashenriquedev.companystruct.domains.users.repository.PermissionRepository;
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
        SquadMemberRepository.class,
        ReleaseTrainRepository.class,
        ReleaseTrainResponsibleRepository.class,
        ReleaseTrainSquadRepository.class,
        CommunityRepository.class,
        PostReactionRepository.class,
        PostCommentRepository.class,
        PostFeedRepository.class
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
