package com.bridgelabz.lmscandidate.service;


import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsCandidateDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;

@Service
public interface ILmsCandidateService {

	public ResponseDTO getAllCandidateDetail(String token);
	
	public ResponseDTO getCandidateData(String token,int id);
	
	public ResponseDTO createCandidateData(String token,LmsCandidateDTO candidateDTO);

	public ResponseDTO updateCandidateDataById(String token,int id, LmsCandidateDTO candidateDTO);
	
	public ResponseDTO deleteCandidateDataById(String token,int id);

	public ResponseDTO updateCandidateStatus(String token,int id, String keyText);

	
}
