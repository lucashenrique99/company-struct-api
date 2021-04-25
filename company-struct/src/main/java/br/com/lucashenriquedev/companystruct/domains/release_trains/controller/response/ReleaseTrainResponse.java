package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReleaseTrainResponse {

    private Long id;
    private String name;
    private Boolean isActive;
    private ReleaseTrainResponsibleResponse leader;
    private List<ReleaseTrainResponsibleResponse> responsible;
    private List<ReleaseTrainSquadResponse> squads;
    private String notes;

}
