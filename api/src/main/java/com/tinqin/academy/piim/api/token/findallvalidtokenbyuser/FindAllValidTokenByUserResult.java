package com.tinqin.academy.piim.api.token.findallvalidtokenbyuser;

import com.tinqin.academy.piim.api.entityoutputmodels.TokenOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllValidTokenByUserResult implements OperationResult {

    private List<TokenOutput> tokens;
}
