package br.com.lucashenriquedev.companystruct.domains.communication.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.config.exception.exception.UnauthenticatedException;
import br.com.lucashenriquedev.companystruct.domains.communication.messages.PostFeedMessages;
import br.com.lucashenriquedev.companystruct.domains.communication.model.PostReaction;
import br.com.lucashenriquedev.companystruct.domains.communication.repository.PostReactionRepository;
import br.com.lucashenriquedev.companystruct.domains.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostReactionService extends AbstractCRUDService<PostReaction, PostReactionRepository> {

    @Autowired
    private PostFeedService postFeedService;

    @Autowired
    private UserService userService;

    @Override
    public Optional<PostReaction> insert(PostReaction reaction) {
        reaction.setPost(postFeedService.findById(reaction.getPost().getId())
                .orElseThrow(() -> new IllegalArgumentException(PostFeedMessages.POST_NOT_FOUND)));

        reaction.setAuthor(userService.getCurrentLoggedUser()
                .orElseThrow(() -> new UnauthenticatedException(PostFeedMessages.INVALID_AUTHOR)));

        return Optional.of(repository.save(reaction));
    }
}
