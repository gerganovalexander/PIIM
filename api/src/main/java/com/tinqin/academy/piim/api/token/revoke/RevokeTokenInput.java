package com.tinqin.academy.piim.api.token.revoke;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RevokeTokenInput implements OperationInput {
    private String token;
}
