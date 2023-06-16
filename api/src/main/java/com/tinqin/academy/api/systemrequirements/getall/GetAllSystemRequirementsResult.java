package com.tinqin.academy.api.systemrequirements.getall;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSystemRequirementsResult {
    private Long id;
    private String operatingSystem;
    private String cpu;
    private String gpu;
    private Integer ram;
}
