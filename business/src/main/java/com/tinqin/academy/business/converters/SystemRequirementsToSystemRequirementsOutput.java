package com.tinqin.academy.business.converters;

import com.tinqin.academy.api.entityoutputmodels.SystemRequirementsOutput;
import com.tinqin.academy.data.models.SystemRequirements;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SystemRequirementsToSystemRequirementsOutput implements Converter<SystemRequirements, SystemRequirementsOutput> {
    @Override
    public SystemRequirementsOutput convert(SystemRequirements source) {
        return SystemRequirementsOutput.builder()
                .id(source.getId())
                .operatingSystem(source.getOperatingSystem())
                .cpu(source.getCpu())
                .gpu(source.getGpu())
                .ram(source.getRam())
                .build();
    }
}
