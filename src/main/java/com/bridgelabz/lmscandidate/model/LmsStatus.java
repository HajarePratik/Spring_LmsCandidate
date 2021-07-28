package com.bridgelabz.lmscandidate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import com.bridgelabz.lmscandidate.dto.LmsStatusDTO;

import lombok.Data;

@Entity
@Table(name="candidate_status")

public @Data class LmsStatus {
	
	public String createdUser;
	public String currentStatus;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public String keyText;
	public String keyType;
	public String keyValue;
	public String lastUpdatedUser;
	public String sequenceNumber;
	
	public LmsStatus() {
		
	}
	
	public LmsStatus(int id, @Valid LmsStatusDTO statusDTO)
	{
		// TODO Auto-generated constructor stub
		this.createdUser = statusDTO.getCreatedUser();
		this.currentStatus = statusDTO.getCurrentStatus();
		this.id = statusDTO.getId();
		this.keyText = statusDTO.getKeyText();
		this.keyType = statusDTO.getKeyType();
		this.keyValue = statusDTO.getKeyValue();
		this.lastUpdatedUser = statusDTO.getLastUpdatedUser();
		this.sequenceNumber = statusDTO.getSequenceNumber();
	}
	
	
	
	
}
