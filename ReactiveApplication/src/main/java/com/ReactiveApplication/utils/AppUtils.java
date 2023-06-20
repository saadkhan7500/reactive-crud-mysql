package com.ReactiveApplication.utils;

import org.springframework.beans.BeanUtils;

import com.ReactiveApplication.dto.EmployeeDto;
import com.ReactiveApplication.entity.Employee;

public class AppUtils {

	public static EmployeeDto entityToDto(Employee employee)
	{
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto; 
	}
	
	public static  Employee dtoToEntity(EmployeeDto employeeDto)
	{
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		return employee;
	}
}
