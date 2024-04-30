package com.yash.ytms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.yash.ytms.dao.CompetencyDao;
import com.yash.ytms.entity.Competency;
import com.yash.ytms.exception.DuplicateCompetencyException;
import com.yash.ytms.exception.ResourceNotFoundException;
import com.yash.ytms.service.CompetancyService;

@Service
public class CompetencyServiceImp implements CompetancyService
{
	@Autowired
	private CompetencyDao competencyDao;
	
	

	@Override
	public Competency createCompetency(Competency competency)
	{
//		if(competencyDao.existsById(competency.getId()))
//		{
//			throw new DuplicateCompetencyException("Competency with Identifier already exists");
//		}
		return this.competencyDao.save(competency);	
	}
	

	
	@Override
	public Competency updateCompetency(Competency competency, Integer competencyid) {
        Competency existingCompetency = this.competencyDao.findById(competencyid)
                .orElseThrow(() -> new ResourceNotFoundException("Competency", "id", competencyid));
        
        existingCompetency.setName(competency.getName());
        existingCompetency.setManagerName(competency.getManagerName());
        // Update other fields as needed
        return this.competencyDao.save(existingCompetency);
	}
	

	@Override
	public List<Competency> getAllCompetency() {
		List<Competency>competency=this.competencyDao.findAll();
		return competency;
	}

	

	@Override
	public void deleteCompetency(Integer competencyid) {
		Competency comp=this.competencyDao.findById(competencyid)
				.orElseThrow(()->new ResourceNotFoundException("competency", "id", competencyid));
		this.competencyDao.delete(comp);
	}

	@Override
	public Competency getCompetency(Integer competencyid) {
		Competency comp=this.competencyDao.findById(competencyid)
				.orElseThrow(()-> new ResourceNotFoundException("Competency","id",competencyid));
		return comp;
	}

	@Override
	public long countCompetencies() {
		
		return this.competencyDao.count();
	}




	
}
