package com.carrito.services.impl;

import com.carrito.dto.UsersDTO;
import com.carrito.entities.UsersEntity;
import com.carrito.mappers.UsersMapper;
import com.carrito.repositories.UsersRepository;
import com.carrito.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository repository;

    @Autowired
    UsersMapper mapper;

    @Override
    public UsersDTO createUser(UsersDTO dto) {
        UsersEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public UsersDTO validateUser(String email, String password) {
        UsersEntity entity = repository.findByEmailAndPassword(email, password);
        if (Objects.nonNull(entity)) {
            return mapper.toDTO(entity);
        }
        return null;
    }
}
