package com.bridgelabz.lmscandidate.model;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name = "candidate_hiring")
public @Data class LmsHiring {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_Id", referencedColumnName = "id")
	private LmsBankInfo hiringBankInfo;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "qualification_Id", referencedColumnName = "id")
	private LmsQualificationInfo hiringQualificationInfo;
	
	public String firstName;
	public String middleName;
	public String lastName;
	public String email;
	public String mobileNum;
	public String hiredCity;
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
		this.hiredCity = HiringDTO.getHiredCity();
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
		
	}

	
}
