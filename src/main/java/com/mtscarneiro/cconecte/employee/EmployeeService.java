package com.mtscarneiro.cconecte.employee;

import com.mtscarneiro.cconecte.exception.ContentNotExistentException;
import com.mtscarneiro.cconecte.exception.DatabaseViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository
                .findById(id);
        return employee.orElseThrow(() -> new ContentNotExistentException());
    }

    public Employee insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException err) {
            throw new ContentNotExistentException();
        } catch (DataIntegrityViolationException err) {
            throw new DatabaseViolationException(err.getMessage());
        }
    }

    private void updateData(Employee oldEmployee, Employee updatedEmployee) {
        oldEmployee.setName(updatedEmployee.getName());
        oldEmployee.setTitle(updatedEmployee.getTitle());
        oldEmployee.setWorkDays(updatedEmployee.getWorkDays());
        oldEmployee.setDaysOff(updatedEmployee.getDaysOff());
    }

    public Employee update(Long id, Employee employee) {
        try {
            Employee updatedEmployee = employeeRepository.getById(id);
            updateData(updatedEmployee, employee);
            return employeeRepository.save(updatedEmployee);
        } catch (EntityNotFoundException err) {
            throw new ContentNotExistentException();
        }
    }
}
