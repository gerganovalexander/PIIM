package com.tinqin.academy.piim.api.category.create;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryResult implements OperationResult {
    private Long id;
    private String name;
}
