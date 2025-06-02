package com.carrito.services;

import com.carrito.dto.ShoppingCartDTO;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {

    ShoppingCartDTO createShoppingCart(ShoppingCartDTO dto);

    ShoppingCartDTO getShoppingCartByUser(String email);

    ShoppingCartDTO updateShoppingCart(ShoppingCartDTO dto);
}
