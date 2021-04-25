package br.com.lucashenriquedev.companystruct.domains.communication.adapter;

import br.com.lucashenriquedev.companystruct.domains.communication.controller.request.InsertPostCommentRequest;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.response.PostCommentResponse;
import br.com.lucashenriquedev.companystruct.domains.communication.factory.PostFeedFactory;
import br.com.lucashenriquedev.companystruct.domains.communication.model.PostComment;

public class PostCommentAdapter {

    public static PostComment from(Long post, InsertPostCommentRequest request) {
        return PostComment.builder()
                .post(PostFeedFactory.create(post))
                .content(request.getContent())
                .build();
    }

    public static PostCommentResponse toResponse(PostComment comment) {
        return PostCommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .author(comment.getAuthor().getName())
                .build();
    }


}
