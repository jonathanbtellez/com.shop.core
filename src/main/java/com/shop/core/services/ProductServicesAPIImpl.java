package com.shop.core.services;

import com.shop.core.models.Product;
import com.shop.core.persistence.entities.ProductEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@ConditionalOnProperty(
        value="products.strategy",
        havingValue = "IN_API"
)
public class ProductServicesAPIImpl implements IProductService{
    @Override
    public List<Product> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Product>> response = restTemplate
                .exchange("http://localhost:8080/shop/api/v1/products/fake-products",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Product>>() {}
                );

        List<Product> products = response.getBody();

        return products;
    }

    @Override
    public ProductEntity saveProduct(Product product) {
        return null;
    }
}