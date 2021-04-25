package br.com.lucashenriquedev.companystruct.domains.communication.controller.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostCommentResponse {

    private Long id;
    private String content;
    private String author;

}
