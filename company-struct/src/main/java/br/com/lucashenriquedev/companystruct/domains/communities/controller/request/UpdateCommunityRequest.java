package br.com.lucashenriquedev.companystruct.domains.communities.controller.request;

import br.com.lucashenriquedev.companystruct.domains.communities.messages.CommunityMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommunityRequest {

    @NotEmpty(message = CommunityMessages.NAME_REQUIRED)
    private String name;

    @NotNull(message = CommunityMessages.LEADER_REQUIRED)
    private Long leader;

}
