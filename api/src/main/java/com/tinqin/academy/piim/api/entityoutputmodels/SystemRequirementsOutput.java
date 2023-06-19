package com.tinqin.academy.piim.api.entityoutputmodels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SystemRequirementsOutput {
    private Long id;
    private String operatingSystem;
    private String cpu;
    private String gpu;
    private Integer ram;
}
