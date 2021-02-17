package com.paypal.bfs.test.employeeserv.mappers;

import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import org.springframework.stereotype.Component;


@Component
public class EmployeeMapper implements CoreMapper<Employee, EmployeeEntity>{

    @Override
    public EmployeeEntity mapToDataEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setFirst_name(employee.getFirstName());
        employeeEntity.setLast_name(employee.getLastName());
        employeeEntity.setDob(employee.getDob());
        Address address = employee.getAddress();
        employeeEntity.setLine1(address.getAddressLine1());
        employeeEntity.setLine2(address.getAddressLine2());
        employeeEntity.setCity(address.getCity());
        employeeEntity.setState(address.getState());
        employeeEntity.setCountry(address.getCountry());
        employeeEntity.setZipcode(address.getZipCode());
        return employeeEntity;
    }

    @Override
    public Employee mapEntityToResponse(EmployeeEntity entity) {
        Employee employee = new Employee();
        employee.setId(entity.getId());
        employee.setDob(entity.getDob());
        employee.setFirstName(entity.getFirst_name());
        employee.setLastName(entity.getLast_name());
        Address address = new Address();
        address.setAddressLine1(entity.getLine1());
        address.setAddressLine2(entity.getLine2());
        address.setCity(entity.getCity());
        address.setState(entity.getState());
        address.setCountry(entity.getCountry());
        address.setZipCode(entity.getZipcode());
        employee.setAddress(address);
        return employee;
    }
}

