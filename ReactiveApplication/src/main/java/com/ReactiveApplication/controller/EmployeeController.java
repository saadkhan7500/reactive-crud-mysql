package com.ReactiveApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ReactiveApplication.dto.EmployeeDto;
import com.ReactiveApplication.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/getEmployee/{id}")
	public Mono<EmployeeDto> getEmployee(@PathVariable int id)
	{
		return employeeService.getEmployee(id);
	}
	
	
	@GetMapping("/getEmployees")
	public Flux<EmployeeDto> getEmployees()
	{
		return employeeService.getEmployees();
	}
	
	@PostMapping("/save")
	public Mono<EmployeeDto> saveEmployee(@RequestBody Mono<EmployeeDto> employeeDto)
	{
		System.out.println("coming object..."+employeeDto);
		return employeeService.saveEmployee(employeeDto);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Mono<EmployeeDto> updateEmployee(@RequestBody Mono<EmployeeDto> employeeDto , @PathVariable int id)
	{
		return employeeService.updateEmployee(employeeDto,id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public Mono<EmployeeDto> deleteEmployee(@PathVariable int id)
	{
		return employeeService.deleteEmployee(id);
	}
}
