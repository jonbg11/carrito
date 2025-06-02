package com.carrito.repositories;

import com.carrito.entities.ShoppingCartEntity;
import com.carrito.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, String> {

    ShoppingCartEntity findByUser(UsersEntity user);
}
