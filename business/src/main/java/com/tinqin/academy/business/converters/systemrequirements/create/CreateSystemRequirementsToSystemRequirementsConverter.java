package com.tinqin.academy.business.converters.systemrequirements.create;

import com.tinqin.academy.api.systemrequirements.create.CreateSystemRequirementsInput;
import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateSystemRequirementsToSystemRequirementsConverter implements Converter<CreateSystemRequirementsInput, SystemRequirements> {

    @Override
    public SystemRequirements convert(CreateSystemRequirementsInput systemRequirementsInput) {
        return SystemRequirements.builder()
                .operatingSystem(systemRequirementsInput.getOperatingSystem())
                .cpu(systemRequirementsInput.getCpu())
                .gpu(systemRequirementsInput.getGpu())
                .ram(systemRequirementsInput.getRam())
                .build();
    }
}
