package br.com.lucashenriquedev.companystruct.modules.employees.controller.request;

import br.com.lucashenriquedev.companystruct.modules.employees.messages.EmployeeMessages;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

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
