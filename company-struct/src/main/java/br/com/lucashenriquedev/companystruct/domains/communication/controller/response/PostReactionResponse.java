package br.com.lucashenriquedev.companystruct.domains.communication.controller.response;

import br.com.lucashenriquedev.companystruct.domains.communication.model.Reaction;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostReactionResponse {

    private Long id;
    private Reaction reaction;
    private String author;

}
