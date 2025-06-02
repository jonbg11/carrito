package com.carrito.services;

import com.carrito.dto.ProductsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {

    List<ProductsDTO> getAllProducts();

    List<ProductsDTO> getProductsCategory(String category);

    ProductsDTO getProduct(String id);

    ProductsDTO createProduct(ProductsDTO dto);
}
