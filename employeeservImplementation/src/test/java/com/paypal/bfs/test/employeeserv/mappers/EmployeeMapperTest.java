package com.paypal.bfs.test.employeeserv.mappers;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@Import(EmployeeMapper.class)
public class EmployeeMapperTest {

    private Employee employee;

    private EmployeeEntity employeeEntity;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Before
    public void setUp(){
        employee = new Employee();
        employee.setFirstName("Ram");
        employee.setLastName("Verma");
        employee.setDob("12-10-19977");
        employee.setId(1);
        Address address = new Address();
        address.setAddressLine1("Address Line 1");
        address.setAddressLine2("Address Line 2");
        address.setCity("Delhi");
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
    public void testMapToDataEntity(){
        EmployeeEntity entity = employeeMapper.mapToDataEntity(employee);
        Assert.assertEquals(entity.getId(), 1);
    }

    @Test
    public void testMapEntityToResponse(){
        Employee employee1 = employeeMapper.mapEntityToResponse(employeeEntity);
        Assert.assertEquals((long)employee1.getId(), 1);
    }

}
