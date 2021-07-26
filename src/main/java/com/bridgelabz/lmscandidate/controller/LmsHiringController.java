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

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.service.ILmsHiringService;

@RestController
@RequestMapping("/lmscandidatehiring")
public class LmsHiringController {
	
	@Autowired(required = true)
	private ILmsHiringService hiringService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getCandidateData()
	{
		ResponseDTO resDTO = hiringService.getCandidateData(); 
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createCandidateData(@RequestBody LmsHiringDTO hiringDTO)
	{

		ResponseDTO candidateData = hiringService.createCandidateData(hiringDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, hiringDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatehiring/{token}")
	public ResponseEntity<ResponseDTO> updateCandidateDataById(@PathVariable String token,@Valid @RequestBody LmsHiringDTO hiringDTO) {
		ResponseDTO respDTO = hiringService.updateCandidateDataById(token,hiringDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletehiring/{token}")
	public ResponseEntity<ResponseDTO> deleteCandidateDataById(@PathVariable String token) {
		hiringService.deleteCandidateDataById(token);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with id : ", token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
