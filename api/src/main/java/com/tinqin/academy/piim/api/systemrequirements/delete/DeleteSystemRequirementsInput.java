package com.tinqin.academy.piim.api.systemrequirements.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSystemRequirementsInput implements OperationInput {
    @NotNull
    Long id;
}
