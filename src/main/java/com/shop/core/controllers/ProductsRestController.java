package com.shop.core.controllers;

import com.shop.core.configurations.ConfigurationParameters;
import com.shop.core.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    @Autowired
    @Lazy
    //@Qualifier("MEMORY")
    private IProductService productsService;

    @Autowired
    private ConfigurationParameters configurationParameters;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        System.out.println("params: "+ configurationParameters.toString());

        return  ResponseEntity.ok(productsService.getProducts());
    }
    //page 150
}
