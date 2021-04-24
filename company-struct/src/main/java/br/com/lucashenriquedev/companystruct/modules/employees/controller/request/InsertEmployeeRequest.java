package br.com.lucashenriquedev.companystruct.modules.employees.controller.request;

import br.com.lucashenriquedev.companystruct.commons.messages.constants.AuthMessages;
import br.com.lucashenriquedev.companystruct.modules.employees.messages.EmployeeMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InsertEmployeeRequest {

    @NotEmpty(message = AuthMessages.EMAIL_REQUIRED)
    @Email(message = AuthMessages.INVALID_EMAIL)
    private String email;

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
