package br.com.lucashenriquedev.companystruct.domains.squads.adapter;

import br.com.lucashenriquedev.companystruct.domains.squads.controller.request.InsertSquadRequest;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.request.UpdateSquadRequest;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.response.SquadProjection;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.response.SquadResponse;
import br.com.lucashenriquedev.companystruct.domains.squads.model.Squad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class SquadAdapter {

    public static Squad from(InsertSquadRequest request) {
        return Squad.builder()
                .name(request.getName())
                .projectCode(request.getProjectCode())
                .members(new ArrayList<>())
                .notes(request.getNotes())
                .isActive(Boolean.TRUE)
                .build();
    }

    public static Squad from(UpdateSquadRequest request) {
        return Squad.builder()
                .name(request.getName())
                .projectCode(request.getProjectCode())
                .members(new ArrayList<>())
                .notes(request.getNotes())
                .isActive(Boolean.TRUE)
                .build();
    }

    public static SquadProjection toProjection(Squad squad) {
        return SquadProjection.builder()
                .id(squad.getId())
                .name(squad.getName())
                .projectCode(squad.getProjectCode())
                .build();
    }

    public static SquadResponse toResponse(Squad squad) {
        return SquadResponse.builder()
                .id(squad.getId())
                .name(squad.getName())
                .projectCode(squad.getProjectCode())
                .notes(squad.getNotes())
                .createdDate(squad.getCreatedDate())
                .lastModifiedDate(squad.getLastModifiedDate())
                .members(squad.getMembers() == null ? Collections.emptyList() :
                        squad.getMembers().stream()
                                .map(SquadMemberAdapter::toResponse)
                                .collect(Collectors.toList()))
                .build();
    }

}
