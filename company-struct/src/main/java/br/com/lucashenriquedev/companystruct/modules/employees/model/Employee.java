package br.com.lucashenriquedev.companystruct.modules.employees.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee extends AbstractModel {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String name;

    @NotNull
    private Boolean isActive;

    @CPF
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

    public Boolean isActive() {
        return this.isActive;
    }

}
