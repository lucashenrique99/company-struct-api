package br.com.lucashenriquedev.companystruct.domains.squads.adapter;

import br.com.lucashenriquedev.companystruct.domains.employees.adapter.EmployeeAdapter;
import br.com.lucashenriquedev.companystruct.domains.employees.factory.EmployeeFactory;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.request.InsertSquadMemberRequest;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.request.UpdateSquadMemberRequest;
import br.com.lucashenriquedev.companystruct.domains.squads.controller.response.SquadMemberResponse;
import br.com.lucashenriquedev.companystruct.domains.squads.factory.SquadFactory;
import br.com.lucashenriquedev.companystruct.domains.squads.model.SquadMember;

public class SquadMemberAdapter {

    public static SquadMember from(Long squad, InsertSquadMemberRequest request) {
        return SquadMember.builder()
                .memberName(request.getName())
                .isExternal(request.getIsExternal())
                .employee(EmployeeFactory.create(request.getEmployee()))
                .squad(SquadFactory.create(squad))
                .notes(request.getNotes())
                .role(request.getRole())
                .build();
    }

    public static SquadMember from(Long squad, UpdateSquadMemberRequest request) {
        return SquadMember.builder()
                .memberName(request.getName())
                .isExternal(request.getIsExternal())
                .employee(EmployeeFactory.create(request.getEmployee()))
                .squad(SquadFactory.create(squad))
                .notes(request.getNotes())
                .role(request.getRole())
                .build();
    }

    public static SquadMemberResponse toResponse(SquadMember member) {
        return SquadMemberResponse.builder()
                .id(member.getId())
                .name(member.getMemberName())
                .role(member.getRole())
                .isExternal(member.getIsExternal())
                .employee(member.getEmployee() == null ? null :
                        EmployeeAdapter.to(member.getEmployee()))
                .notes(member.getNotes())
                .build();
    }

}
