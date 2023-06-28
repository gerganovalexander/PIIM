package com.tinqin.academy.piim.api.systemrequirements.getall;

import lombok.*;

@Getter
@Setter
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
