package com.tinqin.academy.piim.api.entityoutputmodels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOutput {
    private Long id;
    private String fullName;
}
