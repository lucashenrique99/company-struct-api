package br.com.lucashenriquedev.companystruct.domains.release_trains.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.domains.release_trains.adapter.ReleaseTrainAdapter;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.InsertReleaseTrainRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.UpdateReleaseTrainRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.ReleaseTrainHierarchyResponse;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.ReleaseTrainProjection;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.ReleaseTrainResponse;
import br.com.lucashenriquedev.companystruct.domains.release_trains.messages.ReleaseTrainMessages;
import br.com.lucashenriquedev.companystruct.domains.release_trains.service.ReleaseTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/release-trains")
public class ReleaseTrainController {

    @Autowired
    private ReleaseTrainService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReleaseTrainResponse insert(@Valid @RequestBody InsertReleaseTrainRequest request) {
        return service.insert(ReleaseTrainAdapter.from(request))
                .map(ReleaseTrainAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.UNABLE_TO_SAVE_RELEASE_TRAIN));
    }

    @PutMapping("/{id}")
    public ReleaseTrainResponse update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateReleaseTrainRequest request) {
        return service.update(id, ReleaseTrainAdapter.from(request))
                .map(ReleaseTrainAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.UNABLE_TO_SAVE_RELEASE_TRAIN));
    }

    @GetMapping
    public List<ReleaseTrainProjection> findAll() {
        return service.findAll()
                .stream()
                .map(ReleaseTrainAdapter::toProjection)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReleaseTrainResponse findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ReleaseTrainAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(ReleaseTrainMessages.RELEASE_TRAIN_NOT_FOUND));
    }

    @GetMapping(value = "/{id}", params = {"withHierarchy"})
    public ReleaseTrainHierarchyResponse findByIdWithHierarchy(@PathVariable Long id) {
        return service.findById(id)
                .map(ReleaseTrainAdapter::toHierarchyResponse)
                .orElseThrow(() -> new ResourceNotFoundException(ReleaseTrainMessages.RELEASE_TRAIN_NOT_FOUND));
    }

}
