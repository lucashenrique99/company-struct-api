package br.com.lucashenriquedev.companystruct.modules.squads.controller.request;

import br.com.lucashenriquedev.companystruct.modules.squads.messages.SquadMessages;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateSquadRequest {

    @NotEmpty(message = SquadMessages.NAME_REQUIRED)
    private String name;
    private String projectCode;
    private String notes;


}
