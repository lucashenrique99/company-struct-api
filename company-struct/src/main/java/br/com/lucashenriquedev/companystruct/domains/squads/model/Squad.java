package br.com.lucashenriquedev.companystruct.domains.squads.model;

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
@Table(name = "squads")
public class Squad extends AbstractModel {

    @NotEmpty
    private String name;

    private String projectCode;

    @OneToMany(mappedBy = "squad")
    private List<SquadMember> members;

    private String notes;

    @NotNull
    private Boolean isActive;

    public Optional<SquadMember> getLeader() {
        return members.stream()
                .filter(r -> r.getRole().equals(SquadRole.TEAM_LEAD))
                .findAny();
    }

    public Boolean isActive() {
        return isActive;
    }
}
