package com.bridgelabz.lmscandidate.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import com.bridgelabz.lmscandidate.dto.LmsCandidateDTO;

import lombok.Data;

@Entity
@Table(name = "candidate_details")
public @Data class LmsCandidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	public String firstName;
	public String middleName;
	public String lastName;
	public String email;
	public String mobileNum;
	public String hiredCity;
	public LocalDate hiredDate;
	public String degree;
	public String hiredLab;
	public String attitudeRemark;
	public String communicationRemark;
	public String knowledgeRemark;
	public String onboardingStatus;
	public String creatorUser;
	public LocalDate joindate;
	public String location;
	public String status;
	public double aggrPer;
	public int currentPincode;
	public int permanentPincode;
	

	public LmsCandidate() {
	
	}
	
	public LmsCandidate(int id, @Valid LmsCandidateDTO CandidateDTO)
	{
		// TODO Auto-generated constructor stub
		this.firstName = CandidateDTO.getFirstName();
		this.middleName = CandidateDTO.getMiddleName();
		this.lastName = CandidateDTO.getLastName();
		this.email = CandidateDTO.getEmail();
		this.mobileNum = CandidateDTO.getMobileNum();
		this.hiredCity = CandidateDTO.getHiredCity();
		this.hiredDate = CandidateDTO.getHiredDate();
		this.degree = CandidateDTO.getDegree();
		this.hiredLab = CandidateDTO.getHiredLab();
		this.attitudeRemark = CandidateDTO.getAttitudeRemark();
		this.communicationRemark = CandidateDTO.getCommunicationRemark();
		this.knowledgeRemark = CandidateDTO.getKnowledgeRemark();
		this.onboardingStatus = CandidateDTO.getOnboardingStatus();
		this.creatorUser = CandidateDTO.getCreatorUser();
		this.joindate = CandidateDTO.getJoindate();
		this.location = CandidateDTO.getLocation();
		this.status = CandidateDTO.getStatus();
		this.aggrPer = CandidateDTO.getAggrPer();
		this.currentPincode = CandidateDTO.getCurrentPincode();
		this.permanentPincode = CandidateDTO.getPermanentPincode();
	}


}
