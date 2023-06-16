package com.tinqin.academy.api.systemrequirements.create;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSystemRequirementsInput implements OperationInput {

    private String operatingSystem;
    private String cpu;
    private String gpu;
    private Integer ram;
}
