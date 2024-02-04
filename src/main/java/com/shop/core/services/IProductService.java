package com.shop.core.services;

import com.shop.core.models.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getProducts();
    public Product getById(Long id);
    public List<Product> getByPriceLessThan(Double price);
    public List<Product> getByNameLike(String name);
    public List<Product> getByPriceGreaterThanAndStockLessThan(Double price, Integer stock);
    public Product saveProduct(Product product);
    public Product update(Product product);
    public void delete(Long id);

}
