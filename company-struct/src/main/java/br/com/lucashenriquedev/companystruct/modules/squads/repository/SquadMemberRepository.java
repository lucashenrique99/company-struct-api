package br.com.lucashenriquedev.companystruct.modules.squads.repository;

import br.com.lucashenriquedev.companystruct.modules.squads.model.SquadMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadMemberRepository extends JpaRepository<SquadMember, Long> {
}