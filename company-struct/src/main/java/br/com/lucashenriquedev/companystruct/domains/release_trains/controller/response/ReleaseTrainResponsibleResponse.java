package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response;

import br.com.lucashenriquedev.companystruct.domains.employees.controller.response.EmployeeProjection;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainJobRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReleaseTrainResponsibleResponse {

    private Long id;
    private EmployeeProjection employee;
    private ReleaseTrainJobRole role;
    private String notes;

}
