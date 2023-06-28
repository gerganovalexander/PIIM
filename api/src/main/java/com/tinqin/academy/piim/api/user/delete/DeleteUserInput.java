package com.tinqin.academy.piim.api.user.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserInput implements OperationInput {
    @NotNull
    private Long id;
}
