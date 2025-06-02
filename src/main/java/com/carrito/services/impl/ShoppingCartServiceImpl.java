package com.carrito.services.impl;

import com.carrito.dto.ShoppingCartDTO;
import com.carrito.entities.ShoppingCartEntity;
import com.carrito.entities.UsersEntity;
import com.carrito.mappers.ShoppingCartMapper;
import com.carrito.repositories.ShoppingCartRepository;
import com.carrito.repositories.UsersRepository;
import com.carrito.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository repository;

    @Autowired
    ShoppingCartMapper mapper;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO dto) {
        ShoppingCartEntity entity = mapper.toEntity(dto);
        ShoppingCartEntity entitySaved = repository.save(entity);
        return mapper.toDTO(entitySaved);
    }

    @Override
    public ShoppingCartDTO getShoppingCartByUser(String email) {
        UsersEntity usersEntity = usersRepository.findByEmail(email);

        ShoppingCartEntity entity = repository.findByUser(usersEntity);
        return mapper.toDTO(entity);
    }

    @Override
    public ShoppingCartDTO updateShoppingCart(ShoppingCartDTO dto) {
        ShoppingCartEntity entity = mapper.toEntity(dto);
        ShoppingCartEntity entitySaved = repository.save(entity);
        return mapper.toDTO(entitySaved);
    }
}
