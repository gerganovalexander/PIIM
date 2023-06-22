package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsResult;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsResult;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsResults;
import com.tinqin.academy.piim.api.systemrequirements.getbyid.GetSystemRequirementsByIdInput;
import com.tinqin.academy.piim.api.systemrequirements.getbyid.GetSystemRequirementsByIdOperation;
import com.tinqin.academy.piim.api.systemrequirements.getbyid.GetSystemRequirementsByIdResult;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system-requirements")
@RequiredArgsConstructor
public class SystemRequirementsController {

    private final CreateSystemRequirementsOperation createSystemRequirementsOperation;
    private final GetSystemRequirementsByIdOperation getSystemRequirementsByIdOperation;
    private final DeleteSystemRequirementsOperation deleteSystemRequirementsOperation;
    private final UpdateSystemRequirementsOperation updateSystemRequirementsOperation;
    private final GetAllSystemRequirementsOperation getAllSystemRequirementsOperation;

    @GetMapping
    public GetAllSystemRequirementsResults getAll() {
        return getAllSystemRequirementsOperation.process(
                GetAllSystemRequirementsInput.builder().build());
    }

    @GetMapping("/{id}")
    public GetSystemRequirementsByIdResult getRequirementsById(@PathVariable Long id) {
        GetSystemRequirementsByIdInput getSystemRequirementsByIdInput = new GetSystemRequirementsByIdInput(id);
        return getSystemRequirementsByIdOperation.process(getSystemRequirementsByIdInput);
    }

    @PostMapping
    public CreateSystemRequirementsResult createSystemRequirements(
            @RequestBody CreateSystemRequirementsInput systemRequirementsInput) {
        return createSystemRequirementsOperation.process(systemRequirementsInput);
    }

    @PutMapping("/{id}")
    public UpdateSystemRequirementsResult updateSystemRequirements(
            @PathVariable Long id, @RequestBody @Valid UpdateSystemRequirementsInput systemRequirementsInput) {
        systemRequirementsInput.setId(id);
        return updateSystemRequirementsOperation.process(systemRequirementsInput);
    }

    @DeleteMapping("/{id}")
    public DeleteSystemRequirementsResult deleteSystemRequirements(@PathVariable Long id) {
        DeleteSystemRequirementsInput deleteSystemRequirementsInput = new DeleteSystemRequirementsInput(id);
        return deleteSystemRequirementsOperation.process(deleteSystemRequirementsInput);
    }
}
