package br.com.lucashenriquedev.companystruct.domains.release_trains.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.domains.release_trains.adapter.ReleaseTrainSquadAdapter;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.InsertReleaseTrainSquadRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.UpdateReleaseTrainSquadRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.ReleaseTrainSquadResponse;
import br.com.lucashenriquedev.companystruct.domains.release_trains.factory.ReleaseTrainFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.messages.ReleaseTrainMessages;
import br.com.lucashenriquedev.companystruct.domains.release_trains.service.ReleaseTrainSquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/release-trains/{releaseTrain}/squads")
public class ReleaseTrainSquadController {

    @Autowired
    private ReleaseTrainSquadService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReleaseTrainSquadResponse insert(
            @PathVariable Long releaseTrain,
            @Valid @RequestBody InsertReleaseTrainSquadRequest request) {
        return service.insert(ReleaseTrainSquadAdapter.from(releaseTrain, request))
                .map(ReleaseTrainSquadAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.UNABLE_TO_SAVE_RELEASE_TRAIN_SQUAD));
    }

    @PutMapping("/{id}")
    public ReleaseTrainSquadResponse update(
            @PathVariable Long releaseTrain,
            @PathVariable Long id,
            @Valid @RequestBody UpdateReleaseTrainSquadRequest request) {
        return service.update(id, ReleaseTrainSquadAdapter.from(releaseTrain, request))
                .map(ReleaseTrainSquadAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.UNABLE_TO_SAVE_RELEASE_TRAIN_SQUAD));
    }

    @GetMapping
    public List<ReleaseTrainSquadResponse> findAll(@PathVariable Long releaseTrain) {
        return service.findByReleaseTrain(ReleaseTrainFactory.create(releaseTrain))
                .stream()
                .map(ReleaseTrainSquadAdapter::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReleaseTrainSquadResponse findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ReleaseTrainSquadAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(ReleaseTrainMessages.RELEASE_TRAIN_SQUAD_NOT_FOUND));
    }

}
