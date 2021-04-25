package br.com.lucashenriquedev.companystruct.domains.communication.adapter;

import br.com.lucashenriquedev.companystruct.domains.communication.controller.request.InsertPostReactionRequest;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.response.PostReactionResponse;
import br.com.lucashenriquedev.companystruct.domains.communication.factory.PostFeedFactory;
import br.com.lucashenriquedev.companystruct.domains.communication.model.PostReaction;

public class PostReactionAdapter {

    public static PostReaction from(Long post, InsertPostReactionRequest request) {
        return PostReaction.builder()
                .post(PostFeedFactory.create(post))
                .reaction(request.getReaction())
                .build();
    }

    public static PostReactionResponse toResponse(PostReaction reaction) {
        return PostReactionResponse.builder()
                .id(reaction.getId())
                .reaction(reaction.getReaction())
                .author(reaction.getAuthor().getName())
                .build();
    }

}
