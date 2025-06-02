package com.carrito.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "image")
    private Double image;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private CategoriesEntity category;

    @OneToMany(mappedBy = "products", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<ShoppingCartEntity> shoppingCart;
}
