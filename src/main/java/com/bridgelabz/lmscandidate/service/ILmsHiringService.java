package com.bridgelabz.lmscandidate.service;

import com.bridgelabz.lmscandidate.dto.ResponseDTO;

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;

public interface ILmsHiringService {

	public ResponseDTO getCandidateData();
	
	public ResponseDTO createCandidateData(LmsHiringDTO hiringDTO);

	public ResponseDTO updateCandidateDataById(String token,LmsHiringDTO hiringDTO);
	
	public ResponseDTO deleteCandidateDataById(String token);

}
