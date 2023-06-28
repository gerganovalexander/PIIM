package com.tinqin.academy.piim.api.category.getbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdCategoryInput implements OperationInput {
    @NotNull
    private Long id;
}
