package com.tinqin.academy.api.user.create;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserResult implements OperationResult {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
