package com.valik.dao;

import com.valik.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAll();


    Category getById(Long id);
}
