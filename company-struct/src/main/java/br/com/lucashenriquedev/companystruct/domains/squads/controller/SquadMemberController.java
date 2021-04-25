package br.com.lucashenriquedev.companystruct.domains.squads.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.domains.squads.adapter.SquadMemberAdapter;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.request.InsertSquadMemberRequest;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.request.UpdateSquadMemberRequest;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.response.SquadMemberResponse;
import br.com.lucashenriquedev.companystruct.domains.squads.factory.SquadFactory;
import br.com.lucashenriquedev.companystruct.domains.squads.messages.SquadMessages;
import br.com.lucashenriquedev.companystruct.domains.squads.service.SquadMemberService;
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
                .orElseThrow(() -> new IllegalArgumentException(SquadMessages.UNABLE_TO_SAVE_SQUAD_MEMBER));
    }

    @PutMapping("/{id}")
    public SquadMemberResponse update(
            @PathVariable Long squad,
            @PathVariable Long id,
            @Valid @RequestBody UpdateSquadMemberRequest request) {
        return service.update(id, SquadMemberAdapter.from(squad, request))
                .map(SquadMemberAdapter::toResponse)
                .orElseThrow(() -> new IllegalArgumentException(SquadMessages.UNABLE_TO_SAVE_SQUAD_MEMBER));
    }

    @GetMapping
    public List<SquadMemberResponse> findAll(@PathVariable Long squad) {
        return service.findBySquad(SquadFactory.create(squad))
                .stream()
                .map(SquadMemberAdapter::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SquadMemberResponse findById(@PathVariable Long id) {
        return service.findById(id)
                .map(SquadMemberAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(SquadMessages.SQUAD_MEMBER_NOT_FOUND));
    }

}
