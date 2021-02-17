package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */

    @PostMapping(value = "/v1/employees", consumes = "application/json")
    ResponseEntity createEmployee(@RequestBody Employee employee);

    @GetMapping(value = "/v1/employees/{id}")
    ResponseEntity getEmployeeById(@PathVariable int id);
}
