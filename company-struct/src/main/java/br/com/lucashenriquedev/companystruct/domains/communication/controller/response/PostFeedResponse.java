package br.com.lucashenriquedev.companystruct.domains.communication.controller.response;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostFeedResponse {

    private Long id;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

    private String title;
    private String content;

    private List<PostCommentResponse> comments;
    private List<PostReactionResponse> reactions;

}
