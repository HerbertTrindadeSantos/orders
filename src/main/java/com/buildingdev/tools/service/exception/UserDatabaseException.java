package com.buildingdev.tools.service.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException(Long id) {
        super("O usuario nao pode ser excluido id: "+id);
    }
}
