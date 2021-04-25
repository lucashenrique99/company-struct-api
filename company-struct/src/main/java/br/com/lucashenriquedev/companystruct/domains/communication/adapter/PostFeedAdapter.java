package br.com.lucashenriquedev.companystruct.domains.communication.adapter;

import br.com.lucashenriquedev.companystruct.domains.communication.controller.request.InsertPostFeedRequest;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.request.UpdatePostFeedRequest;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.response.PostFeedProjection;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.response.PostFeedResponse;
import br.com.lucashenriquedev.companystruct.domains.communication.model.PostFeed;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PostFeedAdapter {

    public static PostFeed from(InsertPostFeedRequest request) {
        return PostFeed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .isVisible(Boolean.TRUE)
                .comments(new ArrayList<>())
                .reactions(new ArrayList<>())
                .build();
    }

    public static PostFeed from(UpdatePostFeedRequest request) {
        return PostFeed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .isVisible(Boolean.TRUE)
                .build();
    }

    public static PostFeedProjection toProjection(PostFeed post) {
        return PostFeedProjection.builder()
                .id(post.getId())
                .lastModifiedDate(post.getLastModifiedDate())
                .createdDate(post.getCreatedDate())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public static PostFeedResponse toResponse(PostFeed post) {
        return PostFeedResponse.builder()
                .id(post.getId())
                .lastModifiedDate(post.getLastModifiedDate())
                .createdDate(post.getCreatedDate())
                .title(post.getTitle())
                .content(post.getContent())
                .comments(post.getComments().stream()
                        .map(PostCommentAdapter::toResponse)
                        .collect(Collectors.toList()))
                .reactions(post.getReactions().stream()
                        .map(PostReactionAdapter::toResponse)
                        .collect(Collectors.toList()))
                .build();
    }

}
