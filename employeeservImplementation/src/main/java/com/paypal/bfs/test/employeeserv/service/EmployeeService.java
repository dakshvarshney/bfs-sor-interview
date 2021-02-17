package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exceptions.ValidationException;
import com.paypal.bfs.test.employeeserv.exceptions.RecordNotFoundException;
import com.paypal.bfs.test.employeeserv.mappers.EmployeeMapper;
import  com.paypal.bfs.test.employeeserv.validators.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService implements CoreService<Employee, EmployeeEntity>{
    @Autowired
    private EmployeeValidator employeeValidator;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeEntity save(Employee employee) throws ValidationException {
        employeeValidator.validateEmployee(employee);
        EmployeeEntity employeeEntity =  employeeMapper.mapToDataEntity(employee);
        return employeeDao.save(employeeEntity);
    }

    @Override
    public Employee getRecordById(int id) throws RecordNotFoundException {
        Optional<EmployeeEntity> entity = employeeDao.findById(id);
        if(!entity.isPresent()) throw new RecordNotFoundException("No employee record exist with the given id.");
        return employeeMapper.mapEntityToResponse(entity.get());
    }

}
