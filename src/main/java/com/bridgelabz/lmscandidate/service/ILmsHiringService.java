package com.bridgelabz.lmscandidate.service;

import com.bridgelabz.lmscandidate.dto.ResponseDTO;

import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;

@Service
public interface ILmsHiringService {

	public ResponseDTO getCandidateHiringData();
	
	public ResponseDTO createCandidateHiringData(String token,LmsHiringDTO hiringDTO);

	public ResponseDTO updateCandidateHiringDataById(String token,LmsHiringDTO hiringDTO);
	
	public ResponseDTO deleteCandidateHiringDataById(String token);

	public ResponseDTO updateCandidateHiringStatus(String token, String keyText);

	ResponseDTO jobOfferMail(String token, String email);

	ResponseDTO getCandidateCount(String token);

}
