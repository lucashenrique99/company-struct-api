package br.com.lucashenriquedev.companystruct.modules.squads.model;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    public Boolean isActive() {
        return isActive;
    }
}
