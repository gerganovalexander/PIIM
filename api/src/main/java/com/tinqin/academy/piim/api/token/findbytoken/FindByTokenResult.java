package com.tinqin.academy.piim.api.token.findbytoken;

import com.tinqin.academy.piim.api.entityoutputmodels.TokenOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindByTokenResult implements OperationResult {
    private TokenOutput tokenOutput;
}
