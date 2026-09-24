package com.buildingdev.tools.service.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Categoria nao encontrada id: "+ id);
    }
}
