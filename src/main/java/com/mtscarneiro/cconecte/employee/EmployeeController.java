package com.mtscarneiro.cconecte.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok().body(employeeList);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee employeeByID = employeeService.findById(id);
        return ResponseEntity.ok().body(employeeByID);
    }

    @PostMapping
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
        employee = employeeService.insert(employee);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("employees/{id}")
                .buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(employee);
    }
}
