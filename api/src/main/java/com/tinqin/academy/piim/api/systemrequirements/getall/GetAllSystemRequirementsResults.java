package com.tinqin.academy.piim.api.systemrequirements.getall;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSystemRequirementsResults implements OperationResult {

    private List<GetAllSystemRequirementsResult> systemRequirementsResults;
}
