package com.bridgelabz.lmscandidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/getqualification/{token}")
	public ResponseEntity<ResponseDTO> getQualificationData(@PathVariable String token)
	{
		ResponseDTO respDTO = qualificationService.getQualificationData(token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PostMapping("/createqualification/{token}")
	public ResponseEntity<ResponseDTO> createCandidateHiringData(@PathVariable String token,@RequestBody LmsQualificationInfoDTO qualificationDTO)
	{

		ResponseDTO candidateData = qualificationService.createQualificationData(token,qualificationDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, qualificationDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatequalification/{token}/{id}")
	public ResponseEntity<ResponseDTO> updateCandidateHiringDataById(@PathVariable String token,@PathVariable int id,@RequestBody LmsQualificationInfoDTO qualificationDTO) 
	{
		ResponseDTO respDTO = qualificationService.updateQualificationDataById(token,id,qualificationDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletequalification/{token}/{id}")
	public ResponseEntity<ResponseDTO> deleteCandidateHiringDataById(@PathVariable String token,@PathVariable int id) 
	{
		qualificationService.deleteQualificationDataById(token,id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with token : ", token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
