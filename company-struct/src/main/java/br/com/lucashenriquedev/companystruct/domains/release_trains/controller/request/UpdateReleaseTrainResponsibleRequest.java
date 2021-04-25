package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request;

import br.com.lucashenriquedev.companystruct.domains.release_trains.messages.ReleaseTrainMessages;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainJobRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReleaseTrainResponsibleRequest {

    @NotNull(message = ReleaseTrainMessages.RELEASE_TRAIN_RESPONSIBLE_REQUIRED)
    private Long employee;

    @NotNull(message = ReleaseTrainMessages.RESPONSIBLE_ROLE_REQUIRED)
    private ReleaseTrainJobRole role;

    private String notes;

}
