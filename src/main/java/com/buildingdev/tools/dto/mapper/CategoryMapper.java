package com.buildingdev.tools.dto.mapper;

import com.buildingdev.tools.dto.CategoryRequestDTO;
import com.buildingdev.tools.dto.CategoryResponseDTO;
import com.buildingdev.tools.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO category){
        Category entity = new Category();
        entity.setName(category.name());

        return entity;
    }

    public CategoryResponseDTO toResponse(Category category){
        return new CategoryResponseDTO(
                category.getId(),
                category.getName()
        );
    }
}
