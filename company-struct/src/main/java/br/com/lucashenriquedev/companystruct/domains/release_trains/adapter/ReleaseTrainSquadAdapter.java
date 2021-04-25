package br.com.lucashenriquedev.companystruct.domains.release_trains.adapter;

import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.InsertReleaseTrainSquadRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.UpdateReleaseTrainSquadRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.ReleaseTrainSquadResponse;
import br.com.lucashenriquedev.companystruct.domains.release_trains.factory.ReleaseTrainFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.factory.ReleaseTrainResponsibleFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainSquad;
import br.com.lucashenriquedev.companystruct.domains.squads.adapter.SquadAdapter;
import br.com.lucashenriquedev.companystruct.domains.squads.factory.SquadFactory;

public class ReleaseTrainSquadAdapter {

    public static ReleaseTrainSquad from(Long releaseTrain, InsertReleaseTrainSquadRequest request) {
        return ReleaseTrainSquad.builder()
                .releaseTrain(ReleaseTrainFactory.create(releaseTrain))
                .responsible(ReleaseTrainResponsibleFactory.create(request.getResponsible()))
                .squad(SquadFactory.create(request.getSquad()))
                .notes(request.getNotes())
                .build();
    }

    public static ReleaseTrainSquad from(Long releaseTrain, UpdateReleaseTrainSquadRequest request) {
        return ReleaseTrainSquad.builder()
                .releaseTrain(ReleaseTrainFactory.create(releaseTrain))
                .responsible(ReleaseTrainResponsibleFactory.create(request.getResponsible()))
                .notes(request.getNotes())
                .build();
    }

    public static ReleaseTrainSquadResponse toResponse(ReleaseTrainSquad squad) {
        return ReleaseTrainSquadResponse.builder()
                .id(squad.getId())
                .squad(SquadAdapter.toProjection(squad.getSquad()))
                .responsible(ReleaseTrainResponsibleAdapter.toResponse(squad.getResponsible()))
                .notes(squad.getNotes())
                .build();
    }

}
