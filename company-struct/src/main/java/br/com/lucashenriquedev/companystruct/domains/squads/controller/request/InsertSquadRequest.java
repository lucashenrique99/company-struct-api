package br.com.lucashenriquedev.companystruct.domains.squads.controller.request;

import br.com.lucashenriquedev.companystruct.domains.squads.messages.SquadMessages;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsertSquadRequest {

    @NotEmpty(message = SquadMessages.NAME_REQUIRED)
    private String name;
    private String projectCode;
    private String notes;


}
