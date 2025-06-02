package com.carrito.controllers;

import com.carrito.dto.ApiResponseDTO;
import com.carrito.dto.CategoriesDTO;
import com.carrito.services.CategoriesService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/categories")
public class CategoriesController {

    @Autowired
    CategoriesService service;

    @GetMapping("/all")
    public ResponseEntity<ApiResponseDTO> getAllCategories() {
        return new ResponseEntity<>(new ApiResponseDTO(HttpStatus.OK.name(), service.getAllCategories()), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDTO> createCategory(@Valid @RequestBody CategoriesDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ApiResponseDTO("Revise los campos", null), HttpStatus.BAD_REQUEST);
        }
        CategoriesDTO response = service.createCategory(request);
        return new ResponseEntity<>(new ApiResponseDTO("Creado correctamente", response), HttpStatus.OK);
    }
}
