package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.category.create.CreateCategoryInput;
import com.tinqin.academy.piim.api.category.create.CreateCategoryOperation;
import com.tinqin.academy.piim.api.category.delete.DeleteCategoryInput;
import com.tinqin.academy.piim.api.category.delete.DeleteCategoryOperation;
import com.tinqin.academy.piim.api.category.getall.GetAllCategoryInput;
import com.tinqin.academy.piim.api.category.getall.GetAllCategoryOperation;
import com.tinqin.academy.piim.api.category.getbyid.GetByIdCategoryInput;
import com.tinqin.academy.piim.api.category.getbyid.GetByIdCategoryOperation;
import com.tinqin.academy.piim.api.category.getbyname.GetByNameCategoryInput;
import com.tinqin.academy.piim.api.category.getbyname.GetByNameCategoryOperation;
import com.tinqin.academy.piim.api.category.update.UpdateCategoryInput;
import com.tinqin.academy.piim.api.category.update.UpdateCategoryOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController extends BaseController {

    private final GetAllCategoryOperation getAllCategoryOperation;
    private final GetByIdCategoryOperation getByIdCategoryOperation;
    private final GetByNameCategoryOperation getByNameCategoryOperation;
    private final CreateCategoryOperation createCategoryOperation;
    private final UpdateCategoryOperation updateCategoryOperation;
    private final DeleteCategoryOperation deleteCategoryOperation;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return handleOperation(
                getAllCategoryOperation.process(GetAllCategoryInput.builder().build()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return handleOperation(getByIdCategoryOperation.process(
                GetByIdCategoryInput.builder().id(id).build()));
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> getByName(@RequestParam(name = "name") String name) {
        return handleOperation(getByNameCategoryOperation.process(
                GetByNameCategoryInput.builder().name(name).build()));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateCategoryInput input) {
        return handleOperation(createCategoryOperation.process(input));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody @Valid UpdateCategoryInput input) {
        input.setId(id);
        return handleOperation(updateCategoryOperation.process(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return handleOperation(deleteCategoryOperation.process(
                DeleteCategoryInput.builder().id(id).build()));
    }
}
