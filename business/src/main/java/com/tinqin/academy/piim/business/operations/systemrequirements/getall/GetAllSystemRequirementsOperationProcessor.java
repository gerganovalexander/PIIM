package com.tinqin.academy.piim.business.operations.systemrequirements.getall;

import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsResult;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsResults;
import com.tinqin.academy.piim.data.repositories.SystemRequirementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetAllSystemRequirementsOperationProcessor implements GetAllSystemRequirementsOperation {

    private final SystemRequirementsRepository systemRequirementsRepository;
    private final ConversionService conversionService;

    @Override
    public GetAllSystemRequirementsResults process(GetAllSystemRequirementsInput input) {
        List<GetAllSystemRequirementsResult> list = systemRequirementsRepository.findAll().stream()
                .map(systemRequirements ->
                        conversionService.convert(systemRequirements, GetAllSystemRequirementsResult.class))
                .collect(Collectors.toList());

        return GetAllSystemRequirementsResults.builder()
                .systemRequirementsResults(list)
                .build();
    }
}
