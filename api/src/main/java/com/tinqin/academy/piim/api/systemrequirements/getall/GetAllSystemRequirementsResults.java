package com.tinqin.academy.piim.api.systemrequirements.getall;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSystemRequirementsResults implements OperationResult {

    private List<GetAllSystemRequirementsResult> systemRequirementsResults;
}
