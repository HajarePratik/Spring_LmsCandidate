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
	@GetMapping("/getcandidate/{id}")
	public ResponseEntity<ResponseDTO> getCandidateDetail(String token, @PathVariable int id) {
		ResponseDTO respDTO = candidateService.getAllCandidateDetail(token, id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PostMapping("/createcandidate")
	public ResponseEntity<ResponseDTO> createCandidateData(String token,@RequestBody LmsCandidateDTO candidateDTO)
	{
		ResponseDTO candidateData = candidateService.createCandidateData(token,candidateDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, candidateDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	@PutMapping("/updatecandidate/{id}")
	public ResponseEntity<ResponseDTO> updateCandidateDataById(String token,@PathVariable int id, @RequestBody LmsCandidateDTO candidateDTO) {
		ResponseDTO respDTO = candidateService.updateCandidateDataById(token,id,candidateDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletecandicate/{id}")
	public ResponseEntity<ResponseDTO> deleteCandidateHiringDataById(String token,@PathVariable int id) {
		candidateService.deleteCandidateDataById(token,id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with id : ", id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/updatecandidatestatus/{id}/{keyText}")
	public ResponseEntity<ResponseDTO> updateCandidateStatus(String token, @PathVariable int id, @PathVariable String keyText) 
	{
		ResponseDTO respDTO = candidateService.updateCandidateStatus(token, id, keyText);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
