package com.buildingdev.tools.service;


import com.buildingdev.tools.entities.Category;
import com.buildingdev.tools.service.exception.CategoryNotFoundException;
import com.buildingdev.tools.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){

        return categoryRepository.findAll();
    }

    public Category findById(long id){

        Category category = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Categoria nao encontrada id:"+ id));

        return category;
    }
}
