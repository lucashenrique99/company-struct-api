package br.com.lucashenriquedev.companystruct.modules.squads.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.modules.squads.adapter.SquadAdapter;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.request.InsertSquadRequest;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.request.UpdateSquadRequest;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.response.SquadProjection;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.response.SquadResponse;
import br.com.lucashenriquedev.companystruct.modules.squads.messages.SquadMessages;
import br.com.lucashenriquedev.companystruct.modules.squads.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/squads")
public class SquadController {

    @Autowired
    private SquadService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SquadResponse insert(@Valid @RequestBody InsertSquadRequest request) {
        return service.insert(SquadAdapter.from(request))
                .map(SquadAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(SquadMessages.UNABLE_TO_SAVE));
    }

    @PutMapping("/{id}")
    public SquadResponse update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateSquadRequest request) {
        return service.update(id, SquadAdapter.from(request))
                .map(SquadAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(SquadMessages.UNABLE_TO_SAVE));
    }

    @GetMapping
    public List<SquadProjection> findAll() {
        return service.findAll()
                .stream()
                .map(SquadAdapter::toProjection)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SquadResponse findById(@PathVariable Long id) {
        return service.findById(id)
                .map(SquadAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(SquadMessages.SQUAD_NOT_FOUND));
    }

}
