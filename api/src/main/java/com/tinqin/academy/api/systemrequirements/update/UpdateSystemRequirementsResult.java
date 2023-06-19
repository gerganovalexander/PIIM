package com.tinqin.academy.api.systemrequirements.update;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSystemRequirementsResult implements OperationResult {

    Long id;
    private String operatingSystem;
    private String cpu;
    private String gpu;
    private Integer ram;
}
