package com.tinqin.academy.piim.business.converters.systemrequirements.getall;

import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsResult;
import com.tinqin.academy.piim.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SystemRequirementsToGetAllSystemRequirementsResultConverter
        implements Converter<SystemRequirements, GetAllSystemRequirementsResult> {

    @Override
    public GetAllSystemRequirementsResult convert(SystemRequirements systemRequirements) {
        return GetAllSystemRequirementsResult.builder()
                .id(systemRequirements.getId())
                .operatingSystem(systemRequirements.getOperatingSystem())
                .cpu(systemRequirements.getCpu())
                .gpu(systemRequirements.getGpu())
                .ram(systemRequirements.getRam())
                .build();
    }
}
