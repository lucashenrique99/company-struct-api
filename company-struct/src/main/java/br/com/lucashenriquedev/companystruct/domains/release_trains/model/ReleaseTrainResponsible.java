package br.com.lucashenriquedev.companystruct.domains.release_trains.model;

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
@Table(name = "release_train_has_responsible")
public class ReleaseTrainResponsible extends AbstractModel {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_release_train_has_responsible_release_train"),
            name = "release_train",
            nullable = false,
            referencedColumnName = "id"
    )
    private ReleaseTrain releaseTrain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_squad_members_employee"),
            name = "employee",
            nullable = false,
            referencedColumnName = "id"
    )
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ReleaseTrainJobRole role;

    private String notes;
}
