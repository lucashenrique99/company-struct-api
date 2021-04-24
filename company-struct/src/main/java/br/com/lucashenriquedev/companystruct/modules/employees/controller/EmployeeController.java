package br.com.lucashenriquedev.companystruct.modules.employees.controller;

import br.com.lucashenriquedev.companystruct.commons.annotations.RoleRoot;
import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.modules.employees.adapter.EmployeeAdapter;
import br.com.lucashenriquedev.companystruct.modules.employees.controller.request.InsertEmployeeRequest;
import br.com.lucashenriquedev.companystruct.modules.employees.controller.request.UpdateEmployeeRequest;
import br.com.lucashenriquedev.companystruct.modules.employees.controller.response.EmployeeProjection;
import br.com.lucashenriquedev.companystruct.modules.employees.controller.response.EmployeeResponse;
import br.com.lucashenriquedev.companystruct.modules.employees.messages.EmployeeMessages;
import br.com.lucashenriquedev.companystruct.modules.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employees;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<EmployeeProjection> insert(@RequestBody @Valid InsertEmployeeRequest req) {
        return this.employees.insert(EmployeeAdapter.from(req))
                .map(EmployeeAdapter::to);
    }

    @PutMapping("/{id}")
    @RoleRoot
    public EmployeeProjection update(@PathVariable Long id, @RequestBody @Valid UpdateEmployeeRequest request) {
        return this.employees.update(id, EmployeeAdapter.from(request))
                .map(EmployeeAdapter::to)
                .orElseThrow(() -> new ResourceNotFoundException(EmployeeMessages.EMPLOYEE_NOT_FOUND));
    }

    @GetMapping
    public List<EmployeeProjection> findAllActives() {
        return this.employees.findAllActives()
                .stream()
                .map(EmployeeAdapter::to)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable Long id) {
        return this.employees.findById(id)
                .map(EmployeeAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(EmployeeMessages.EMPLOYEE_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public EmployeeResponse deactivate(@PathVariable Long id) {
        return this.employees.deactivateById(id)
                .map(EmployeeAdapter::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(EmployeeMessages.EMPLOYEE_NOT_FOUND));
    }

}
