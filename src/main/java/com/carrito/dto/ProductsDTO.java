package com.carrito.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private CategoriesDTO category;

    private List<ShoppingCartDTO> shoppingCart;
}
