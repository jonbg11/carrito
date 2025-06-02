package com.carrito.controllers;

import com.carrito.dto.ApiResponseDTO;
import com.carrito.dto.ShoppingCartDTO;
import com.carrito.services.ShoppingCartService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/shoppingcart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService service;

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDTO> createShoppingCart(@Valid @RequestBody ShoppingCartDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ApiResponseDTO("Revise los campos", null), HttpStatus.BAD_REQUEST);
        }
        ShoppingCartDTO response = service.createShoppingCart(request);
        return new ResponseEntity<>(new ApiResponseDTO("Creado correctamente", response), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDTO> updateShoppingCart(@Valid @RequestBody ShoppingCartDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ApiResponseDTO("Revise los campos", null), HttpStatus.BAD_REQUEST);
        }
        ShoppingCartDTO response = service.updateShoppingCart(request);
        return new ResponseEntity<>(new ApiResponseDTO("Creado correctamente", response), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponseDTO> getShoppingCart(@RequestParam() String email) {
        return new ResponseEntity<>(new ApiResponseDTO(HttpStatus.OK.name(), service.getShoppingCartByUser(email)), HttpStatus.OK);
    }
}
