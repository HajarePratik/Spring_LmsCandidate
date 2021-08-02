package com.bridgelabz.lmscandidate.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;

public @Data class LmsBankInfoDTO {

	@NotNull
	public String panNumber;
	
	@NotNull
	public String aadharNumber;
	
	@NotNull
	public String bankName;
	
	@NotNull
	public String bankAccountNumber;
	
	@NotNull
	public String ifscCode;
	
	@NotNull
	public String passbookPath;
	
	@NotNull
	public String panPath;
	
	@NotNull
	public String aadharPath;
	
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate creatorStamp;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate updateStamp;
}
