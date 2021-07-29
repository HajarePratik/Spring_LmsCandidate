package com.bridgelabz.lmscandidate.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

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
	
	@NotEmpty(message = "hiredDate should Not be Empty")
	@PastOrPresent(message = "hiredDate should be past or todays date")
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
	
	@NotEmpty(message = "joinDate should Not be Empty")
	@PastOrPresent(message = "joinDate should be past or todays date")
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
