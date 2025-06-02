package com.carrito.controllers;

import com.carrito.dto.ApiResponseDTO;
import com.carrito.dto.RolDTO;
import com.carrito.services.RolService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/roles")
public class RolController {

    @Autowired
    RolService service;

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDTO> createRol(@Valid @RequestBody RolDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ApiResponseDTO("Revise los campos", null), HttpStatus.BAD_REQUEST);
        }
        RolDTO response = service.createRol(request);
        return new ResponseEntity<>(new ApiResponseDTO("Creado correctamente", response), HttpStatus.OK);
    }
}
