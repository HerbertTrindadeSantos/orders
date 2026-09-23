package com.buildingdev.tools.dto;

public record UserRequestDTO(
        String name,
        String email,
        String phone,
        String password
        ) {
}
