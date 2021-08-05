package com.bridgelabz.lmscandidate.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsBankInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;

@Service
public interface ILmsBankService 
{

	public ResponseDTO getBankInfo();
	
	public ResponseDTO createBankInfo(LmsBankInfoDTO bankDTO);

	public ResponseDTO updateBankInfoDataById(String token,LmsBankInfoDTO bankDTO);
	
	public ResponseDTO deleteBankInfoDataById(String token);

	
	
}
