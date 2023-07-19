package com.tinqin.academy.piim.api.token.revoke;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RevokeTokenResult implements OperationResult {

    Boolean success;
}
