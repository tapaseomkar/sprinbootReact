package com.yash.ytms.service;

import java.util.List;
import com.yash.ytms.entity.Competency;

public interface CompetancyService 
{
	Competency createCompetency(Competency competency);
	List<Competency> getAllCompetency();
	Competency updateCompetency(Competency competency, Integer competencyid);
	void deleteCompetency(Integer competencyid);
	Competency getCompetency(Integer competencyid);
	long countCompetencies();
	
	
	
	

}
