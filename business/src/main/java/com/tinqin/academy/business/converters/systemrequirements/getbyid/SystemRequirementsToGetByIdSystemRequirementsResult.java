package com.tinqin.academy.business.converters.systemrequirements.getbyid;

import com.tinqin.academy.api.systemrequirements.getbyid.GetSystemRequirementsByIdResult;
import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SystemRequirementsToGetByIdSystemRequirementsResult implements Converter<SystemRequirements, GetSystemRequirementsByIdResult> {
    @Override
    public GetSystemRequirementsByIdResult convert(SystemRequirements systemRequirements) {
        return GetSystemRequirementsByIdResult.builder()
                .id(systemRequirements.getId())
                .operatingSystem(systemRequirements.getOperatingSystem())
                .cpu(systemRequirements.getCpu())
                .gpu(systemRequirements.getGpu())
                .ram(systemRequirements.getRam()).build();
    }
}
