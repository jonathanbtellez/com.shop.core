package com.shop.core.services;

import com.shop.core.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsServiceImpl implements IProductService{
    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Product 1", 10.0, 10),
            new Product(2, "Product 2", 20.0, 20),
            new Product(3, "Product 3", 30.0, 30)
    ));

    public List<Product> getProducts() {
        return products;
    }

}
