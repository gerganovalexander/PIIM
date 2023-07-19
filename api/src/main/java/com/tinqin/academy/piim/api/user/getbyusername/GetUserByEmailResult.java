package com.tinqin.academy.piim.api.user.getbyusername;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByEmailResult implements OperationResult {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
