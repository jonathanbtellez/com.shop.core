package com.shop.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String username;
    private String name;
    private String lastName;
    private String email;
    private Date bornDate;
    private String password;

}
