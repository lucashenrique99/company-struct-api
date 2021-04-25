package br.com.lucashenriquedev.companystruct.domains.employees.adapter;

import br.com.lucashenriquedev.companystruct.domains.employees.controller.request.InsertEmployeeRequest;
import br.com.lucashenriquedev.companystruct.domains.employees.controller.request.UpdateEmployeeRequest;
import br.com.lucashenriquedev.companystruct.domains.employees.controller.response.BirthdayMonthEmployeeResponse;
import br.com.lucashenriquedev.companystruct.domains.employees.controller.response.EmployeeProjection;
import br.com.lucashenriquedev.companystruct.domains.employees.controller.response.EmployeeResponse;
import br.com.lucashenriquedev.companystruct.domains.employees.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAdapter {

    public static Employee from(InsertEmployeeRequest request) {
        return Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .cpf(request.getCpf())
                .registrationGECO(request.getRegistrationGECO())
                .jobRole(request.getJobRole())
                .rg(request.getRg())
                .macNumber(request.getMacNumber())
                .functional(request.getFunctional())
                .corporatePhone(request.getCorporatePhone())
                .racf(request.getRacf())
                .birthDate(request.getBirthDate())
                .techStack(request.getTechStack())
                .phone(request.getPhone())
                .isActive(Boolean.TRUE)
                .build();
    }

    public static Employee from(UpdateEmployeeRequest request) {
        return Employee.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .registrationGECO(request.getRegistrationGECO())
                .jobRole(request.getJobRole())
                .rg(request.getRg())
                .macNumber(request.getMacNumber())
                .functional(request.getFunctional())
                .corporatePhone(request.getCorporatePhone())
                .racf(request.getRacf())
                .birthDate(request.getBirthDate())
                .techStack(request.getTechStack())
                .phone(request.getPhone())
                .build();
    }

    public static EmployeeProjection to(Employee employee) {
        return EmployeeProjection.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .build();
    }

    public static EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .createdDate(employee.getCreatedDate())
                .lastModifiedDate(employee.getLastModifiedDate())
                .name(employee.getName())
                .email(employee.getEmail())
                .cpf(employee.getCpf())
                .registrationGECO(employee.getRegistrationGECO())
                .jobRole(employee.getJobRole())
                .rg(employee.getRg())
                .macNumber(employee.getMacNumber())
                .functional(employee.getFunctional())
                .corporatePhone(employee.getCorporatePhone())
                .racf(employee.getRacf())
                .birthDate(employee.getBirthDate())
                .techStack(employee.getTechStack())
                .phone(employee.getPhone())
                .build();
    }

    public static BirthdayMonthEmployeeResponse toBirthdayMonthEmployeeResponse(Employee employee) {
        return BirthdayMonthEmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .birthDate(employee.getBirthDate())
                .corporatePhone(employee.getCorporatePhone())
                .build();
    }


}
