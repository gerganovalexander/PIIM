package com.tinqin.academy.api.systemrequirements.update;

import com.tinqin.academy.api.generics.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
