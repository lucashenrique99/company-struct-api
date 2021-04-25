package br.com.lucashenriquedev.companystruct.domains.squads.controller.response;

import br.com.lucashenriquedev.companystruct.domains.employees.controller.response.EmployeeProjection;
import br.com.lucashenriquedev.companystruct.domains.squads.model.SquadRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SquadMemberResponse {

    private Long id;
    private String name;
    private SquadRole role;
    private Boolean isExternal;
    private EmployeeProjection employee;
    private String notes;

}
