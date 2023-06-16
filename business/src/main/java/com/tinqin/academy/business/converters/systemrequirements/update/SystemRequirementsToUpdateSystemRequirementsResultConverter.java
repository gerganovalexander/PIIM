package com.tinqin.academy.business.converters.systemrequirements.update;

import com.tinqin.academy.api.systemrequirements.update.UpdateSystemRequirementsResult;
import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SystemRequirementsToUpdateSystemRequirementsResultConverter implements Converter<SystemRequirements, UpdateSystemRequirementsResult> {
    @Override
    public UpdateSystemRequirementsResult convert(SystemRequirements systemRequirements) {
        return UpdateSystemRequirementsResult.builder()
                .id(systemRequirements.getSystemRequirementsId())
                .operatingSystem(systemRequirements.getOperatingSystem())
                .cpu(systemRequirements.getCpu())
                .gpu(systemRequirements.getGpu())
                .ram(systemRequirements.getRam()).build();
    }
}
