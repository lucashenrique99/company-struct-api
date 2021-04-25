package br.com.lucashenriquedev.companystruct.domains.communication.controller.request;

import br.com.lucashenriquedev.companystruct.domains.communication.messages.PostFeedMessages;
import br.com.lucashenriquedev.companystruct.domains.communication.model.Reaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertPostReactionRequest {

    @NotNull(message = PostFeedMessages.REACTION_REQUIRED)
    private Reaction reaction;

}
