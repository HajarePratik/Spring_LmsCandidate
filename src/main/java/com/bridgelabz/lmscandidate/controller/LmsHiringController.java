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

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.service.ILmsHiringService;

@RestController
@RequestMapping("/lmscandidatehiring")
public class LmsHiringController {
	
	@Autowired(required = true)
	private ILmsHiringService hiringService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getCandidateHiringData()
	{
		ResponseDTO resDTO = hiringService.getCandidateHiringData(); 
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	@PostMapping("/createcandidatehiring")
	public ResponseEntity<ResponseDTO> createCandidateHiringData(String token,@RequestBody LmsHiringDTO hiringDTO)
	{

		ResponseDTO candidateData = hiringService.createCandidateHiringData(token,hiringDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, hiringDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatecandidatehiring/{id}")
	public ResponseEntity<ResponseDTO> updateCandidateHiringDataById(String token,int id,@RequestBody LmsHiringDTO hiringDTO) {
		ResponseDTO respDTO = hiringService.updateCandidateHiringDataById(token,id,hiringDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletecandidatehiring/{id}")
	public ResponseEntity<ResponseDTO> deleteCandidateHiringDataById(String token,int id) 
	{
		hiringService.deleteCandidateHiringDataById(token,id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with id : ", token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PutMapping("/updatestatushiring/{id}/{keyText}")
	public ResponseEntity<ResponseDTO> updatestatusHiring(String token, @PathVariable int id,@PathVariable String keyText) {
		ResponseDTO respDTO = hiringService.updateCandidateHiringStatus(token, id, keyText);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PostMapping("/jobofferMail")
	public ResponseEntity<ResponseDTO> jobOfferMail(String token, @RequestBody String email)
	{
		ResponseDTO respDTO = hiringService.jobOfferMail(token, email);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/getcandidatecount")
	public ResponseEntity<ResponseDTO> getcount(String token) {
		ResponseDTO respDTO = hiringService.getCandidateCount(token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
