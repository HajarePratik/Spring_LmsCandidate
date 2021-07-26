package com.bridgelabz.lmscandidate.dto;


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
	
	
}
