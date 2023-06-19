package com.tinqin.academy.api.user.update;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserInput implements OperationInput {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
