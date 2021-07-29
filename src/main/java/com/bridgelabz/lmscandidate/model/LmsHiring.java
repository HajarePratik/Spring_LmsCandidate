package com.bridgelabz.lmscandidate.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;

import lombok.Data;


@Entity
@Table(name = "candidate_hiring")
public @Data class LmsHiring {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	public String firstName;
	public String middleName;
	public String lastName;
	public String email;
	public String mobileNum;
	public String hiredcity;
	public String parentName;
	public String parentMobile;
	public String temporaryAddress;
	public String occupation;
	public String parentAnnualSalary;
	public String permanentAddress;
	public String profileImage;
	public String folderId;
	public String status;
	public LocalDate creatorStamp;
	public LocalDate updateStamp;
	public String bankInfo;
	public String qualification_Info;
	
	public LmsHiring() {
	
	}
	
	public LmsHiring(int id, @Valid LmsHiringDTO HiringDTO)
	{
		// TODO Auto-generated constructor stub
		this.firstName = HiringDTO.getFirstName();
		this.middleName = HiringDTO.getMiddleName();
		this.lastName = HiringDTO.getLastName();
		this.email = HiringDTO.getEmail();
		this.mobileNum = HiringDTO.getMobileNum();
		this.hiredcity = HiringDTO.getHiredcity();
		this.parentName = HiringDTO.getParentName();
		this.parentMobile = HiringDTO.getParentMobile();
		this.temporaryAddress = HiringDTO.getTemporaryAddress();
		this.occupation = HiringDTO.getOccupation();
		this.parentAnnualSalary = HiringDTO.getParentAnnualSalary();
		this.profileImage = HiringDTO.getProfileImage();
		this.folderId = HiringDTO.getFolderId();
		this.status = HiringDTO.getStatus();
		this.creatorStamp = HiringDTO.getCreatorStamp();
		this.updateStamp = HiringDTO.getUpdateStamp();
		this.bankInfo = HiringDTO.getBankInfo();
		this.qualification_Info = HiringDTO.getQualification_Info();
	}

	
}
