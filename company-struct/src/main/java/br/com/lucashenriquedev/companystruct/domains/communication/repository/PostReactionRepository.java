package br.com.lucashenriquedev.companystruct.domains.communication.repository;

import br.com.lucashenriquedev.companystruct.domains.communication.model.PostReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReactionRepository extends JpaRepository<PostReaction, Long> {

}
