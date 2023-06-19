package com.tinqin.academy.piim.api.review.update;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateReviewInput implements OperationInput {
    private Long id;
    private String text;
}
