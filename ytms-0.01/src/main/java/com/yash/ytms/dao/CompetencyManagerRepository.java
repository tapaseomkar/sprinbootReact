package com.yash.ytms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.entity.CompetencyManager;

@Repository
public interface CompetencyManagerRepository extends JpaRepository<CompetencyManager, Integer>
{
	Optional<CompetencyManager> findByEmail(String email);
	
	Optional<CompetencyManager> findByEmailAndPassword(String email,String password);
	
	

}
