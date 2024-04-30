package com.yash.ytms.service;

import com.yash.ytms.entity.CompetencyManager;
import com.yash.ytms.utilities.LoginMessage;

public interface CompetencyManagerService 
{
	String addCompetencyManager(CompetencyManager cmpmanager);
	LoginMessage loginCompetencyManager(String email, String password);

}
