package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exceptions.RecordNotFoundException;
import com.paypal.bfs.test.employeeserv.exceptions.ValidationException;
import com.paypal.bfs.test.employeeserv.mappers.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.validators.EmployeeValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@Import(EmployeeService.class)
public class EmployeeServiceTest{

    @Autowired
    private EmployeeService service;

    @MockBean
    private EmployeeValidator employeeValidator;

    @MockBean
    private EmployeeDao employeeDao;

    @MockBean
    private EmployeeMapper employeeMapper;

    private Employee employee;

    private EmployeeEntity employeeEntity;

    @Before
    public void setUp(){
        employee = new Employee();
        employee.setFirstName("Ram");
        employee.setLastName("Verma");
        employee.setDob("12-10-19977");
        employee.setId(1);
        Address address = new Address();
        address.setAddressLine1("123334");
        address.setAddressLine2("sdfdsf");
        address.setCity("delhi");
        address.setCountry("India");
        address.setState("Delhi");
        address.setZipCode(110092);
        employee.setAddress(address);

        employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1);
        employeeEntity.setFirst_name("Ram");
        employeeEntity.setLast_name("Verma");
        employeeEntity.setLine1("Address Line 1");
        employeeEntity.setLine2("Address Line 2");
        employeeEntity.setState("Delhi");
        employeeEntity.setZipcode(110092);
        employeeEntity.setCity("Delhi");
        employeeEntity.setCountry("India");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEmployeeGetById_Success() throws RecordNotFoundException {
        EmployeeEntity dummy = new EmployeeEntity();
        dummy.setDob("12-10-1997");
        dummy.setId(1);

        when(employeeDao.findById(1)).thenReturn(java.util.Optional.of(dummy));
        Employee employee = new Employee();

        employee.setDob("12-10-1997");
        employee.setId(1);
        when(employeeMapper.mapEntityToResponse(dummy)).thenReturn(employee);

        Assert.assertEquals(employee.getId(), service.getRecordById(1).getId());
    }

    @Test(expected = RecordNotFoundException.class)
    public void testEmployeeGetById_Failure() throws RecordNotFoundException {
        when(employeeDao.findById(2)).thenReturn(Optional.empty());
        service.getRecordById(2);
    }

    @Test
    public void testSaveEmployee_Success() throws ValidationException {
        service.save(employee);
    }

    @Test(expected = ValidationException.class)
    public void testSaveEmployee_Failure() throws ValidationException{
        doThrow(new ValidationException("Validation Exception")).when(employeeValidator).validateEmployee(employee);
        employee.setAddress(null);
        service.save(employee);
    }

}