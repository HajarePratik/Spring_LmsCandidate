package com.bridgelabz.lmscandidate.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsStatusDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;

@Service
public interface ILmsStatusService {
	
	public ResponseDTO getStatus(String token);
	
	public ResponseDTO createStatus(String token, LmsStatusDTO statusDTO);

	public ResponseDTO updateStatusDataById(String token,int id,LmsStatusDTO statusDTO);
	
	public ResponseDTO deleteStatusDataById(String token,int id);

	


}
