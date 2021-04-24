package br.com.lucashenriquedev.companystruct.modules.squads.controller.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SquadProjection {

    private Long id;
    private String name;
    private String projectCode;



}
