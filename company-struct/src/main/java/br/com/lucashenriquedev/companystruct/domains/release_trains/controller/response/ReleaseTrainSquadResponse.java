package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response;

import br.com.lucashenriquedev.companystruct.domains.squads.controller.response.SquadProjection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReleaseTrainSquadResponse {

    private Long id;
    private SquadProjection squad;
    private ReleaseTrainResponsibleResponse responsible;
    private String notes;

}
