package br.com.lucashenriquedev.companystruct.modules.squads.controller.request;

import br.com.lucashenriquedev.companystruct.modules.squads.messages.SquadMessages;
import br.com.lucashenriquedev.companystruct.modules.squads.model.SquadRole;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsertSquadMemberRequest {

    @NotEmpty(message = SquadMessages.NAME_REQUIRED)
    private String name;
    @NotNull(message = SquadMessages.ROLE_REQUIRED)
    private SquadRole role;

    @NotNull(message = SquadMessages.IS_EXTERNAL_REQUIRED)
    private Boolean isExternal;

    private Long employee;

    private String notes;

}
