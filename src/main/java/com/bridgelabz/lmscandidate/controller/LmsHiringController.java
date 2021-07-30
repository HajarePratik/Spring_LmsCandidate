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
	public ResponseEntity<ResponseDTO> getCandidateHiringData()
	{
		ResponseDTO resDTO = hiringService.getCandidateHiringData(); 
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	@PostMapping("/createcandidatehiring")
	public ResponseEntity<ResponseDTO> createCandidateHiringData(@RequestBody LmsHiringDTO hiringDTO)
	{

		ResponseDTO candidateData = hiringService.createCandidateHiringData(hiringDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, hiringDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatecandidatehiring/{token}")
	public ResponseEntity<ResponseDTO> updateCandidateHiringDataById(@PathVariable String token,@Valid @RequestBody LmsHiringDTO hiringDTO) {
		ResponseDTO respDTO = hiringService.updateCandidateHiringDataById(token,hiringDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletecandidatehiring/{token}")
	public ResponseEntity<ResponseDTO> deleteCandidateHiringDataById(@PathVariable String token) {
		hiringService.deleteCandidateHiringDataById(token);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with id : ", token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PutMapping("/updatestatushiring/{id}/{keyText}")
	public ResponseEntity<ResponseDTO> updatestatusHiring(String token, @PathVariable int id,
			@PathVariable String keyText) {
		ResponseDTO respDTO = hiringService.updateCandidateHiringStatus(token, id, keyText);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
