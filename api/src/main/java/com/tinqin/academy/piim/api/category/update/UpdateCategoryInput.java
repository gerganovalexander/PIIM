package com.tinqin.academy.piim.api.category.update;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCategoryInput implements OperationInput {
    @NotNull
    private Long id;

    @NotNull
    private String name;
}
