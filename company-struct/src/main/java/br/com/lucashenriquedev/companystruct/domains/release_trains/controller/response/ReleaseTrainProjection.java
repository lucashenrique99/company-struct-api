package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReleaseTrainProjection {

    private Long id;
    private String name;
    private Boolean isActive;
    private ReleaseTrainResponsibleResponse leader;
    private String notes;

}
