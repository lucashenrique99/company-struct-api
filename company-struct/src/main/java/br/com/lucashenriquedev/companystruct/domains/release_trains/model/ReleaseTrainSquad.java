package br.com.lucashenriquedev.companystruct.domains.release_trains.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import br.com.lucashenriquedev.companystruct.domains.squads.model.Squad;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "release_train_has_squads")
public class ReleaseTrainSquad extends AbstractModel {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_release_train_has_squads_squad"),
            name = "squad",
            nullable = false,
            referencedColumnName = "id"
    )
    private Squad squad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_release_train_has_squads_release_train"),
            name = "release_train",
            nullable = false,
            referencedColumnName = "id"
    )
    private ReleaseTrain releaseTrain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_train_has_squads_responsible"),
            name = "responsible",
            nullable = false,
            referencedColumnName = "id"
    )
    private ReleaseTrainResponsible responsible;


    private String notes;
}
