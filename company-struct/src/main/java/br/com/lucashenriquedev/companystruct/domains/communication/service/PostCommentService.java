package br.com.lucashenriquedev.companystruct.domains.communication.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.domains.communication.messages.PostFeedMessages;
import br.com.lucashenriquedev.companystruct.domains.communication.model.PostComment;
import br.com.lucashenriquedev.companystruct.domains.communication.repository.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostCommentService extends AbstractCRUDService<PostComment, PostCommentRepository> {

    @Autowired
    private PostFeedService postFeedService;

    @Override
    public Optional<PostComment> insert(PostComment reaction) {
        reaction.setPost(postFeedService.findById(reaction.getPost().getId())
                .orElseThrow(() -> new IllegalArgumentException(PostFeedMessages.POST_NOT_FOUND)));

        return Optional.of(repository.save(reaction));
    }


}
