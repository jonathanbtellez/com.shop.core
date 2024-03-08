package com.shop.core.persistence.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "clients")
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "born_date")
    private Date bornDate;
    private String password;
    private String email;
    private String position;
}
