package com.tinqin.academy.piim.api.token.findallvalidtokenbyuser;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllValidTokenByUserInput implements OperationInput {
    private Long userId;
}
