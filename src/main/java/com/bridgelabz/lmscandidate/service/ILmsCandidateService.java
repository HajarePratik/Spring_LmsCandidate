package com.bridgelabz.lmscandidate.service;


import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsCandidateDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;

@Service
public interface ILmsCandidateService {

	public ResponseDTO getCandidateData();
	
	public ResponseDTO getAllCandidateDetail(String token);
	
	public ResponseDTO createCandidateData(String token,LmsCandidateDTO candidateDTO);

	public ResponseDTO updateCandidateDataById(String token, LmsCandidateDTO candidateDTO);
	
	public ResponseDTO deleteCandidateDataById(String token);

	public ResponseDTO updateCandidateStatus(String token, String keyText);

	
}
