package com.carrito.mappers;

import com.carrito.dto.ShoppingCartDTO;
import com.carrito.entities.ShoppingCartEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {

    private static final ModelMapper MAPPER = new ModelMapper();

    public ShoppingCartDTO toDTO(ShoppingCartEntity entity) {
        return MAPPER.map(entity, ShoppingCartDTO.class);
    }

    public ShoppingCartEntity toEntity(ShoppingCartDTO dto) {
        return MAPPER.map(dto, ShoppingCartEntity.class);
    }
}
