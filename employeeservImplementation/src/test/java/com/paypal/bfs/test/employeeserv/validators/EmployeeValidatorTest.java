package com.paypal.bfs.test.employeeserv.validators;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@Import(EmployeeValidator.class)
public class EmployeeValidatorTest {

    @Autowired
    private EmployeeValidator validator;


    private Employee employee;

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
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidateEmployee_Success() throws ValidationException {
       validator.validateEmployee(employee);
    }

    @Test(expected = ValidationException.class)
    public void testValidateEmployee_Failure_String_Length() throws ValidationException {
        employee.getAddress().setCity("123456789123456789123456789123456789123456789123456789");
        validator.validateEmployee(employee);
    }

    @Test(expected = ValidationException.class)
    public void testValidateEmployee_Failure_Null_Check() throws ValidationException {
        employee.getAddress().setCity(null);
        validator.validateEmployee(employee);
    }

    @Test(expected = ValidationException.class)
    public void testValidateEmployee_Failure_Invalid_Date() throws ValidationException {
        employee.setDob("12/10/1997");
        validator.validateEmployee(employee);
    }

    @Test(expected = ValidationException.class)
    public void testValidateEmployee_Failure_Invalid_Zipcode() throws ValidationException {
        employee.getAddress().setZipCode(123324324);
        validator.validateEmployee(employee);
    }

}
