package com.cg.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Employee;
import com.cg.employeeexception.EmployeeException;
import com.cg.employeeservice.IEmpService;


@RestController
@Transactional
public class EmployeeController {
	@Autowired
	private IEmpService service;
	
	@RequestMapping(value="/createEmployee",method=RequestMethod.POST)
	public Employee createAccount(Employee employee) throws EmployeeException {
		try {
			employee=service.createAccount(employee);
		} catch (EmployeeException e) {
			throw new EmployeeException(e.getMessage());
		}
		return employee;
		
		
	}
	
	@RequestMapping(value="/updateEmployee", method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) throws EmployeeException {
		
		
		try {
			emp=service.updateAccount(emp);
		
			
		} catch (EmployeeException e) {
			
			throw new EmployeeException(e.getMessage());
		}
		return emp;
		
	}
	
	@RequestMapping(value="/deleteEmployee", method=RequestMethod.DELETE)
	public boolean deleteEmployee(Employee emp) throws EmployeeException {
		boolean b=false;
		try {
			b=service.deleteAccount(emp.geteId());
			return b;
		} catch (EmployeeException e) {
			throw new EmployeeException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/findEmployeeById", method=RequestMethod.GET)
	public Employee findEmployee(Employee emp) throws EmployeeException {
		
		try {
			emp=service.findEmployeeById(emp.geteId());
		} catch (EmployeeException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return emp;
	}
	
	
	@RequestMapping(value="/findAllEmployee", method=RequestMethod.GET)
	public List<Employee> findAllEmployee() throws EmployeeException {
		List<Employee> emp = null;
		try {
			emp=service.viewAllEmployees();
			return emp;
		} catch (EmployeeException e) {
			throw new EmployeeException(e.getMessage());
		}
	}
	
	
	
	
	
	
	

}
