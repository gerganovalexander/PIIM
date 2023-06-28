package com.tinqin.academy.piim.api.user.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserInput implements OperationInput {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;
}
