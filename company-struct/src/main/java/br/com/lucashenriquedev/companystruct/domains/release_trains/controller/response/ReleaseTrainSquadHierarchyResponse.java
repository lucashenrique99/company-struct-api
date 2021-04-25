package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReleaseTrainSquadHierarchyResponse {

    private Long id;
    private String name;
    private ReleaseTrainSquadMemberHierarchyResponse leader;
    private List<ReleaseTrainSquadMemberHierarchyResponse> triad;
    private List<ReleaseTrainSquadMemberHierarchyResponse> members;

}
