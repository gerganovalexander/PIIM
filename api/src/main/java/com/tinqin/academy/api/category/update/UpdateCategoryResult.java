package com.tinqin.academy.api.category.update;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCategoryResult implements OperationResult {
    private Long id;
    private String name;
}
