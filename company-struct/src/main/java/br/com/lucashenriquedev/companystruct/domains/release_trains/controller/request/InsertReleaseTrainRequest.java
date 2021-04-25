package br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request;

import br.com.lucashenriquedev.companystruct.domains.release_trains.messages.ReleaseTrainMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertReleaseTrainRequest {

    @NotEmpty(message = ReleaseTrainMessages.NAME_REQUIRED)
    private String name;

    @NotNull(message = ReleaseTrainMessages.RELEASE_TRAIN_RESPONSIBLE_REQUIRED)
    private Long responsible;

    @NotNull(message = ReleaseTrainMessages.COMMUNITY_REQUIRED)
    private Long community;

    private String manager;

    private String notes;

}
