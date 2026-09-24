package com.buildingdev.tools.service.exception;

public class UserDatabaseException extends RuntimeException {
    public UserDatabaseException(Long id) {
        super("O usuario nao pode ser excluido id: "+id);
    }
}
