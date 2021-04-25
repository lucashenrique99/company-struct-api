package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request;

import br.com.lucashenriquedev.companystruct.domains.release_trains.messages.ReleaseTrainMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertReleaseTrainSquadRequest {

    @NotNull(message = ReleaseTrainMessages.SQUAD_REQUIRED)
    private Long squad;

    @NotNull(message = ReleaseTrainMessages.RELEASE_TRAIN_RESPONSIBLE_REQUIRED)
    private Long responsible;

    private String notes;

}
