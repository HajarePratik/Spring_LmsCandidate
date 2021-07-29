package com.bridgelabz.lmscandidate.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
