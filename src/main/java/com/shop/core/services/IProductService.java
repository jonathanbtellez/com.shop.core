package com.shop.core.services;

import com.shop.core.models.Product;
import com.shop.core.persistence.entities.ProductEntity;

import java.util.List;

public interface IProductService {
    public List<Product> getProducts();
    public ProductEntity saveProduct(Product product);
}
