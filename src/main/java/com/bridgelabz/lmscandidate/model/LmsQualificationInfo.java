package com.bridgelabz.lmscandidate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import com.bridgelabz.lmscandidate.dto.LmsQualificationInfoDTO;

import lombok.Data;

@Entity
@Table(name = "qualification_info")
public @Data class LmsQualificationInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public boolean diploma;
	public String degree;
	public String filed;
	public String yearOfPassing;
	public String finalPercentage;
	public String aggrPercentage;
	public String enggPercentage;
	public String finalCertification;
	public String trainingInstitute;
	public String trainingDuration;
	public String course;
	
	public LmsQualificationInfo() {
		
	}

	public LmsQualificationInfo(int id, @Valid LmsQualificationInfoDTO qualificationDTO) 
	{
		this.degree = qualificationDTO.getDegree();
		this.filed = qualificationDTO.getFiled();
		this.yearOfPassing = qualificationDTO.getYearOfPassing();
		this.finalPercentage = qualificationDTO.getFinalPercentage();
		this.aggrPercentage = qualificationDTO.getAggrPercentage();
		this.enggPercentage = qualificationDTO.getEnggPercentage();
		this.finalCertification = qualificationDTO.getFinalCertification();
		this.trainingInstitute = qualificationDTO.getTrainingInstitute();
		this.trainingDuration = qualificationDTO.getTrainingDuration();
		this.course = qualificationDTO.getCourse();
	}
	
	
	

}
