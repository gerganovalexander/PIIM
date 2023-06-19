package com.tinqin.academy.piim.api.user.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserInput implements OperationInput {
    private String firstName;
    private String lastName;
    private String email;
}
