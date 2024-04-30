package com.yash.ytms.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException
{
	String competencyName;
	String competencyId;
	long value;
	
	public ResourceNotFoundException(String competencyName, String competencyId, long value) {
		super (String.format("%s omakr not found with this %s: %s",competencyName,competencyId,value));
		this.competencyName = competencyName;
		this.competencyId = competencyId;
		this.value = value;
	}
	
}
