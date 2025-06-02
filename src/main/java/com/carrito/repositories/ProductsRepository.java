package com.carrito.repositories;

import com.carrito.entities.CategoriesEntity;
import com.carrito.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, String> {

    List<ProductsEntity> findByCategory(CategoriesEntity category);
}
