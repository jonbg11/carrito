package com.carrito.services;

import com.carrito.dto.RolDTO;
import org.springframework.stereotype.Service;

@Service
public interface RolService {

    RolDTO createRol(RolDTO dto);
}
