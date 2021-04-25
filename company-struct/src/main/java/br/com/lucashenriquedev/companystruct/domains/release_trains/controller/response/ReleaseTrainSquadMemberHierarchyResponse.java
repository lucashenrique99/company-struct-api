package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response;

import br.com.lucashenriquedev.companystruct.domains.squads.model.SquadRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReleaseTrainSquadMemberHierarchyResponse {

    private Long id;
    private String name;
    private SquadRole role;
    private Boolean isExternal;


}
