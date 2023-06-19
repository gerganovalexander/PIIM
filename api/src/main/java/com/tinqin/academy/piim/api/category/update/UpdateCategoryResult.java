package com.tinqin.academy.piim.api.category.update;

import com.tinqin.academy.piim.api.generics.OperationResult;
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
