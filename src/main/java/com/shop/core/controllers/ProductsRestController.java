package com.shop.core.controllers;

import com.shop.core.services.IProductService;
import com.shop.core.services.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    @Autowired
    //@Qualifier("MEMORY")
    private IProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        return  ResponseEntity.ok(productsService.getProducts());
    }
    //page 150
}
