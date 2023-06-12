package com.tinqin.academy.piim.services.contracts;

import com.tinqin.academy.piim.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getById(long id);

    Category getByName(String name);

    Category create(Category category);

    Category update(Category category);

    void delete(long id);
}
