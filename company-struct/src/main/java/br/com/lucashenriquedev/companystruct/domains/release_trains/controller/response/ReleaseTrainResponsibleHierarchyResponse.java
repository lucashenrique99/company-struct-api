package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response;

import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainJobRole;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReleaseTrainResponsibleHierarchyResponse {

    private Long id;
    private String name;
    private ReleaseTrainJobRole role;
    private List<ReleaseTrainSquadHierarchyResponse> squads;

}
