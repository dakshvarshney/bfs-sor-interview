package com.paypal.bfs.test.employeeserv.mappers;

import org.springframework.stereotype.Component;

@Component
public interface CoreMapper<T extends Object, K extends Object> {

    K mapToDataEntity(T input);

    T mapEntityToResponse(K data);
}

