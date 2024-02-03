package com.shop.core.models;

import lombok.*;

//@Getter
//@Setter
//empty constructor
//@NoArgsConstructor
//Constructor with all arguments
//@AllArgsConstructor
//Garatize that al elements are uniques
//@EqualsAndHashCode
//@ToString

//Contain a lot of annotations lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
}
