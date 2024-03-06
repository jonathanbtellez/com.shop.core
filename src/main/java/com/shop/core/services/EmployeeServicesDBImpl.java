package com.shop.core.services;

import com.shop.core.exceptions.ResourceNotFoundException;
import com.shop.core.models.Employee;
import com.shop.core.persistence.entities.EmployeeEntity;
import com.shop.core.persistence.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Lazy
//Handle logs lombok
@Slf4j
@Service("employee_DB")
@ConditionalOnProperty(
        value="employee.strategy",
        havingValue = "IN_DB"
)
public class EmployeeServicesDBImpl implements IEmployeeServices{

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServicesDBImpl() {
        //we can use log thanks to Slf4j annotation
        log.info("Se esta construyendo un objeto de la clase EmployeeServicesDBImpl");
    }


    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll()
                .stream().map(employeeEntity -> {
                    Employee employee = new Employee();
                    employee.setId(employeeEntity.getId());
                    employee.setName(employeeEntity.getName());
                    employee.setEmail(employeeEntity.getEmail());
                    employee.setLastName(employeeEntity.getLastName());
                    employee.setPosition(employeeEntity.getPosition());
                    return employee;
                }).collect(Collectors.toList());
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository
             .findById(id).map(employeeEntity -> {
                    Employee employee = new Employee();
                    employee.setId(employeeEntity.getId());
                    employee.setName(employeeEntity.getName());
                    employee.setEmail(employeeEntity.getEmail());
                    employee.setLastName(employeeEntity.getLastName());
                    employee.setPosition(employeeEntity.getPosition());
                    return employee;
                })
             .orElseThrow(() -> new ResourceNotFoundException("Employee "+" with id " + id + " does not exist"));
    }

    @Override
    public List<Employee> findByNameLike(String name) {
        return employeeRepository
                .findByNameLike(name).stream().map(employeeEntity -> {
                    Employee employee = new Employee();
                    employee.setId(employeeEntity.getId());
                    employee.setName(employeeEntity.getName());
                    employee.setEmail(employeeEntity.getEmail());
                    employee.setLastName(employeeEntity.getLastName());
                    employee.setPosition(employeeEntity.getPosition());
                    return employee;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByEmailLike(String email) {
        return employeeRepository
                .findByEmailLike(email).stream().map(employeeEntity -> {
                    Employee employee = new Employee();
                    employee.setId(employeeEntity.getId());
                    employee.setName(employeeEntity.getName());
                    employee.setEmail(employeeEntity.getEmail());
                    employee.setLastName(employeeEntity.getLastName());
                    employee.setPosition(employeeEntity.getPosition());
                    return employee;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByPositionLike(String position) {
        return employeeRepository
                .findByPositionLike(position).stream().map(employeeEntity -> {
                    Employee employee = new Employee();
                    employee.setId(employeeEntity.getId());
                    employee.setName(employeeEntity.getName());
                    employee.setEmail(employeeEntity.getEmail());
                    employee.setLastName(employeeEntity.getLastName());
                    employee.setPosition(employeeEntity.getPosition());
                    return employee;
                }).collect(Collectors.toList());
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employee.getName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setPosition(employee.getPosition());

        EmployeeEntity employeeEntitySaved = employeeRepository.save(employeeEntity);

        employeeEntitySaved.setId(employeeEntitySaved.getId());

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        EmployeeEntity employeeEntity =
                employeeRepository.findById(employee
                                .getId())
                        .orElseThrow(()-> new ResourceNotFoundException("Employee "+" with id " + employee.getId() + " does not exist"));

        employee.setName(employeeEntity.getName());
        employee.setEmail(employeeEntity.getEmail());
        employee.setLastName(employeeEntity.getLastName());
        employee.setPosition(employeeEntity.getPosition());

        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
