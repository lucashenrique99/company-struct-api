package br.com.lucashenriquedev.companystruct.domains.communication.controller.response;

import lombok.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostFeedProjection {

    private Long id;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

    private String title;
    private String content;

}
