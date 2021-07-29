package com.bridgelabz.lmscandidate.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

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
	
	@NotEmpty(message = "creatorStamp should Not be Empty")
	@PastOrPresent(message = "creatorStamp should be past or todays date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate creatorStamp;
	
	@NotEmpty(message = "updateStamp should Not be Empty")
	@PastOrPresent(message = "updateStamp should be past or todays date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate updateStamp;
}
