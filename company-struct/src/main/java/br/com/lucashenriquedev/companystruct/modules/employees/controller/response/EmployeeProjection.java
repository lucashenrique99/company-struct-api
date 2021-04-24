package br.com.lucashenriquedev.companystruct.modules.employees.controller.response;

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
