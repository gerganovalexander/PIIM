package com.tinqin.academy.piim.api.token.findbytoken;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindByTokenInput implements OperationInput {
    private String token;
}
