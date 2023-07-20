package com.tinqin.academy.piim.api.token.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTokenInput implements OperationInput {

    @NotNull
    private String token;

    @NotNull
    private String tokenType;

    @NotNull
    private String email;
}
