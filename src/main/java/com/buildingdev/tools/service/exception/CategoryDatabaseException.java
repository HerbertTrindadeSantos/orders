package com.buildingdev.tools.service.exception;

public class CategoryDatabaseException extends RuntimeException{
    public CategoryDatabaseException(Long id) {
        super("Categoria nao pode ser excluida id: "+id);
    }
}
