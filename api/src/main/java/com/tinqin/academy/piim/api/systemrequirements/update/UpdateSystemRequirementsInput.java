package com.tinqin.academy.piim.api.systemrequirements.update;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSystemRequirementsInput implements OperationInput {

    @NotNull
    Long id;

    @NotNull
    @NotBlank
    private String operatingSystem;

    @NotNull
    @NotBlank
    private String cpu;

    @NotNull
    @NotBlank
    private String gpu;

    @NotNull
    private Integer ram;
}
