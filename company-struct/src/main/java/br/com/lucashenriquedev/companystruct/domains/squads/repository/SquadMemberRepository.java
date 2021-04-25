package br.com.lucashenriquedev.companystruct.domains.squads.repository;

import br.com.lucashenriquedev.companystruct.domains.squads.model.Squad;
import br.com.lucashenriquedev.companystruct.domains.squads.model.SquadMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquadMemberRepository extends JpaRepository<SquadMember, Long> {

    List<SquadMember> findBySquad(Squad squad);

}
