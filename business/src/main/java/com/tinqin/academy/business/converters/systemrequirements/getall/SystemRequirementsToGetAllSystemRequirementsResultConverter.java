package com.tinqin.academy.business.converters.systemrequirements.getall;

import com.tinqin.academy.api.systemrequirements.getall.GetAllSystemRequirementsResult;
import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SystemRequirementsToGetAllSystemRequirementsResultConverter implements Converter<SystemRequirements, GetAllSystemRequirementsResult> {

    @Override
    public GetAllSystemRequirementsResult convert(SystemRequirements systemRequirements) {
        return GetAllSystemRequirementsResult.builder()
                .id(systemRequirements.getSystemRequirementsId())
                .operatingSystem(systemRequirements.getOperatingSystem())
                .cpu(systemRequirements.getCpu())
                .gpu(systemRequirements.getGpu())
                .ram(systemRequirements.getRam()).build();
    }
}
