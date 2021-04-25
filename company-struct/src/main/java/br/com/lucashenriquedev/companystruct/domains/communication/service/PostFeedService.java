package br.com.lucashenriquedev.companystruct.domains.communication.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.config.exception.exception.UnauthenticatedException;
import br.com.lucashenriquedev.companystruct.domains.communication.messages.PostFeedMessages;
import br.com.lucashenriquedev.companystruct.domains.communication.model.PostFeed;
import br.com.lucashenriquedev.companystruct.domains.communication.repository.PostFeedRepository;
import br.com.lucashenriquedev.companystruct.domains.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostFeedService extends AbstractCRUDService<PostFeed, PostFeedRepository> {

    @Autowired
    private UserService userService;

    public List<PostFeed> findAllVisible() {
        return repository.findAllIsVisible(PageRequest.of(0, 100, Sort.by(Sort.Direction.DESC, "createdDate")));
    }

    @Override
    public Optional<PostFeed> insert(PostFeed post) {
        post.setAuthor(userService.getCurrentLoggedUser()
                .orElseThrow(() -> new UnauthenticatedException(PostFeedMessages.INVALID_AUTHOR)));

        return Optional.of(repository.save(post));
    }


    public Optional<PostFeed> update(Long id, PostFeed post) {
        return repository.findById(id)
                .map(saved -> {
                    if (userService.getCurrentLoggedUser()
                            .filter(u -> u.equals(saved.getAuthor()))
                            .isEmpty()) {
                        throw new IllegalArgumentException(PostFeedMessages.INVALID_AUTHOR);
                    }
                    saved.setTitle(post.getTitle());
                    saved.setContent(post.getContent());

                    return repository.save(saved);
                });
    }

}
