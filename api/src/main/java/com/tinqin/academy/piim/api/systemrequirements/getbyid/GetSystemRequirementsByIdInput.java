package com.tinqin.academy.piim.api.systemrequirements.getbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetSystemRequirementsByIdInput implements OperationInput {
    @NotNull
    Long id;
}
