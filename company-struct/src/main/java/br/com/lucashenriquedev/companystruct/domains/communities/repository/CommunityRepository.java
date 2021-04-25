package br.com.lucashenriquedev.companystruct.domains.communities.repository;

import br.com.lucashenriquedev.companystruct.domains.communities.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
}
