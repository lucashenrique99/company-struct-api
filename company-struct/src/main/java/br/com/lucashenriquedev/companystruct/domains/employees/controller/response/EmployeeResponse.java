package br.com.lucashenriquedev.companystruct.domains.employees.controller.response;

import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeResponse {

    private Long id;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;
    private String email;
    private String name;
    private String cpf;
    private String registrationGECO;
    private String jobRole;
    private String rg;
    private String macNumber;
    private String functional;
    private String corporatePhone;
    private String racf;
    private LocalDate birthDate;
    private String techStack;
    private String phone;

}
