package br.com.lucashenriquedev.companystruct.domains.employees.controller.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeProjection {

    private Long id;
    private String name;
    private String email;

}
