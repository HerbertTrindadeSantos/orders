package com.buildingdev.tools.controller.exception;

import com.buildingdev.tools.service.exception.DatabaseException;
import com.buildingdev.tools.service.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class ResourceExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandError> userNotFound(UserNotFoundException e, HttpServletRequest request){
        String error = "Usuario nao encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandError standError = new StandError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(standError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandError> databaseException(DatabaseException e,HttpServletRequest request){
        String error = "Usuario nao pode ser excluido";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandError standError = new StandError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(standError);
    }
}
