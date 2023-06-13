package com.tinqin.academy.business.services.contracts;

import com.tinqin.academy.data.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getById(long id);

    Category getByName(String name);

    Category create(Category category);

    Category update(Category category);

    void delete(long id);
}
