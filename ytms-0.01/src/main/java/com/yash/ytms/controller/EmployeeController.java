package com.yash.ytms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.entity.Employee;
import com.yash.ytms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController 
{
	@Autowired
	private EmployeeService empservice;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp)
	{
		Employee empc=this.empservice.createUser(emp);
		return new ResponseEntity<Employee>(empc,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>>getAllEmployee()
	{
		List<Employee>employee=empservice.getAllEmployee();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/bycompetencyid/{competencyId}")
	public ResponseEntity<List<Employee>>getEmployeeByCompetencyId(@PathVariable Integer competencyId)
	{
		List<Employee>employee=empservice.getEmployeesByCompetencyId(competencyId);
		return new ResponseEntity<>(employee,HttpStatus.OK);		
	}
	
	@GetMapping("/count")
    public long countCompetencies() {
        return empservice.countEmployees();
    }


	

}
