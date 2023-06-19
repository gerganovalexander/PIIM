package com.tinqin.academy.piim.api.review.getbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdReviewInput implements OperationInput {

    private Long id;
}
