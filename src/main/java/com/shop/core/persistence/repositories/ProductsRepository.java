package com.shop.core.persistence.repositories;

import com.shop.core.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {

}
