package com.carrito.services.impl;

import com.carrito.dto.ProductsDTO;
import com.carrito.entities.CategoriesEntity;
import com.carrito.entities.ProductsEntity;
import com.carrito.mappers.ProductsMapper;
import com.carrito.repositories.CategoriesRepository;
import com.carrito.repositories.ProductsRepository;
import com.carrito.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository repository;

    @Autowired
    ProductsMapper mapper;

    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public List<ProductsDTO> getAllProducts() {
        List<ProductsEntity> entities = repository.findAll();
        return entities.stream().map(mapper::toDTO).toList();
    }

    @Override
    public List<ProductsDTO> getProductsCategory(String category) {
        CategoriesEntity categoryEntity = categoriesRepository.findByName(category);

        List<ProductsEntity> entities = repository.findByCategory(categoryEntity);
        return entities.stream().map(mapper::toDTO).toList();
    }

    @Override
    public ProductsDTO getProduct(String id) {
        Optional<ProductsEntity> entity = repository.findById(id);
        return entity.map(productsEntity -> mapper.toDTO(productsEntity)).orElse(null);
    }

    @Override
    public ProductsDTO createProduct(ProductsDTO dto) {
        ProductsEntity entity = mapper.toEntity(dto);
        ProductsEntity entitySaved = repository.save(entity);
        return mapper.toDTO(entitySaved);
    }
}
