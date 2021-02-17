package com.paypal.bfs.test.employeeserv.validators;

import com.paypal.bfs.test.employeeserv.exceptions.ValidationException;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.stereotype.Component;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.model.Address;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class EmployeeValidator {

    private final static String DATE_FORMAT = "dd-MM-yyyy";
    private final static String PIN_CODE_REGEX = "()|[0-9]{6}";

    private void validateDate(String date) throws ValidationException {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        try {
            df.setLenient(false);
            df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ValidationException("Date " + date + " is not valid according to " +
                    ((SimpleDateFormat) df).toPattern() + " pattern.");
        }
    }

    private void validateZipcode(int zipCode) throws ValidationException {
        String zipCodeString = String.valueOf(zipCode);
        boolean isPinCodeValid = Pattern.compile(PIN_CODE_REGEX).matcher(zipCodeString).matches();
        if(!isPinCodeValid){
            throw new ValidationException("Invalid zipCode");
        }
    }

    private void validateForNullChecks(Employee employee) throws ValidationException{

        Optional.ofNullable(employee.getFirstName()).orElseThrow(() -> new ValidationException("first_name field not present"));
        Optional.ofNullable(employee.getLastName()).orElseThrow(() -> new ValidationException("last_name field not present"));
        Optional.ofNullable(employee.getDob()).orElseThrow(() -> new ValidationException("dob field not present"));
        Optional.ofNullable(employee.getAddress()).orElseThrow(() -> new ValidationException("address field not present"));

        Address addressField = employee.getAddress();

        Optional.ofNullable(addressField.getAddressLine1()).orElseThrow(() -> new ValidationException("address line1 field not present"));
        Optional.ofNullable(addressField.getCity()).orElseThrow(() -> new ValidationException("city field not present"));
        Optional.ofNullable(addressField.getState()).orElseThrow(() -> new ValidationException("state field not present"));
        Optional.ofNullable(addressField.getCountry()).orElseThrow(() -> new ValidationException("country line1 field not present"));
        Optional.ofNullable(addressField.getZipCode()).orElseThrow(() -> new ValidationException("zipcode line1 field not present"));
    }

    private void validateStringLength(Employee employee) throws ValidationException{
        String firstName = employee.getFirstName();
        if(firstName.length() > 100) throw new ValidationException("length of key `first name` should be less than 100");

        String lastName = employee.getLastName();
        if(lastName.length() > 100) throw new ValidationException("length of key `last name` should be less than than 100");

        String  addressLine1= employee.getAddress().getAddressLine1();
        if(addressLine1.length() > 100) throw new ValidationException("length of key `addressLine1` should be less than than 100");

        String addressLine2 = employee.getAddress().getAddressLine1();
        if(addressLine2.length() > 100) throw new ValidationException("length of key `addressLine2` should be less than than 100");

        String city = employee.getAddress().getCity();
        if(city.length() > 30) throw new ValidationException("length of key `city` should be less than than 30");

        String country = employee.getAddress().getCountry();
        if(country.length() > 30) throw new ValidationException("length of key `country` should be less than than 30");

        String state = employee.getAddress().getState();
        if(state.length() > 30) throw new ValidationException("length of key `state` should be less than than 30");
    }

    public void validateEmployee(Employee employee) throws ValidationException{
        validateForNullChecks(employee);
        validateStringLength(employee);
        validateDate(employee.getDob());
        validateZipcode(employee.getAddress().getZipCode());
    }
}
