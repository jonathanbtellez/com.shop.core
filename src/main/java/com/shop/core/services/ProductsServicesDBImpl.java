package com.shop.core.services;

import com.shop.core.models.Product;
import com.shop.core.persistence.entities.ProductEntity;
import com.shop.core.persistence.repositories.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Lazy
//Handle logs lombok
@Slf4j
@Service("DB")
@ConditionalOnProperty(
        value="products.strategy",
        havingValue = "IN_DB"
)
public class ProductsServicesDBImpl implements IProductService{

    @Autowired
    private ProductsRepository productsRepository;

    public ProductsServicesDBImpl() {
        //we can use log thanks to Slf4j annotation
        log.info("Se esta construyendo un objeto de la clase ProductServicesDBImpl");
    }

    @Override
    public List<Product> getProducts() {
/*        List<ProductEntity> productsEntity = productsRepository.findAll();
        List<Product> products = new ArrayList<>();


        for(ProductEntity productEntity : productsEntity){
            Product product = new Product();
            product.setId(productEntity.getId());
            product.setName(productEntity.getName());
            product.setPrice(productEntity.getPrice());
            product.setStock(productEntity.getStock());
            products.add(product);
        }*/

        return productsRepository.findAll()
            .stream()
            .map(productEntity -> {
                Product product = new Product();
                product.setId(productEntity.getId());
                product.setName(productEntity.getName());
                product.setPrice(productEntity.getPrice());
                product.setStock(productEntity.getStock());
                return product;
            }).collect(Collectors.toList());
    }

    @Override
    public ProductEntity saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setStock(product.getStock());

        return productsRepository.save(productEntity);
    }
}
