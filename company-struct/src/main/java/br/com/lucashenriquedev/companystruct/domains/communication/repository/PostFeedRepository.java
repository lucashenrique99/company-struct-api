package br.com.lucashenriquedev.companystruct.domains.communication.repository;

import br.com.lucashenriquedev.companystruct.domains.communication.model.PostFeed;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostFeedRepository extends JpaRepository<PostFeed, Long> {

    @Query("SELECT p FROM PostFeed p WHERE p.isVisible = TRUE")
    List<PostFeed> findAllIsVisible(Pageable pageable);

}
