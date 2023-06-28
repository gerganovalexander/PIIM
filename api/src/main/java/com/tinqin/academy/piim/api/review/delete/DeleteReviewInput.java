package com.tinqin.academy.piim.api.review.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteReviewInput implements OperationInput {
    @NotNull
    private Long id;
}
