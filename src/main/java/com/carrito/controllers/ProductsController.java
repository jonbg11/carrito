package com.carrito.controllers;

import com.carrito.dto.ApiResponseDTO;
import com.carrito.dto.ProductsDTO;
import com.carrito.services.ProductsService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    ProductsService service;

    @GetMapping("/all")
    public ResponseEntity<ApiResponseDTO> getAllProducts() {
        return new ResponseEntity<>(new ApiResponseDTO(HttpStatus.OK.name(), service.getAllProducts()), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<ApiResponseDTO> getProductsCategory(@RequestParam() String category) {
        return new ResponseEntity<>(new ApiResponseDTO(HttpStatus.OK.name(), service.getProductsCategory(category)), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponseDTO> getProduct(@RequestParam() String id) {
        return new ResponseEntity<>(new ApiResponseDTO(HttpStatus.OK.name(), service.getProduct(id)), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDTO> createProduct(@Valid @RequestBody ProductsDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ApiResponseDTO("Revise los campos", null), HttpStatus.BAD_REQUEST);
        }
        ProductsDTO response = service.createProduct(request);
        return new ResponseEntity<>(new ApiResponseDTO("Creado correctamente", response), HttpStatus.OK);
    }
}
