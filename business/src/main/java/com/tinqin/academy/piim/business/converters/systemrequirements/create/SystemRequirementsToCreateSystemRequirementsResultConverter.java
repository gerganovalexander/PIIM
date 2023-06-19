package com.tinqin.academy.piim.business.converters.systemrequirements.create;

import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsResult;
import com.tinqin.academy.piim.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SystemRequirementsToCreateSystemRequirementsResultConverter implements Converter<SystemRequirements, CreateSystemRequirementsResult> {

    @Override
    public CreateSystemRequirementsResult convert(SystemRequirements systemRequirements) {
        return CreateSystemRequirementsResult.builder()
                .id(systemRequirements.getId())
                .operatingSystem(systemRequirements.getOperatingSystem())
                .cpu(systemRequirements.getCpu())
                .gpu(systemRequirements.getGpu())
                .ram(systemRequirements.getRam()).build();
    }
}
