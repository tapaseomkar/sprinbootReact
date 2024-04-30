package com.yash.ytms.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="competencymanager")
@NoArgsConstructor
@Getter
@Setter
public class CompetencyManager 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer competencyid;
	
	@NotNull
	private String username;
	
	@NotNull
	@Email
    private String email;
	
	@NotNull
    private String password; // Store hashed passwords for security


	
}
