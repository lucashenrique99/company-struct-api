package br.com.lucashenriquedev.companystruct.domains.communities.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import br.com.lucashenriquedev.companystruct.domains.employees.model.Employee;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrain;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "communities")
public class Community extends AbstractModel {

    @NotEmpty
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_communities_leader"),
            name = "leader",
            nullable = false,
            referencedColumnName = "id"
    )
    private Employee leader;

    @OneToMany(mappedBy = "community")
    private List<ReleaseTrain> releaseTrains;

}
