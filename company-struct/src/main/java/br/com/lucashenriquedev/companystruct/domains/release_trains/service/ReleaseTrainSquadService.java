package br.com.lucashenriquedev.companystruct.domains.release_trains.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.domains.release_trains.messages.ReleaseTrainMessages;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrain;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainSquad;
import br.com.lucashenriquedev.companystruct.domains.release_trains.repository.ReleaseTrainSquadRepository;
import br.com.lucashenriquedev.companystruct.domains.squads.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseTrainSquadService extends AbstractCRUDService<ReleaseTrainSquad, ReleaseTrainSquadRepository> {

    @Autowired
    private SquadService squadService;

    @Autowired
    private ReleaseTrainService releaseTrainService;

    @Autowired
    private ReleaseTrainResponsibleService releaseTrainResponsibleService;

    public List<ReleaseTrainSquad> findByReleaseTrain(ReleaseTrain releaseTrain) {
        return repository.findByReleaseTrain(releaseTrain);
    }

    @Override
    public Optional<ReleaseTrainSquad> insert(ReleaseTrainSquad squad) {
        squad.setSquad(squadService.findById(squad.getSquad().getId())
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.RELEASE_TRAIN_SQUAD_NOT_FOUND)));

        squad.setReleaseTrain(releaseTrainService.findById(squad.getReleaseTrain().getId())
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.RELEASE_TRAIN_NOT_FOUND)));

        squad.setResponsible(squad.getReleaseTrain().getResponsible()
                .stream()
                .filter(resp -> resp.equals(squad.getResponsible()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.RELEASE_TRAIN_RESPONSIBLE_NOT_FOUND)));


        return Optional.of(repository.save(squad));
    }

    public Optional<ReleaseTrainSquad> update(Long id, ReleaseTrainSquad squad) {
        return repository.findById(id)
                .map(saved -> {
                    saved.setResponsible(saved.getReleaseTrain().getResponsible()
                            .stream()
                            .filter(resp -> resp.equals(squad.getResponsible()))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.RELEASE_TRAIN_RESPONSIBLE_NOT_FOUND)));
                    saved.setNotes(squad.getNotes());

                    return repository.save(saved);
                });
    }

}
