package com.tinqin.academy.web.controllers;

import com.tinqin.academy.business.dtos.SystemRequirementsDto;
import com.tinqin.academy.business.mappers.SysRequirementsMapper;
import com.tinqin.academy.business.services.contracts.SystemRequirementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.tinqin.academy.business.mappers.SysRequirementsMapper.dtoToSysReq;
import static com.tinqin.academy.business.mappers.SysRequirementsMapper.sysReqToDto;

@RestController
@RequestMapping("api/system_requirements")
@RequiredArgsConstructor
public class SystemRequirementsController {

    private final SystemRequirementsService systemRequirementsService;

    @GetMapping
    public List<SystemRequirementsDto> getAll() {
        return systemRequirementsService.getAll().stream()
                .map(SysRequirementsMapper::sysReqToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SystemRequirementsDto getRequirementsById(@PathVariable Long id) {
        return sysReqToDto(systemRequirementsService.getSystemRequirementsById(id));
    }

    @PostMapping
    public SystemRequirementsDto createSystemRequirements(@RequestBody SystemRequirementsDto systemRequirementsObject) {
        return sysReqToDto(systemRequirementsService.create(dtoToSysReq(systemRequirementsObject)));
    }

    @PutMapping("{id}")
    public void updateSystemRequirements(@PathVariable Long id, @RequestBody SystemRequirementsDto systemRequirementsObject) {
        // No Mapper
        systemRequirementsService.update(dtoToSysReq(systemRequirementsObject, id));
    }

    @DeleteMapping("{id}")
    public void deleteSystemRequirements(@PathVariable Long id) {
        systemRequirementsService.delete(id);
    }

}
