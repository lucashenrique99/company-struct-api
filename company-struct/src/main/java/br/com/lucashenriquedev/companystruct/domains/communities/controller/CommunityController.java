package br.com.lucashenriquedev.companystruct.domains.communities.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.domains.communities.adapter.CommunityAdapter;
import br.com.lucashenriquedev.companystruct.domains.communities.controller.request.InsertCommunityRequest;
import br.com.lucashenriquedev.companystruct.domains.communities.controller.request.UpdateCommunityRequest;
import br.com.lucashenriquedev.companystruct.domains.communities.controller.response.CommunityHierarchyResponse;
import br.com.lucashenriquedev.companystruct.domains.communities.controller.response.CommunityResponse;
import br.com.lucashenriquedev.companystruct.domains.communities.messages.CommunityMessages;
import br.com.lucashenriquedev.companystruct.domains.communities.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommunityResponse insert(@Valid @RequestBody InsertCommunityRequest request) {
        return service.insert(CommunityAdapter.from(request))
                .map(CommunityAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(CommunityMessages.UNABLE_TO_SAVE));
    }

    @PutMapping("/{id}")
    public CommunityResponse update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCommunityRequest request) {
        return service.update(id, CommunityAdapter.from(request))
                .map(CommunityAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(CommunityMessages.UNABLE_TO_SAVE));
    }

    @GetMapping
    public List<CommunityResponse> findAll() {
        return service.findAll()
                .stream()
                .map(CommunityAdapter::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CommunityResponse findById(@PathVariable Long id) {
        return service.findById(id)
                .map(CommunityAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(CommunityMessages.COMMUNITY_NOT_FOUND));
    }

    @GetMapping(value = "/{id}", params = {"withHierarchy"})
    public CommunityHierarchyResponse findByIdWithHierarchy(@PathVariable Long id) {
        return service.findById(id)
                .map(CommunityAdapter::toHierarchyResponse)
                .orElseThrow(() -> new ResourceNotFoundException(CommunityMessages.COMMUNITY_NOT_FOUND));
    }

}
