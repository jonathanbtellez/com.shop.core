package com.shop.core.services;

import com.shop.core.models.Product;
import com.shop.core.persistence.entities.ProductEntity;
import com.shop.core.persistence.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("DB")
@ConditionalOnProperty(
        value = "products.strategy",
        havingValue = "IN_DB")
public class ProductServicesDBImpl implements IProductService{

    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public List<Product> getProducts() {
        List<ProductEntity> productsEntity = productsRepository.findAll();
        List<Product> products = new ArrayList<>();


        for(ProductEntity productEntity : productsEntity){
            Product product = new Product();
            product.setId(productEntity.getId());
            product.setName(productEntity.getName());
            product.setPrice(productEntity.getPrice());
            product.setStock(productEntity.getStock());
            products.add(product);
        }
        return products;
    }
}
