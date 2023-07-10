package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsOperation;
import com.tinqin.academy.piim.api.systemrequirements.getbyid.GetSystemRequirementsByIdInput;
import com.tinqin.academy.piim.api.systemrequirements.getbyid.GetSystemRequirementsByIdOperation;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system-requirements")
@RequiredArgsConstructor
public class SystemRequirementsController extends BaseController {

    private final CreateSystemRequirementsOperation createSystemRequirementsOperation;
    private final GetSystemRequirementsByIdOperation getSystemRequirementsByIdOperation;
    private final DeleteSystemRequirementsOperation deleteSystemRequirementsOperation;
    private final UpdateSystemRequirementsOperation updateSystemRequirementsOperation;
    private final GetAllSystemRequirementsOperation getAllSystemRequirementsOperation;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return handleOperation(getAllSystemRequirementsOperation.process(
                GetAllSystemRequirementsInput.builder().build()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRequirementsById(@PathVariable Long id) {
        GetSystemRequirementsByIdInput getSystemRequirementsByIdInput = new GetSystemRequirementsByIdInput(id);
        return handleOperation(getSystemRequirementsByIdOperation.process(getSystemRequirementsByIdInput));
    }

    @PostMapping
    public ResponseEntity<?> createSystemRequirements(
            @RequestBody CreateSystemRequirementsInput systemRequirementsInput) {
        return handleOperation(createSystemRequirementsOperation.process(systemRequirementsInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSystemRequirements(
            @PathVariable Long id, @RequestBody @Valid UpdateSystemRequirementsInput systemRequirementsInput) {
        systemRequirementsInput.setId(id);
        return handleOperation(updateSystemRequirementsOperation.process(systemRequirementsInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSystemRequirements(@PathVariable Long id) {
        DeleteSystemRequirementsInput deleteSystemRequirementsInput = new DeleteSystemRequirementsInput(id);
        return handleOperation(deleteSystemRequirementsOperation.process(deleteSystemRequirementsInput));
    }
}
