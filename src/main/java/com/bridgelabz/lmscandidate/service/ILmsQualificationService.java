package com.bridgelabz.lmscandidate.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsQualificationInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;

@Service
public interface ILmsQualificationService {

	
	public ResponseDTO getQualificationData();
	
	public ResponseDTO createQualificationData(String token, LmsQualificationInfoDTO qualificationDTO);
	
	public ResponseDTO updateQualificationDataById(String token,LmsQualificationInfoDTO qualificationDTO);
	
	public ResponseDTO deleteQualificationDataById(String token);

	

}
