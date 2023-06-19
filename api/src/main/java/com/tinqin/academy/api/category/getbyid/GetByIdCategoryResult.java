package com.tinqin.academy.api.category.getbyid;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdCategoryResult implements OperationResult {
    private Long id;
    private String name;
}
