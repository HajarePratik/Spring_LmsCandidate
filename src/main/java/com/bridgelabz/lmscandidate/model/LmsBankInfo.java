package com.bridgelabz.lmscandidate.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import com.bridgelabz.lmscandidate.dto.LmsBankInfoDTO;

import lombok.Data;

@Entity
@Table(name = "bank_info")
public @Data class LmsBankInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public String panNumber;
	public String aadharNumber;
	public String bankName;
	public String bankAccountNumber;
	public String ifscCode;
	public String passbookPath;
	public String panPath;
	public String aadharPath;
	public LocalDate creatorStamp;
	public LocalDate updateStamp;
	
	public LmsBankInfo() {
	
	}

	public LmsBankInfo(int id, @Valid LmsBankInfoDTO bankDTO) 
	{
		this.panNumber = bankDTO.getPanNumber();
		this.aadharNumber = bankDTO.getAadharNumber();
		this.bankName = bankDTO.getBankName();
		this.bankAccountNumber = bankDTO.getBankAccountNumber();
		this.ifscCode = bankDTO.getIfscCode();
		this.passbookPath = bankDTO.getPassbookPath();
		this.panPath = bankDTO.getPanPath();
		this.aadharPath = bankDTO.getAadharPath();
		this.creatorStamp = bankDTO.getCreatorStamp();
		this.updateStamp = bankDTO.getUpdateStamp();
	}
	
	
	
	

}
