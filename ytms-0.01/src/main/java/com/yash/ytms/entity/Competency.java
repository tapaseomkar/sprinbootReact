package com.yash.ytms.entity;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="competency")
@NoArgsConstructor
@Getter
@Setter
public class Competency 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String managerName;
	
	@OneToMany(mappedBy = "competency", cascade=CascadeType.ALL)
	private List<Employee> emp=new ArrayList<Employee>();
	

}
