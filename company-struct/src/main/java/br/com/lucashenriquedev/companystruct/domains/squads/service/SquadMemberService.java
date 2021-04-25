package br.com.lucashenriquedev.companystruct.domains.squads.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.domains.employees.messages.EmployeeMessages;
import br.com.lucashenriquedev.companystruct.domains.employees.service.EmployeeService;
import br.com.lucashenriquedev.companystruct.domains.squads.messages.SquadMessages;
import br.com.lucashenriquedev.companystruct.domains.squads.model.Squad;
import br.com.lucashenriquedev.companystruct.domains.squads.model.SquadMember;
import br.com.lucashenriquedev.companystruct.domains.squads.repository.SquadMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SquadMemberService extends AbstractCRUDService<SquadMember, SquadMemberRepository> {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SquadService squadService;

    public List<SquadMember> findBySquad(Squad squad) {
        return repository.findBySquad(squad);
    }

    @Override
    public Optional<SquadMember> insert(SquadMember member) {
        member.setSquad(squadService.findById(member.getSquad().getId())
                .orElseThrow(() -> new IllegalArgumentException(SquadMessages.SQUAD_NOT_FOUND)));

        if (member.getEmployee() != null) {
            member.setEmployee(employeeService.findById(member.getEmployee().getId())
                    .orElseThrow(() -> new IllegalArgumentException(EmployeeMessages.EMPLOYEE_NOT_FOUND)));
        }

        return Optional.of(repository.save(member));
    }

    public Optional<SquadMember> update(Long id, SquadMember member) {
        return repository.findById(id)
                .map(saved -> {
                    saved.setMemberName(member.getMemberName());
                    saved.setIsExternal(member.getIsExternal());
                    saved.setNotes(member.getNotes());
                    saved.setRole(member.getRole());

                    if (member.getEmployee() != null) {
                        saved.setEmployee(employeeService.findById(member.getEmployee().getId())
                                .orElseThrow(() -> new IllegalArgumentException(EmployeeMessages.EMPLOYEE_NOT_FOUND)));
                    }

                    return repository.save(saved);
                });
    }

}
