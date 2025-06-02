package com.carrito.controllers;

import com.carrito.dto.ApiResponseDTO;
import com.carrito.dto.UsersDTO;
import com.carrito.services.UsersService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    UsersService service;

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDTO> createUser(@Valid @RequestBody UsersDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ApiResponseDTO("Revise los campos", null), HttpStatus.BAD_REQUEST);
        }
        UsersDTO response = service.createUser(request);
        return new ResponseEntity<>(new ApiResponseDTO("Creado correctamente", response), HttpStatus.OK);
    }

    @GetMapping("/validate")
    public ResponseEntity<ApiResponseDTO> validateUser(@RequestParam() String email, @RequestParam() String password) {
        UsersDTO response = service.validateUser(email, password);
        if (Objects.nonNull(response)) {
            return new ResponseEntity<>(new ApiResponseDTO(HttpStatus.OK.name(), response), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponseDTO(HttpStatus.NOT_FOUND.name(), null), HttpStatus.NOT_FOUND);
        }
    }
}
