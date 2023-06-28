package com.tinqin.academy.piim.api.review.update;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateReviewInput implements OperationInput {
    @NotNull
    private Long id;

    @NotNull
    private String text;
}
