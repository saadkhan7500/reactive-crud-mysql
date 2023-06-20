package com.ReactiveApplication.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.ReactiveApplication.entity.Employee;

@Repository
public interface EmployeeRepo extends R2dbcRepository<Employee , Integer>{

}
