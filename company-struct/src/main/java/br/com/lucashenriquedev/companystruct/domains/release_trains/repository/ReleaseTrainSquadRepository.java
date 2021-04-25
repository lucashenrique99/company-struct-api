package br.com.lucashenriquedev.companystruct.domains.release_trains.repository;

import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrain;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainSquad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleaseTrainSquadRepository extends JpaRepository<ReleaseTrainSquad, Long> {

    List<ReleaseTrainSquad> findByReleaseTrain(ReleaseTrain releaseTrain);

}
