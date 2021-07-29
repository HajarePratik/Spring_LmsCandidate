package com.bridgelabz.lmscandidate.dto;


import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;


public @Data class LmsHiringDTO {
	
	@NotNull
	public String firstName;
	@NotNull
	public String middleName;
	@NotNull
	public String lastName;
	@NotNull
	public String email;
	@NotNull
	public String mobileNum;
	@NotNull
	public String hiredcity;
	@NotNull
	public String parentName;
	@NotNull
	public String parentMobile;
	@NotNull
	public String temporaryAddress;
	@NotNull
	public String occupation;
	@NotNull
	public String parentAnnualSalary;
	@NotNull
	public String permanentAddress;
	@NotNull
	public String profileImage;
	@NotNull
	public String folderId;
	@NotNull
	public String status;
	
	@NotEmpty(message = "creatorStamp should Not be Empty")
	@PastOrPresent(message = "creatorStamp should be past or todays date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate creatorStamp;
	
	@NotEmpty(message = "updateStamp should Not be Empty")
	@PastOrPresent(message = "updateStamp should be past or todays date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate updateStamp;
	
	@NotNull
	public String bankInfo;
	
	@NotNull
	public String qualification_Info;
	
}
