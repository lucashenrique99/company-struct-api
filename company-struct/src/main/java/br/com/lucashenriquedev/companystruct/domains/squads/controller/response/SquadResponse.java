package br.com.lucashenriquedev.companystruct.domains.squads.controller.response;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SquadResponse {

    private Long id;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;
    private String name;
    private String projectCode;
    private String notes;
    private List<SquadMemberResponse> members;


}
