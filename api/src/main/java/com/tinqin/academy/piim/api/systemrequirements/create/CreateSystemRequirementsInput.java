package com.tinqin.academy.piim.api.systemrequirements.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSystemRequirementsInput implements OperationInput {
    @NotNull
    private String operatingSystem;

    @NotNull
    private String cpu;

    @NotNull
    private String gpu;

    @NotNull
    private Integer ram;
}
