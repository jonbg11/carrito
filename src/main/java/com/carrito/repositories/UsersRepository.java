package com.carrito.repositories;

import com.carrito.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> {

    UsersEntity findByEmail(String email);

    UsersEntity findByEmailAndPassword(String email, String password);
}
