package com.bridgelabz.lmscandidate.controller;

import javax.validation.Valid;

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

import com.bridgelabz.lmscandidate.dto.LmsCandidateDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.service.ILmsCandidateService;


@RestController
@RequestMapping("/lmscandidate")
public class LmsCandidateController {
	
	@Autowired(required = true)
	private ILmsCandidateService candidateService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getCandidateData()
	{
		ResponseDTO resDTO = candidateService.getCandidateData(); 
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	@PostMapping("/createcandidate")
	public ResponseEntity<ResponseDTO> createCandidateData(@RequestBody LmsCandidateDTO candidateDTO)
	{

		ResponseDTO candidateData = candidateService.createCandidateData(candidateDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, candidateDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatecandidate/{token}")
	public ResponseEntity<ResponseDTO> updateCandidateDataById(@PathVariable String token,@Valid @RequestBody LmsCandidateDTO candidateDTO) {
		ResponseDTO respDTO = candidateService.updateCandidateDataById(token,candidateDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletecandicate/{token}")
	public ResponseEntity<ResponseDTO> deleteCandidateHiringDataById(@PathVariable String token) {
		candidateService.deleteCandidateDataById(token);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with id : ", token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
