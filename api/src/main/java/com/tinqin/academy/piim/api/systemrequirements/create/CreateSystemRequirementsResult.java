package com.tinqin.academy.piim.api.systemrequirements.create;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSystemRequirementsResult implements OperationResult {

    private Long id;
    private String operatingSystem;
    private String cpu;
    private String gpu;
    private Integer ram;
}
