package com.tinqin.academy.piim.api.user.update;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserResult implements OperationResult {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
