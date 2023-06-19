package com.tinqin.academy.api.entityoutputmodels;

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
