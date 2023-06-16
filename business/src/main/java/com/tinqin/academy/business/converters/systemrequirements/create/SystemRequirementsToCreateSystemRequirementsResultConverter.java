package com.tinqin.academy.business.converters.systemrequirements.create;

import com.tinqin.academy.api.systemrequirements.create.CreateSystemRequirementsResult;
import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SystemRequirementsToCreateSystemRequirementsResultConverter implements Converter<SystemRequirements, CreateSystemRequirementsResult> {

    @Override
    public CreateSystemRequirementsResult convert(SystemRequirements systemRequirements) {
        return CreateSystemRequirementsResult.builder()
                .id(systemRequirements.getSystemRequirementsId())
                .operatingSystem(systemRequirements.getOperatingSystem())
                .cpu(systemRequirements.getCpu())
                .gpu(systemRequirements.getGpu())
                .ram(systemRequirements.getRam()).build();
    }
}
