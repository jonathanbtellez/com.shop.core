package com.shop.core.controllers;

import com.shop.core.configurations.ConfigurationParameters;
import com.shop.core.models.Product;
import com.shop.core.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/fake-products")
    public ResponseEntity<?> fakeProductsAPI(){
         List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1, "Product FAKE 1", 10.0, 10),
                new Product(2, "Product FAKE 2", 20.0, 20),
                new Product(3, "Product FAKE 3", 30.0, 30)
        ));

         return ResponseEntity.ok(products);
    }
}
