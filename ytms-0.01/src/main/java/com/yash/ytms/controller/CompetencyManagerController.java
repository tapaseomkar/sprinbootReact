package com.yash.ytms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.entity.CompetencyManager;
import com.yash.ytms.service.CompetencyManagerService;
import com.yash.ytms.utilities.LoginMessage;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "http://localhost:3000")
public class CompetencyManagerController
{
	@Autowired
	private CompetencyManagerService compmanaService;
	
	@PostMapping(path="/save")
	public String saveCompManager(@RequestBody CompetencyManager compmanage)
	{
		return compmanaService.addCompetencyManager(compmanage);
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<?>loginCompManager(@RequestParam String email, @RequestParam String password)
//	{
//
//		LoginMessage loginmessage=compmanaService.loginCompetencyManager(email, password);
//		return ResponseEntity.ok(loginmessage);
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginCompManager(@RequestBody Map<String, String> loginRequest) {
	    String email = loginRequest.get("email");
	    String password = loginRequest.get("password");
	    LoginMessage loginMessage = compmanaService.loginCompetencyManager(email, password);
	    return ResponseEntity.ok(loginMessage);
	}
}
