package com.tinqin.academy.piim.api.token.create;

import com.tinqin.academy.piim.api.entityoutputmodels.TokenOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTokenResult implements OperationResult {

    private TokenOutput token;
}
