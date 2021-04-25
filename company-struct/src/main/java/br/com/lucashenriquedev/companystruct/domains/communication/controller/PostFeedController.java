package br.com.lucashenriquedev.companystruct.domains.communication.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.domains.communication.adapter.PostFeedAdapter;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.request.InsertPostFeedRequest;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.request.UpdatePostFeedRequest;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.response.PostFeedProjection;
import br.com.lucashenriquedev.companystruct.domains.communication.controller.response.PostFeedResponse;
import br.com.lucashenriquedev.companystruct.domains.communication.messages.PostFeedMessages;
import br.com.lucashenriquedev.companystruct.domains.communication.service.PostFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostFeedController {

    @Autowired
    private PostFeedService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostFeedResponse insert(@Valid @RequestBody InsertPostFeedRequest request) {
        return service.insert(PostFeedAdapter.from(request))
                .map(PostFeedAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(PostFeedMessages.UNABLE_TO_SAVE));
    }

    @PutMapping("/{id}")
    public PostFeedResponse update(
            @PathVariable Long id,
            @Valid @RequestBody UpdatePostFeedRequest request) {
        return service.update(id, PostFeedAdapter.from(request))
                .map(PostFeedAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(PostFeedMessages.UNABLE_TO_SAVE));
    }

    @GetMapping
    public List<PostFeedProjection> findAll() {
        return service.findAllVisible()
                .stream()
                .map(PostFeedAdapter::toProjection)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PostFeedResponse findById(@PathVariable Long id) {
        return service.findById(id)
                .map(PostFeedAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(PostFeedMessages.POST_NOT_FOUND));
    }

}
