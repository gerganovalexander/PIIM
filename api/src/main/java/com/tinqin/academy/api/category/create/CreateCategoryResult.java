package com.tinqin.academy.api.category.create;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryResult implements OperationResult {
    private Long id;
    private String name;
}