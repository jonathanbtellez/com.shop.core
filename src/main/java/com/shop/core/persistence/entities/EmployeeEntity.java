package com.shop.core.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "employees")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String position;
}
