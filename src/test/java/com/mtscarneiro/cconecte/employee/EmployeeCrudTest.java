package com.mtscarneiro.cconecte.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeCrudTest {
    @Mock
    private EmployeeServiceInterface employeeService;
    private Faker faker;

    @Test
    void mustFindAnEmployeeByItsId() {


        Mockito.when(employeeService.findById())
                .thenReturn();

         employeeFromTheDatabase;
        Assertions.assertEquals(employeeFromTheDatabase, createdEmployee);
    }
}
