 package com.yash.ytms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.entity.Competency;
import com.yash.ytms.service.CompetancyService;
import com.yash.ytms.utilities.ApiResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class CompetencyController 
{
	@Autowired
	private CompetancyService competancyService;
	
	//SAVE
	@PostMapping("/add")
	public ResponseEntity<Competency> createCompetency(@RequestBody Competency competency)
	{
		Competency userCompetency=this.competancyService.createCompetency(competency);
		return new ResponseEntity<Competency>(userCompetency,HttpStatus.CREATED);
		
	}

	
	//GETALL
	@GetMapping("/")
	public ResponseEntity<List<Competency>> getallCompetency()
	{
		List<Competency> complist=this.competancyService.getAllCompetency();
		return ResponseEntity.ok(complist);
	}	
	
	
	//UPDATE
	@PutMapping("/{comid}")
	public ResponseEntity<Competency> updateCompetency(@RequestBody Competency competency, @PathVariable("comid") Integer comid)
	{
		Competency updatecompetency=this.competancyService.updateCompetency(competency, comid);
		
		return new ResponseEntity<Competency>(updatecompetency,HttpStatus.OK);
		
	}

	
	//GETBYID
	@GetMapping("/{userid}")
	public ResponseEntity<Competency> getCompetency(@PathVariable("userid") Integer cid)
	{
	    Competency user = this.competancyService.getCompetency(cid);
	    return ResponseEntity.ok(user);
	}
	
	//DELETE
	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponse> deleteCompetency(@PathVariable("userid") Integer cid)
	{
		 this.competancyService.deleteCompetency(cid);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
		
	}
	
	@GetMapping("/count")
    public long countCompetencies() {
        return competancyService.countCompetencies();
    }

}
