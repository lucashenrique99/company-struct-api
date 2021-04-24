package br.com.lucashenriquedev.companystruct.modules.squads.controller.response;

import br.com.lucashenriquedev.companystruct.modules.employees.controller.response.EmployeeProjection;
import br.com.lucashenriquedev.companystruct.modules.squads.model.SquadRole;
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
