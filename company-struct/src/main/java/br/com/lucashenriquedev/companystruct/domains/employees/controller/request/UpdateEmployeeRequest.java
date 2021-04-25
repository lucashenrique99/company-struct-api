package br.com.lucashenriquedev.companystruct.domains.employees.controller.request;

import br.com.lucashenriquedev.companystruct.domains.employees.messages.EmployeeMessages;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class UpdateEmployeeRequest {

    @NotEmpty(message = EmployeeMessages.NAME_REQUIRED)
    private String name;

    @CPF(message = EmployeeMessages.INVALID_CPF)
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
