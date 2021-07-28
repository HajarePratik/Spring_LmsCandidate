package com.bridgelabz.lmscandidate.dto;

import com.sun.istack.NotNull;

import lombok.Data;

public @Data class LmsStatusDTO {

	@NotNull
	String createdUser;
	
	@NotNull
	String currentStatus;
	
	@NotNull
	int id;
	
	@NotNull
	String keyText;
	
	@NotNull
	String keyType;
	
	@NotNull
	String keyValue;
	
	@NotNull
	String lastUpdatedUser;
	
	@NotNull
	String sequenceNumber;
}
