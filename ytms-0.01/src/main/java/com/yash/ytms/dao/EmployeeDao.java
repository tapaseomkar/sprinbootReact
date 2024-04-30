package com.yash.ytms.dao;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.ytms.entity.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>
{

	@Query("SELECT e FROM Employee e WHERE e.competency.id = :competencyId")
	List<Employee> getEmployeesByCompetencyId(Integer competencyId);

}
