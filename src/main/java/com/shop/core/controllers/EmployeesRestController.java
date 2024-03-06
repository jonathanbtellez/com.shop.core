package com.shop.core.controllers;

import com.shop.core.configurations.ConfigurationParameters;
import com.shop.core.models.Employee;
import com.shop.core.models.Product;
import com.shop.core.persistence.entities.EmployeeEntity;
import com.shop.core.services.IEmployeeServices;
import com.shop.core.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesRestController {

    @Autowired
    @Lazy
    //@Qualifier("MEMORY")
    private IEmployeeServices employeeService;

    @Autowired
    private ConfigurationParameters configurationParameters;

    @GetMapping
    public ResponseEntity<?> getEmployees(){
        System.out.println("params: "+ configurationParameters.toString());

        return  ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<?> getByNameLike(@PathVariable String name){
        return ResponseEntity.ok(employeeService.findByNameLike(name));
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email){
        return ResponseEntity.ok(employeeService.findByEmailLike(email));
    }

    @GetMapping("/by-position/{position}")
    public ResponseEntity<?> getByPosition(@PathVariable String position){
        return ResponseEntity.ok(employeeService.findByPositionLike(position));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employee employee){
        Employee employeeSaved = employeeService.save(employee);
        URI location =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(employeeSaved.getId())
                        .toUri();

        return ResponseEntity.created(location).body(employeeSaved);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Employee employee){
        System.out.println(employee);
        return ResponseEntity.ok(employeeService.update(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
