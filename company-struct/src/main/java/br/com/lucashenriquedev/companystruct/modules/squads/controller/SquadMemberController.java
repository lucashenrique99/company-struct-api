package br.com.lucashenriquedev.companystruct.modules.squads.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.modules.squads.adapter.SquadMemberAdapter;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.request.InsertSquadMemberRequest;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.request.UpdateSquadMemberRequest;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.response.SquadMemberResponse;
import br.com.lucashenriquedev.companystruct.modules.squads.messages.SquadMessages;
import br.com.lucashenriquedev.companystruct.modules.squads.service.SquadMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/squads/{squad}/members")
public class SquadMemberController {

    @Autowired
    private SquadMemberService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SquadMemberResponse insert(
            @PathVariable Long squad,
            @Valid @RequestBody InsertSquadMemberRequest request) {
        return service.insert(SquadMemberAdapter.from(squad, request))
                .map(SquadMemberAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(SquadMessages.UNABLE_TO_SAVE));
    }

    @PutMapping("/{id}")
    public SquadMemberResponse update(
            @PathVariable Long squad,
            @PathVariable Long id,
            @Valid @RequestBody UpdateSquadMemberRequest request) {
        return service.update(id, SquadMemberAdapter.from(squad, request))
                .map(SquadMemberAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(SquadMessages.UNABLE_TO_SAVE));
    }

    @GetMapping
    public List<SquadMemberResponse> findAll() {
        return service.findAll()
                .stream()
                .map(SquadMemberAdapter::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SquadMemberResponse findById(@PathVariable Long id) {
        return service.findById(id)
                .map(SquadMemberAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(SquadMessages.SQUAD_NOT_FOUND));
    }

}
