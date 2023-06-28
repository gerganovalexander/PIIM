package com.tinqin.academy.piim.api.category.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryInput implements OperationInput {
    @NotNull
    private String name;
}
