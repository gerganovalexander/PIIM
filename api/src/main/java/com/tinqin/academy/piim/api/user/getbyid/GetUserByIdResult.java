package com.tinqin.academy.piim.api.user.getbyid;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByIdResult implements OperationResult {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
