package com.tinqin.academy.piim.api.category.getbyname;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByNameCategoryResult implements OperationResult {
    private Long id;
    private String name;
}
