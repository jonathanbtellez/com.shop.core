package com.shop.core.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.core.models.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary
@Service("JSON")
@ConditionalOnProperty(
        value="products.strategy",
        havingValue = "IN_JSON"
)
public class ProductServiceJSONImpl implements IProductService {
    @Override
    public List<Product> getProducts() {
        List<Product> products;
        try {
            products = new ObjectMapper().readValue(this.getClass().getResourceAsStream("/products.json"), new TypeReference<List<Product>>(){});

            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> getByPriceLessThan(Double price) {
        return null;
    }

    @Override
    public List<Product> getByNameLike(String name) {
        return null;
    }

    @Override
    public List<Product> getByPriceGreaterThanAndStockLessThan(Double price, Integer stock) {
        return null;
    }
}
