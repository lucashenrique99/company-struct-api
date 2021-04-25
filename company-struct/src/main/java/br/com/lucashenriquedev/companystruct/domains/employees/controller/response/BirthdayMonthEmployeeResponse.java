package br.com.lucashenriquedev.companystruct.domains.employees.controller.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BirthdayMonthEmployeeResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String corporatePhone;
    private LocalDate birthDate;

}
