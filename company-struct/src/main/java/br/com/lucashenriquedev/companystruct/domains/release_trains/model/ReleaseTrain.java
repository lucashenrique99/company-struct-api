package br.com.lucashenriquedev.companystruct.domains.release_trains.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "release_trains")
public class ReleaseTrain extends AbstractModel {

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "releaseTrain")
    private List<ReleaseTrainSquad> squads;

    @OneToMany(mappedBy = "releaseTrain")
    private List<ReleaseTrainResponsible> responsible;

    private String notes;

    @NotNull
    private Boolean isActive;

    public Boolean isActive() {
        return isActive;
    }

    public Optional<ReleaseTrainResponsible> getLeader() {
        return responsible.stream()
                .filter(r -> r.getRole().equals(ReleaseTrainJobRole.LEADER))
                .findAny();
    }

}
