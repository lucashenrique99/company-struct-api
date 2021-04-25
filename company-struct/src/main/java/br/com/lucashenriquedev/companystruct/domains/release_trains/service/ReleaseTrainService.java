package br.com.lucashenriquedev.companystruct.domains.release_trains.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.domains.communities.messages.CommunityMessages;
import br.com.lucashenriquedev.companystruct.domains.communities.service.CommunityService;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrain;
import br.com.lucashenriquedev.companystruct.domains.release_trains.repository.ReleaseTrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReleaseTrainService extends AbstractCRUDService<ReleaseTrain, ReleaseTrainRepository> {

    @Autowired
    private ReleaseTrainResponsibleService releaseTrainResponsibleService;

    @Autowired
    private CommunityService communityService;

    @Override
    public Optional<ReleaseTrain> insert(ReleaseTrain releaseTrain) {
        releaseTrain.setCommunity(communityService.findById(releaseTrain.getCommunity().getId())
                .orElseThrow(() -> new IllegalArgumentException(CommunityMessages.COMMUNITY_NOT_FOUND)));

        var responsible = releaseTrain.getResponsible();
        var saved = repository.save(releaseTrain);
        responsible.forEach(resp -> {
            resp.setReleaseTrain(saved);
            releaseTrainResponsibleService.insert(resp);
        });

        return Optional.of(saved);
    }

    public Optional<ReleaseTrain> update(Long id, ReleaseTrain releaseTrain) {
        return repository.findById(id)
                .map(saved -> {
                    saved.setName(releaseTrain.getName());
                    saved.setNotes(releaseTrain.getNotes());
                    saved.setManager(releaseTrain.getManager());
                    saved.setCommunity(communityService.findById(releaseTrain.getCommunity().getId())
                            .orElseThrow(() -> new IllegalArgumentException(CommunityMessages.COMMUNITY_NOT_FOUND)));

                    return repository.save(saved);
                });
    }
}
