package com.tinqin.academy.piim.api.category.getall;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllCategoryResults implements OperationResult {
    private List<GetAllCategoryResult> results;
}
