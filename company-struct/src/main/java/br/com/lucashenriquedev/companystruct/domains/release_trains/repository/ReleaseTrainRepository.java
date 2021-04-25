package br.com.lucashenriquedev.companystruct.domains.release_trains.repository;

import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseTrainRepository extends JpaRepository<ReleaseTrain, Long> {
}
