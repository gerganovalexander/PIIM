package com.tinqin.academy.piim.business.operations.categories;

import com.tinqin.academy.piim.api.category.getall.GetAllCategoryInput;
import com.tinqin.academy.piim.api.category.getall.GetAllCategoryOperation;
import com.tinqin.academy.piim.api.category.getall.GetAllCategoryResult;
import com.tinqin.academy.piim.api.category.getall.GetAllCategoryResults;
import com.tinqin.academy.piim.data.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetAllCategoryOperationProcessor implements GetAllCategoryOperation {

    private final CategoryRepository categoryRepository;
    private final ConversionService conversionService;

    @Override
    public GetAllCategoryResults process(GetAllCategoryInput input) {
        List<GetAllCategoryResult> results = categoryRepository.findAll().stream()
                .map(category -> conversionService.convert(category, GetAllCategoryResult.class))
                .collect(Collectors.toList());

        return GetAllCategoryResults.builder().results(results).build();
    }
}
