package com.carrito.mappers;

import com.carrito.dto.UsersDTO;
import com.carrito.entities.UsersEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    private static final ModelMapper MAPPER = new ModelMapper();

    public UsersDTO toDTO(UsersEntity entity) {
        return MAPPER.map(entity, UsersDTO.class);
    }

    public UsersEntity toEntity(UsersDTO dto) {
        return MAPPER.map(dto, UsersEntity.class);
    }
}
