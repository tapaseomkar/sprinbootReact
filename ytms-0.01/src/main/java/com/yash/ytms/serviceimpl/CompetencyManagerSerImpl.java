package com.yash.ytms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yash.ytms.dao.CompetencyManagerRepository;
import com.yash.ytms.entity.Competency;
import com.yash.ytms.entity.CompetencyManager;
import com.yash.ytms.service.CompetancyService;
import com.yash.ytms.service.CompetencyManagerService;
import com.yash.ytms.utilities.LoginMessage;

@Service
public class CompetencyManagerSerImpl implements CompetencyManagerService
{

	@Autowired
	public CompetencyManagerRepository compmanagerrepo;
	
	
	@Autowired
	public PasswordEncoder passwordEncoder;

	@Override
	public String addCompetencyManager(CompetencyManager cmpmanager) {
		cmpmanager.setPassword(passwordEncoder.encode(cmpmanager.getPassword()));
		
		CompetencyManager savedCompManager=compmanagerrepo.save(cmpmanager);
	//	 logger.info("Received JSON data: " + savedCompManager);
		return savedCompManager.getUsername();
	}

	@Override
	public LoginMessage loginCompetencyManager(String email, String password) {
		Optional<CompetencyManager>compOptional=compmanagerrepo.findByEmail(email);
			
		if(compOptional.isPresent())
		{
			CompetencyManager compmanage=compOptional.get();
			if(passwordEncoder.matches(password,compmanage.getPassword()))
			{
				return new LoginMessage("Login Sucess",true);
			}else
			{
				return new LoginMessage("password Incorrect",false);
			}		
		}else
		{
			return new LoginMessage("Email not found",false);
		}
		
	}
	
	

}
