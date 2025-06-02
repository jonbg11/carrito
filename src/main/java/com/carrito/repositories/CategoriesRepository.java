package com.carrito.repositories;

import com.carrito.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, String> {

    CategoriesEntity findByName(String name);
}
