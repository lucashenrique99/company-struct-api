package br.com.lucashenriquedev.companystruct.domains.communities.controller.response;

import br.com.lucashenriquedev.companystruct.domains.employees.controller.response.EmployeeProjection;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.ReleaseTrainHierarchyResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityHierarchyResponse {

    private Long id;
    private String name;
    private EmployeeProjection leader;
    private List<ReleaseTrainHierarchyResponse> releaseTrains;

}
