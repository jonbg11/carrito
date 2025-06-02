package com.carrito.services;

import com.carrito.dto.CategoriesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriesService {

    List<CategoriesDTO> getAllCategories();

    CategoriesDTO createCategory(CategoriesDTO dto);
}
