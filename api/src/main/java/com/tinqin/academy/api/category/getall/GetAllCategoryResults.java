package com.tinqin.academy.api.category.getall;

import com.tinqin.academy.api.generics.OperationResult;
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
