package com.tinqin.academy.piim.controllers;

import com.tinqin.academy.piim.models.SystemRequirements;
import com.tinqin.academy.piim.services.contracts.SystemRequirementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/system_requirements")
@RequiredArgsConstructor
public class SystemRequirementsController {

    private final SystemRequirementsService systemRequirementsService;

    @GetMapping
    public List<SystemRequirements> getAll() {
        return systemRequirementsService.getAll();
    }

    @GetMapping("/{id}")
    public SystemRequirements getRequirementsById(@PathVariable Long id) {
        return systemRequirementsService.getSystemRequirementsById(id);
    }

    @PostMapping
    public SystemRequirements createSystemRequirements(@RequestBody SystemRequirements systemRequirementsObject) {
        return systemRequirementsService.create(systemRequirementsObject);
    }

    @PutMapping("{id}")
    public void updateSystemRequirements(@PathVariable Long id, @RequestBody SystemRequirements systemRequirementsObject) {
        // No Mapper
        systemRequirementsService.update(systemRequirementsObject);
    }

    @DeleteMapping("{id}")
    public void deleteSystemRequirements(@PathVariable Long id) {
        systemRequirementsService.delete(id);
    }

}
