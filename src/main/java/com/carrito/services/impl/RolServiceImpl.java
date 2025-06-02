package com.carrito.services.impl;

import com.carrito.dto.RolDTO;
import com.carrito.entities.RolEntity;
import com.carrito.mappers.RolMapper;
import com.carrito.repositories.RolRepository;
import com.carrito.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository repository;

    @Autowired
    RolMapper mapper;

    @Override
    public RolDTO createRol(RolDTO dto) {
        RolEntity entity = mapper.toEntity(dto);
        RolEntity entitySaved = repository.save(entity);
        return mapper.toDTO(entitySaved);
    }
}
