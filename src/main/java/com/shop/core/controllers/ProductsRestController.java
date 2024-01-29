package com.shop.core.controllers;

import com.shop.core.services.IProductService;
import com.shop.core.services.ProductsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    private IProductService productsService = new ProductsServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts(){
        return  ResponseEntity.ok(productsService.getProducts());
    }

}
