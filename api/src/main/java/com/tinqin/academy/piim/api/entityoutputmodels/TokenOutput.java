package com.tinqin.academy.piim.api.entityoutputmodels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenOutput {
    private Long id;
    private String token;
    private String tokenType;
    private boolean revoked;
    private boolean expired;
    private Long userId;
}
