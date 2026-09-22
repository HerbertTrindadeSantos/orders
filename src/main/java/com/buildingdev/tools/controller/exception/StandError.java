package com.buildingdev.tools.controller.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record StandError(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}
