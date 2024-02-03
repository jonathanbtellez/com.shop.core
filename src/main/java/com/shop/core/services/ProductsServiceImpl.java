package com.shop.core.services;

import com.shop.core.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy
//Handle logs lombok
@Slf4j
@Service("MEMORY")
@ConditionalOnProperty(
        value="products.strategy",
        havingValue = "IN_MEMORY"
)
public class ProductsServiceImpl implements IProductService{
    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1L, "Product 1", 10.0, 10),
            new Product(2L, "Product 2", 20.0, 20),
            new Product(3L, "Product 3", 30.0, 30)
    ));

    public ProductsServiceImpl() {
        //we can use log thanks to Slf4j annotation
        log.info("Se esta construyendo un objeto de la clase ProductServiceImpl");
    }

    public List<Product> getProducts() {
        return products;
    }

}
