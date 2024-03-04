package com.shop.core.persistence.repositories;

import com.shop.core.persistence.entities.EmployeeEntity;
import com.shop.core.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByNameLike(String name);
    List<EmployeeEntity> findByEmailLike(String email);
    List<EmployeeEntity> findByPositionLike(String position);
}
