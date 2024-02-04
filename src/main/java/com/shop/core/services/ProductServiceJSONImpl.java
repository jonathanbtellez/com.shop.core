package com.shop.core.services;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.core.models.Product;
import com.shop.core.persistence.entities.ProductEntity;
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
    public ProductEntity saveProduct(Product product) {
        return null;
    }
}
