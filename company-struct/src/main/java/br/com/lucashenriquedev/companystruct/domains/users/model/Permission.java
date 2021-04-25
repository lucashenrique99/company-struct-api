package br.com.lucashenriquedev.companystruct.domains.users.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @EqualsAndHashCode.Include
    private String name;
    private String description;

}
