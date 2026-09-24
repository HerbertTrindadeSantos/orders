package com.buildingdev.tools.dto;

public record ProductRequestDTO(
        String name,
        String description,
        Double price,
        String imgUrl
) {
}
