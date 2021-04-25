package br.com.lucashenriquedev.companystruct.domains.communities.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.domains.communities.model.Community;
import br.com.lucashenriquedev.companystruct.domains.communities.repository.CommunityRepository;
import br.com.lucashenriquedev.companystruct.domains.employees.messages.EmployeeMessages;
import br.com.lucashenriquedev.companystruct.domains.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommunityService extends AbstractCRUDService<Community, CommunityRepository> {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Optional<Community> insert(Community community) {
        community.setLeader(employeeService.findById(community.getLeader().getId())
                .orElseThrow(() -> new IllegalArgumentException(EmployeeMessages.EMPLOYEE_NOT_FOUND)));

        return Optional.of(repository.save(community));
    }

    public Optional<Community> update(Long id, Community community) {
        return repository.findById(id)
                .map(saved -> {
                    saved.setLeader(employeeService.findById(community.getLeader().getId())
                            .orElseThrow(() -> new IllegalArgumentException(EmployeeMessages.EMPLOYEE_NOT_FOUND)));

                    return repository.save(saved);
                });
    }
}
