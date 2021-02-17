package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.exceptions.ValidationException;
import com.paypal.bfs.test.employeeserv.exceptions.RecordNotFoundException;

public interface CoreService <T extends Object, K extends Object>{

    K save(T entityToSave) throws ValidationException;
    T getRecordById(int id) throws RecordNotFoundException;
}
