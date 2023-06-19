package com.tinqin.academy.piim.api.category.getbyname;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByNameCategoryInput implements OperationInput {
    private String name;
}
