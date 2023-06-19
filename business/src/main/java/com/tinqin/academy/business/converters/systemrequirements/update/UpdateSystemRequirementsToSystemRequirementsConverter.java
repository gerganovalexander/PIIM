package com.tinqin.academy.business.converters.systemrequirements.update;

import com.tinqin.academy.api.systemrequirements.update.UpdateSystemRequirementsInput;
import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateSystemRequirementsToSystemRequirementsConverter implements Converter<UpdateSystemRequirementsInput, SystemRequirements> {

    @Override
    public SystemRequirements convert(UpdateSystemRequirementsInput updateSystemRequirementsInput) {
        return SystemRequirements.builder()
                .id(updateSystemRequirementsInput.getId())
                .operatingSystem(updateSystemRequirementsInput.getOperatingSystem())
                .cpu(updateSystemRequirementsInput.getCpu())
                .gpu(updateSystemRequirementsInput.getGpu())
                .ram(updateSystemRequirementsInput.getRam())
                .build();
    }
}
