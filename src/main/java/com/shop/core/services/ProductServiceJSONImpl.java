package com.shop.core.services;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.core.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary
@Service
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
}
