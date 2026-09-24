package com.buildingdev.tools.dto;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl
) {
}
