package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReleaseTrainHierarchyResponse {

    private Long id;
    private String name;
    private ReleaseTrainResponsibleHierarchyResponse leader;
    private List<ReleaseTrainResponsibleHierarchyResponse> responsible;

}
