package com.tinqin.academy.business.operations.systemrequirements.getall;

import com.tinqin.academy.api.systemrequirements.getall.GetAllSystemRequirementsInput;
import com.tinqin.academy.api.systemrequirements.getall.GetAllSystemRequirementsOperation;
import com.tinqin.academy.api.systemrequirements.getall.GetAllSystemRequirementsResult;
import com.tinqin.academy.api.systemrequirements.getall.GetAllSystemRequirementsResults;
import com.tinqin.academy.data.models.SystemRequirements;
import com.tinqin.academy.data.repositories.SystemRequirementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllSystemRequirementsOperationProcessor implements GetAllSystemRequirementsOperation {

    private final SystemRequirementsRepository systemRequirementsRepository;
    private final ConversionService conversionService;

    @Override
    public GetAllSystemRequirementsResults process(GetAllSystemRequirementsInput input) {
        GetAllSystemRequirementsResults allSystemRequirementsResults = new GetAllSystemRequirementsResults();
        List<GetAllSystemRequirementsResult> list = allSystemRequirementsResults.getSystemRequirementsResults();

        for (SystemRequirements systemRequirements : systemRequirementsRepository.findAll()) {
            GetAllSystemRequirementsResult convertedSystemRequirements = conversionService.convert(systemRequirements, GetAllSystemRequirementsResult.class);
            list.add(convertedSystemRequirements);
        }

        return allSystemRequirementsResults;
    }
}
