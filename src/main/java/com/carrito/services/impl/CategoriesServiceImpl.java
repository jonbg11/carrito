package com.carrito.services.impl;

import com.carrito.dto.CategoriesDTO;
import com.carrito.entities.CategoriesEntity;
import com.carrito.mappers.CategoriesMapper;
import com.carrito.repositories.CategoriesRepository;
import com.carrito.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoriesRepository repository;

    @Autowired
    CategoriesMapper mapper;

    @Override
    public List<CategoriesDTO> getAllCategories() {
        List<CategoriesEntity> categoriesEntities = repository.findAll();
        return categoriesEntities.stream().map(mapper::toDTO).toList();
    }

    @Override
    public CategoriesDTO createCategory(CategoriesDTO dto) {
        CategoriesEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }
}
