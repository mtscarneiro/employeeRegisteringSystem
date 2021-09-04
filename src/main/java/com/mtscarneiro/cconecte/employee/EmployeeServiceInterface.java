package com.mtscarneiro.cconecte.employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> findAll();

    Employee findById(Long id);
}
