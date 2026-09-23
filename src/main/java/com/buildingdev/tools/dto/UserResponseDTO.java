package com.buildingdev.tools.dto;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        String password
) {
}
