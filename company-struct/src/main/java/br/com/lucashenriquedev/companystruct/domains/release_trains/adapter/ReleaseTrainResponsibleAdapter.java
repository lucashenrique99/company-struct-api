package br.com.lucashenriquedev.companystruct.domains.release_trains.adapter;

import br.com.lucashenriquedev.companystruct.domains.employees.adapter.EmployeeAdapter;
import br.com.lucashenriquedev.companystruct.domains.employees.factory.EmployeeFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.InsertReleaseTrainResponsibleRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.UpdateReleaseTrainResponsibleRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.ReleaseTrainResponsibleResponse;
import br.com.lucashenriquedev.companystruct.domains.release_trains.factory.ReleaseTrainFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainResponsible;

public class ReleaseTrainResponsibleAdapter {

    public static ReleaseTrainResponsible from(Long releaseTrain, InsertReleaseTrainResponsibleRequest request) {
        return ReleaseTrainResponsible.builder()
                .releaseTrain(ReleaseTrainFactory.create(releaseTrain))
                .employee(EmployeeFactory.create(request.getEmployee()))
                .notes(request.getNotes())
                .role(request.getRole())
                .build();
    }

    public static ReleaseTrainResponsible from(Long releaseTrain, UpdateReleaseTrainResponsibleRequest request) {
        return ReleaseTrainResponsible.builder()
                .releaseTrain(ReleaseTrainFactory.create(releaseTrain))
                .employee(EmployeeFactory.create(request.getEmployee()))
                .role(request.getRole())
                .notes(request.getNotes())
                .build();
    }

    public static ReleaseTrainResponsibleResponse toResponse(ReleaseTrainResponsible responsible) {
        return ReleaseTrainResponsibleResponse.builder()
                .id(responsible.getId())
                .employee(EmployeeAdapter.to(responsible.getEmployee()))
                .role(responsible.getRole())
                .notes(responsible.getNotes())
                .build();
    }

}
