package br.com.lucashenriquedev.companystruct.domains.release_trains.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.domains.release_trains.adapter.ReleaseTrainResponsibleAdapter;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.InsertReleaseTrainResponsibleRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.UpdateReleaseTrainResponsibleRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.ReleaseTrainResponsibleResponse;
import br.com.lucashenriquedev.companystruct.domains.release_trains.factory.ReleaseTrainFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.messages.ReleaseTrainMessages;
import br.com.lucashenriquedev.companystruct.domains.release_trains.service.ReleaseTrainResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/release-trains/{releaseTrain}/responsible")
public class ReleaseTrainResponsibleController {

    @Autowired
    private ReleaseTrainResponsibleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReleaseTrainResponsibleResponse insert(
            @PathVariable Long releaseTrain,
            @Valid @RequestBody InsertReleaseTrainResponsibleRequest request) {
        return service.insert(ReleaseTrainResponsibleAdapter.from(releaseTrain, request))
                .map(ReleaseTrainResponsibleAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.UNABLE_TO_SAVE_RELEASE_TRAIN_RESPONSIBLE));
    }

    @PutMapping("/{id}")
    public ReleaseTrainResponsibleResponse update(
            @PathVariable Long releaseTrain,
            @PathVariable Long id,
            @Valid @RequestBody UpdateReleaseTrainResponsibleRequest request) {
        return service.update(id, ReleaseTrainResponsibleAdapter.from(releaseTrain, request))
                .map(ReleaseTrainResponsibleAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.UNABLE_TO_SAVE_RELEASE_TRAIN_RESPONSIBLE));
    }

    @GetMapping
    public List<ReleaseTrainResponsibleResponse> findAll(@PathVariable Long releaseTrain) {
        return service.findByReleaseTrain(ReleaseTrainFactory.create(releaseTrain))
                .stream()
                .map(ReleaseTrainResponsibleAdapter::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReleaseTrainResponsibleResponse findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ReleaseTrainResponsibleAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(ReleaseTrainMessages.RELEASE_TRAIN_RESPONSIBLE_NOT_FOUND));
    }

}
