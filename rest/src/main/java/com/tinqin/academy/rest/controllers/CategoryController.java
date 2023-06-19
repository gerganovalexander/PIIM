package com.tinqin.academy.rest.controllers;

import com.tinqin.academy.api.category.create.CreateCategoryInput;
import com.tinqin.academy.api.category.create.CreateCategoryOperation;
import com.tinqin.academy.api.category.create.CreateCategoryResult;
import com.tinqin.academy.api.category.delete.DeleteCategoryInput;
import com.tinqin.academy.api.category.delete.DeleteCategoryOperation;
import com.tinqin.academy.api.category.delete.DeleteCategoryResult;
import com.tinqin.academy.api.category.getall.GetAllCategoryInput;
import com.tinqin.academy.api.category.getall.GetAllCategoryOperation;
import com.tinqin.academy.api.category.getall.GetAllCategoryResults;
import com.tinqin.academy.api.category.getbyid.GetByIdCategoryInput;
import com.tinqin.academy.api.category.getbyid.GetByIdCategoryOperation;
import com.tinqin.academy.api.category.getbyid.GetByIdCategoryResult;
import com.tinqin.academy.api.category.getbyname.GetByNameCategoryInput;
import com.tinqin.academy.api.category.getbyname.GetByNameCategoryOperation;
import com.tinqin.academy.api.category.getbyname.GetByNameCategoryResult;
import com.tinqin.academy.api.category.update.UpdateCategoryInput;
import com.tinqin.academy.api.category.update.UpdateCategoryOperation;
import com.tinqin.academy.api.category.update.UpdateCategoryResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final GetAllCategoryOperation getAllCategoryOperation;
    private final GetByIdCategoryOperation getByIdCategoryOperation;
    private final GetByNameCategoryOperation getByNameCategoryOperation;
    private final CreateCategoryOperation createCategoryOperation;
    private final UpdateCategoryOperation updateCategoryOperation;
    private final DeleteCategoryOperation deleteCategoryOperation;

    @GetMapping
    public GetAllCategoryResults getAll() {
        return getAllCategoryOperation.process(GetAllCategoryInput.builder().build());
    }

    @GetMapping("/{id}")
    public GetByIdCategoryResult getById(@PathVariable long id) {
        return getByIdCategoryOperation.process(GetByIdCategoryInput.builder().id(id).build());
    }

    @GetMapping(params = "name")
    public GetByNameCategoryResult getByName(@RequestParam(name = "name") String name) {
        return getByNameCategoryOperation.process(GetByNameCategoryInput.builder().name(name).build());
    }

    @PostMapping
    public CreateCategoryResult create(@RequestBody @Valid CreateCategoryInput input) {
        return createCategoryOperation.process(input);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResult update(@PathVariable long id, @RequestBody @Valid UpdateCategoryInput input) {
        input.setId(id);
        return updateCategoryOperation.process(input);
    }

    @DeleteMapping("/{id}")
    public DeleteCategoryResult delete(@PathVariable long id) {
        return deleteCategoryOperation.process(DeleteCategoryInput.builder().id(id).build());
    }
}
