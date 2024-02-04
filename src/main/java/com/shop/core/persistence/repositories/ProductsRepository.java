package com.shop.core.persistence.repositories;

import com.shop.core.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByPriceLessThan(Double price);
    List<ProductEntity> findByNameLike(String name);
    List<ProductEntity> findByPriceGreaterThanAndStockLessThan(Double price, Integer stock);
}
