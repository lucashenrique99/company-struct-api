package br.com.lucashenriquedev.companystruct.domains.release_trains.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.domains.employees.messages.EmployeeMessages;
import br.com.lucashenriquedev.companystruct.domains.employees.service.EmployeeService;
import br.com.lucashenriquedev.companystruct.domains.release_trains.messages.ReleaseTrainMessages;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrain;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainResponsible;
import br.com.lucashenriquedev.companystruct.domains.release_trains.repository.ReleaseTrainResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseTrainResponsibleService extends AbstractCRUDService<ReleaseTrainResponsible, ReleaseTrainResponsibleRepository> {

    @Autowired
    private ReleaseTrainService releaseTrainService;

    @Autowired
    private EmployeeService employeeService;

    public List<ReleaseTrainResponsible> findByReleaseTrain(ReleaseTrain releaseTrain) {
        return repository.findByReleaseTrain(releaseTrain);
    }

    @Override
    public Optional<ReleaseTrainResponsible> insert(ReleaseTrainResponsible responsible) {
        responsible.setReleaseTrain(releaseTrainService.findById(responsible.getReleaseTrain().getId())
                .orElseThrow(() -> new IllegalArgumentException(ReleaseTrainMessages.RELEASE_TRAIN_NOT_FOUND)));
        responsible.setEmployee(employeeService.findById(responsible.getEmployee().getId())
                .orElseThrow(() -> new IllegalArgumentException(EmployeeMessages.EMPLOYEE_NOT_FOUND)));

        return Optional.of(repository.save(responsible));
    }

    public Optional<ReleaseTrainResponsible> update(Long id, ReleaseTrainResponsible responsible) {
        return repository.findById(id)
                .map(saved -> {
                    saved.setEmployee(employeeService.findById(responsible.getEmployee().getId())
                            .orElseThrow(() -> new IllegalArgumentException(EmployeeMessages.EMPLOYEE_NOT_FOUND)));
                    saved.setRole(responsible.getRole());
                    saved.setNotes(responsible.getNotes());

                    return repository.save(saved);
                });
    }

}
