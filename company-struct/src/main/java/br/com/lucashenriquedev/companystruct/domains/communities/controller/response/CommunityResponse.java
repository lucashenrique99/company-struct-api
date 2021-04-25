package br.com.lucashenriquedev.companystruct.domains.communities.controller.response;

import br.com.lucashenriquedev.companystruct.domains.employees.controller.response.EmployeeProjection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityResponse {

    private Long id;
    private String name;
    private EmployeeProjection leader;

}
