package br.com.lucashenriquedev.companystruct.domains.communication.factory;

import br.com.lucashenriquedev.companystruct.domains.communication.model.PostFeed;

public class PostFeedFactory {

    public static PostFeed create(Long id) {
        if (id == null) {
            return null;
        }
        var post = new PostFeed();
        post.setId(id);

        return post;
    }

}
