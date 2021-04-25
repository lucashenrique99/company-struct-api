package br.com.lucashenriquedev.companystruct.domains.release_trains.factory;

import br.com.lucashenriquedev.companystruct.domains.employees.factory.EmployeeFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainJobRole;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainResponsible;

public class ReleaseTrainResponsibleFactory {

    public static ReleaseTrainResponsible create(Long id) {
        if (id == null) {
            return null;
        }

        var responsible = new ReleaseTrainResponsible();
        responsible.setId(id);

        return responsible;
    }

    public static ReleaseTrainResponsible createLeader(Long employee) {
        if (employee == null) {
            return null;
        }

        return ReleaseTrainResponsible.builder()
                .employee(EmployeeFactory.create(employee))
                .role(ReleaseTrainJobRole.LEADER)
                .build();
    }

}
