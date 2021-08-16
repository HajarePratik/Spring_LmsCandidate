package com.bridgelabz.lmscandidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.lmscandidate.dto.LmsQualificationInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;

import com.bridgelabz.lmscandidate.service.ILmsQualificationService;

@RestController
@RequestMapping("/lmscandidatequalification")
public class LmsQualificationController {

	@Autowired(required = true)
	private ILmsQualificationService qualificationService;
	
	@GetMapping("/getqualification")
	public ResponseEntity<ResponseDTO> getQualificationData()
	{
		ResponseDTO respDTO = qualificationService.getQualificationData();
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PostMapping("/createqualification/{token}")
	public ResponseEntity<ResponseDTO> createCandidateHiringData(String token,@RequestBody LmsQualificationInfoDTO qualificationDTO)
	{

		ResponseDTO candidateData = qualificationService.createQualificationData(token,qualificationDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, qualificationDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatequalification/{token}")
	public ResponseEntity<ResponseDTO> updateCandidateHiringDataById(String token,@RequestBody LmsQualificationInfoDTO qualificationDTO) {
		ResponseDTO respDTO = qualificationService.updateQualificationDataById(token,qualificationDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletequalification/{token}")
	public ResponseEntity<ResponseDTO> deleteCandidateHiringDataById(String token) {
		qualificationService.deleteQualificationDataById(token);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with token : ", token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
