package com.paypal.bfs.test.employeeserv.dao;

import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface EmployeeDao extends CrudRepository<EmployeeEntity, Integer> {
}
