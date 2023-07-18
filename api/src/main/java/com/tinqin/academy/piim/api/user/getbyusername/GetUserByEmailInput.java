package com.tinqin.academy.piim.api.user.getbyusername;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByEmailInput implements OperationInput {
    @NotNull
    private String email;
}
