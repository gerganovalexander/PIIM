package com.tinqin.academy.api.category.getbyname;

import com.tinqin.academy.api.generics.OperationResult;
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
