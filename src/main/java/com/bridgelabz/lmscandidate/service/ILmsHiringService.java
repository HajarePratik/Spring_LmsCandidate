package com.bridgelabz.lmscandidate.service;

import com.bridgelabz.lmscandidate.dto.ResponseDTO;

import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;

@Service
public interface ILmsHiringService {

	public ResponseDTO getCandidateHiringData();
	
	public ResponseDTO createCandidateHiringData(LmsHiringDTO hiringDTO);

	public ResponseDTO updateCandidateHiringDataById(String token,LmsHiringDTO hiringDTO);
	
	public ResponseDTO deleteCandidateHiringDataById(String token);

}
