package com.shop.core.persistence.repositories;

import com.shop.core.persistence.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByUserNameLike(String username);
    List<EmployeeEntity> findByNameLike(String name);
    List<EmployeeEntity> findByEmailLike(String email);
}
