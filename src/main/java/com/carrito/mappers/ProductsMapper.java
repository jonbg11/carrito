package com.carrito.mappers;

import com.carrito.dto.ProductsDTO;
import com.carrito.entities.ProductsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductsMapper {

    private static final ModelMapper MAPPER = new ModelMapper();

    public ProductsDTO toDTO(ProductsEntity entity) {
        return MAPPER.map(entity, ProductsDTO.class);
    }

    public ProductsEntity toEntity(ProductsDTO dto) {
        return MAPPER.map(dto, ProductsEntity.class);
    }
}
