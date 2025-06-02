package com.carrito.mappers;

import com.carrito.dto.CategoriesDTO;
import com.carrito.entities.CategoriesEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriesMapper {

    private static final ModelMapper MAPPER = new ModelMapper();

    public CategoriesDTO toDTO(CategoriesEntity entity) {
        return MAPPER.map(entity, CategoriesDTO.class);
    }

    public CategoriesEntity toEntity(CategoriesDTO dto) {
        return MAPPER.map(dto, CategoriesEntity.class);
    }
}
