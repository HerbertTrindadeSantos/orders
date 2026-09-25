package com.buildingdev.tools.service;


import com.buildingdev.tools.dto.CategoryRequestDTO;
import com.buildingdev.tools.dto.CategoryResponseDTO;
import com.buildingdev.tools.dto.mapper.CategoryMapper;
import com.buildingdev.tools.entities.Category;
import com.buildingdev.tools.service.exception.CategoryDatabaseException;
import com.buildingdev.tools.service.exception.CategoryNotFoundException;
import com.buildingdev.tools.repositories.CategoryRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponseDTO> findAll(){
        return categoryRepository.findAll().stream().map(categoryMapper::toResponse).toList();
    }

    public CategoryResponseDTO findById(long id){
        Category category = categoryRepository.findById(id).
                orElseThrow(()-> new CategoryNotFoundException(id));

        return categoryMapper.toResponse(category);
    }

    public CategoryResponseDTO insert(CategoryRequestDTO category){
        Category entity = categoryMapper.toEntity(category);
        categoryRepository.save(entity);

        return categoryMapper.toResponse(entity);
    }

    public CategoryResponseDTO update(Long id,CategoryRequestDTO category){
        Category entity = categoryRepository.findById(id).
                orElseThrow(()-> new CategoryNotFoundException(id));

        entity = categoryRepository.save(updateData(entity,category));

        return categoryMapper.toResponse(entity);
    }

    private Category updateData(Category entity, CategoryRequestDTO category){
        entity.setName(category.name());

        return entity;
    }

    public void deleteById(Long id){
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new CategoryNotFoundException(id));
        try {
            categoryRepository.delete(category);
        } catch (DataIntegrityViolationException e) {
            throw new CategoryDatabaseException(id);
        }
    }

}
