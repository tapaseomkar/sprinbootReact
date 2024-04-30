package com.yash.ytms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.dao.EmployeeDao;
import com.yash.ytms.entity.Employee;
import com.yash.ytms.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService
{
	
	@Autowired
	private EmployeeDao empdao;

	@Override
	public Employee createUser(Employee emp) {
		return this.empdao.save(emp);
	}
	
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee>employee=this.empdao.findAll();
		return employee;
	}


	@Override
	public List<Employee> getEmployeesByCompetencyId(Integer competencyId) {
		
		return empdao.getEmployeesByCompetencyId(competencyId);
	}


	@Override
	public long countEmployees() {
		
		return this.empdao.count();
	}

	

}
