package com.tinqin.academy.piim.api.category.getbyid;

import com.tinqin.academy.piim.api.generics.OperationResult;
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
