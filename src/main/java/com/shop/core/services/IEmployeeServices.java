package com.shop.core.services;

import com.shop.core.models.Employee;
import com.shop.core.models.Product;
import com.shop.core.persistence.entities.EmployeeEntity;

import java.util.List;

public interface IEmployeeServices {
    public List<Employee> getEmployees();
    public Employee getById(Long id);
    List<Employee> findByNameLike(String name);
    List<Employee> findByEmailLike(String email);
    List<Employee> findByPositionLike(String position);
    public Employee saveProduct(Employee employee);
    public Employee update(Employee employee);
    public void delete(Long id);
}
