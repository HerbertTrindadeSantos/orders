package com.buildingdev.tools.service.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Usuario nao encontrado id: "+id);
    }
}
