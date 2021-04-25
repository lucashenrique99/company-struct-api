package br.com.lucashenriquedev.companystruct.domains.communication.controller.request;

import br.com.lucashenriquedev.companystruct.domains.communication.messages.PostFeedMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertPostCommentRequest {

    @Size(max = 1024, message = PostFeedMessages.MAX_LENGTH_COMMENT)
    private String content;

}
