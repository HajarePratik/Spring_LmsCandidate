package com.bridgelabz.lmscandidate.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;

public @Data class LmsCandidateDTO {
	
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
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate hiredDate;
	
	@NotNull
	public String degree;
	
	@NotNull
	public String hiredLab;
	
	@NotNull
	public String attitudeRemark;
	
	@NotNull
	public String communicationRemark;
	
	@NotNull
	public String knowledgeRemark;
	
	@NotNull
	public String onboardingStatus;
	
	@NotNull
	public String creatorUser;
	
	@NotNull
	public String status;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate joindate;
	
	
	@NotNull
	public String location;
	
	@NotNull
	public double aggrPer;
	
	@NotNull
	public int currentPincode;
	
	@NotNull
	public int permanentPincode;

}
