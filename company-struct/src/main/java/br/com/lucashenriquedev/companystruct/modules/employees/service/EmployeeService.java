package br.com.lucashenriquedev.companystruct.modules.employees.service;

import br.com.lucashenriquedev.companystruct.modules.employees.messages.EmployeeMessages;
import br.com.lucashenriquedev.companystruct.modules.employees.model.Employee;
import br.com.lucashenriquedev.companystruct.modules.employees.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;


    public Optional<Employee> insert(Employee employee) {
        if (repository.findByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalArgumentException(EmployeeMessages.EMAIL_UNAVAILABLE);
        } else if (repository.findByCpf(employee.getCpf()).isPresent()) {
            throw new IllegalArgumentException(EmployeeMessages.CPF_UNAVAILABLE);
        }

        return Optional.of(repository.save(employee));
    }

    public List<Employee> findAll() {
        return this.repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public List<Employee> findAllActives() {
        return this.repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Optional<Employee> findById(Long id) {
        return this.repository.findById(id);
    }

    public Optional<Employee> update(Long id, Employee employee) {
        return repository.findById(id)
                .map(saved -> {
                    BeanUtils.copyProperties(employee, saved,
                            "id",
                            "createdDate",
                            "lastModifiedDate",
                            "email",
                            "isActive");

                    return repository.save(saved);
                });
    }

    public Optional<Employee> deactivateById(Long id) {
        return repository.findById(id)
                .map(saved -> {
                    saved.setIsActive(Boolean.FALSE);
                    return repository.save(saved);
                });
    }
}
