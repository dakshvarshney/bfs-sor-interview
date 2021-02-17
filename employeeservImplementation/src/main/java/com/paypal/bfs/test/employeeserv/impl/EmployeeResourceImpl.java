package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exceptions.ValidationException;
import com.paypal.bfs.test.employeeserv.exceptions.RecordNotFoundException;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity createEmployee(Employee employee) {
        try{
            EmployeeEntity employeeEntity = employeeService.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body(employeeEntity);
        }
        catch (ValidationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity getEmployeeById(int id) {
        try {
            Employee employee = employeeService.getRecordById(id);
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }
        catch (RecordNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
