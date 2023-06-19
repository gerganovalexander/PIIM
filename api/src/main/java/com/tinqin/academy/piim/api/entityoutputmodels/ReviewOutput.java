package com.tinqin.academy.piim.api.entityoutputmodels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewOutput {

    private Long id;
    private String text;
    private Integer score;
    private UserOutput user;
}
