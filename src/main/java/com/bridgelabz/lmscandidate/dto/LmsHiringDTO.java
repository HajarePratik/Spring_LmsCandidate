package com.bridgelabz.lmscandidate.dto;


import java.time.LocalDate;

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
	public String hiredCity;
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
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate creatorStamp;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate updateStamp;
	
	private int bank_Id;
	
	private int qualification_Id;
	
}
