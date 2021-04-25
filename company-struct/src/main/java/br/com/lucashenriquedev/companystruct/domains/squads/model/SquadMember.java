package br.com.lucashenriquedev.companystruct.domains.squads.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import br.com.lucashenriquedev.companystruct.domains.employees.model.Employee;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "squad_members")
public class SquadMember extends AbstractModel {

    private String memberName;

    @Enumerated(EnumType.STRING)
    private SquadRole role;

    @NotNull
    private Boolean isExternal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_squad_members_squad"),
            name = "squad",
            nullable = false,
            referencedColumnName = "id"
    )
    private Squad squad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_squad_members_employee"),
            name = "employee",
            referencedColumnName = "id"
    )
    private Employee employee;


    private String notes;


}
