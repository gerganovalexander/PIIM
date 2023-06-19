package com.tinqin.academy.piim.business.converters.systemrequirements.update;

import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsResult;
import com.tinqin.academy.piim.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SystemRequirementsToUpdateSystemRequirementsResultConverter implements Converter<SystemRequirements, UpdateSystemRequirementsResult> {
    @Override
    public UpdateSystemRequirementsResult convert(SystemRequirements systemRequirements) {
        return UpdateSystemRequirementsResult.builder()
                .id(systemRequirements.getId())
                .operatingSystem(systemRequirements.getOperatingSystem())
                .cpu(systemRequirements.getCpu())
                .gpu(systemRequirements.getGpu())
                .ram(systemRequirements.getRam()).build();
    }
}
