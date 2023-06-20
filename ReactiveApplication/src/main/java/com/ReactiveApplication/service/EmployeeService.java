package com.ReactiveApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReactiveApplication.dto.EmployeeDto;
import com.ReactiveApplication.repository.EmployeeRepo;
import com.ReactiveApplication.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	
	public Mono<EmployeeDto> getEmployee(int id)
	{
		return employeeRepo.findById(id).map(AppUtils::entityToDto);
	}
	
	
	public Mono<EmployeeDto> saveEmployee(Mono<EmployeeDto> employeeDtoMono)
	{
		return employeeDtoMono.map(AppUtils::dtoToEntity)
				              .flatMap(employeeRepo::save)
				              .map(AppUtils::entityToDto);
	}


	public Flux<EmployeeDto> getEmployees() {
		
		return employeeRepo.findAll()
				           .map(AppUtils::entityToDto);
	}


	public Mono<EmployeeDto> updateEmployee(Mono<EmployeeDto> employeeDto, int id) {
		
        return employeeRepo.findById(id)
                .flatMap(p->employeeDto.map(AppUtils::dtoToEntity)
                .doOnNext(e->e.setId(id)))
                .flatMap(employeeRepo::save)
                .map(AppUtils::entityToDto);				          
	}
	
	
	public Mono<Void> deleteEmployee(int id)
	{
		return employeeRepo.deleteById(id);
	}
	
}
