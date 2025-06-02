package com.carrito.services;

import com.carrito.dto.UsersDTO;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    UsersDTO createUser(UsersDTO dto);

    UsersDTO validateUser(String email, String password);
}
