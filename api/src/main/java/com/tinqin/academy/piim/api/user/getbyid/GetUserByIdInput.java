package com.tinqin.academy.piim.api.user.getbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByIdInput implements OperationInput {
    @NotNull
    private Long id;
}
