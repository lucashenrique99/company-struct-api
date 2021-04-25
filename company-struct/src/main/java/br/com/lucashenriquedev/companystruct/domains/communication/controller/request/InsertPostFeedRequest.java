package br.com.lucashenriquedev.companystruct.domains.communication.controller.request;

import br.com.lucashenriquedev.companystruct.domains.communication.messages.PostFeedMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertPostFeedRequest {

    @NotEmpty(message = PostFeedMessages.TITLE_REQUIRED)
    private String title;

    @Size(max = 4096, message = PostFeedMessages.MAX_LENGTH_CONTENT)
    private String content;

}
