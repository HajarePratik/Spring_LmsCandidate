package com.bridgelabz.lmscandidate.service;

import com.bridgelabz.lmscandidate.dto.ResponseDTO;

import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;

@Service
public interface ILmsHiringService {

	public ResponseDTO getCandidateHiringData();
	
	public ResponseDTO createCandidateHiringData(String token,LmsHiringDTO hiringDTO);

	public ResponseDTO updateCandidateHiringDataById(String token, int id,LmsHiringDTO hiringDTO);
	
	public ResponseDTO deleteCandidateHiringDataById(String token,int id);

	public ResponseDTO updateCandidateHiringStatus(String token, int id, String keyText);

	ResponseDTO joboffermail(String token, String email);

}
