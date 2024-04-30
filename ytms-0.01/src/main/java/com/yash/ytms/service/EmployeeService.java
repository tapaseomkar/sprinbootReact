package com.yash.ytms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.ytms.entity.Employee;

public interface EmployeeService 
{
	Employee createUser(Employee emp);
	List<Employee> getAllEmployee();
	List<Employee> getEmployeesByCompetencyId(Integer competencyId);
	long countEmployees();

}
