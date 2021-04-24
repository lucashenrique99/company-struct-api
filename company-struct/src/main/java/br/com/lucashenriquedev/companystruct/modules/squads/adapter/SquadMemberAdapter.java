package br.com.lucashenriquedev.companystruct.modules.squads.adapter;

import br.com.lucashenriquedev.companystruct.modules.employees.adapter.EmployeeAdapter;
import br.com.lucashenriquedev.companystruct.modules.employees.factory.EmployeeFactory;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.request.InsertSquadMemberRequest;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.request.UpdateSquadMemberRequest;
import br.com.lucashenriquedev.companystruct.modules.squads.controller.response.SquadMemberResponse;
import br.com.lucashenriquedev.companystruct.modules.squads.factory.SquadFactory;
import br.com.lucashenriquedev.companystruct.modules.squads.model.SquadMember;

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
