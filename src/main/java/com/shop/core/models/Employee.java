package com.shop.core.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String position;
}
