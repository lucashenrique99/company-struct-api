package br.com.lucashenriquedev.companystruct.domains.communication.repository;

import br.com.lucashenriquedev.companystruct.domains.communication.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

}
