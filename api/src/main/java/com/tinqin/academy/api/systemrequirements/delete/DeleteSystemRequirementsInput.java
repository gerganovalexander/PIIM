package com.tinqin.academy.api.systemrequirements.delete;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSystemRequirementsInput implements OperationInput {
    Long id;

}
