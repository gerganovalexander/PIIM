package com.tinqin.academy.api.systemrequirements.getall;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class GetAllSystemRequirementsResults implements OperationResult {
    private final List<GetAllSystemRequirementsResult> systemRequirementsResults;

    public GetAllSystemRequirementsResults() {
        systemRequirementsResults = new ArrayList<>();
    }
}
