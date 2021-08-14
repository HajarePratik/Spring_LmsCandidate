package com.bridgelabz.lmscandidate.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.lmscandidate.dto.LmsBankInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;

@Service
public interface ILmsBankService 
{

	public ResponseDTO getBankInfo();
	
	public ResponseDTO createBankInfo(LmsBankInfoDTO bankDTO);

	public ResponseDTO updateBankInfoDataById(String token,LmsBankInfoDTO bankDTO);
	
	public ResponseDTO deleteBankInfoDataById(String token);
	
	public ResponseDTO uploadDocument(String token,int id,MultipartFile panCard, MultipartFile aadharCard,MultipartFile bankPassbook);
	
	//public ResponseDTO store(String token,int id,MultipartFile panFile,MultipartFile aaadharFile,MultipartFile passBookFile);
}
