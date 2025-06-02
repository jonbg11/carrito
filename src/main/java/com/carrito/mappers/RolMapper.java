package com.carrito.mappers;

import com.carrito.dto.RolDTO;
import com.carrito.entities.RolEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    private static final ModelMapper MAPPER = new ModelMapper();

    public RolDTO toDTO(RolEntity entity) {
        return MAPPER.map(entity, RolDTO.class);
    }

    public RolEntity toEntity(RolDTO dto) {
        return MAPPER.map(dto, RolEntity.class);
    }
}
