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
import com.bridgelabz.lmscandidate.dto.LmsStatusDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;

import com.bridgelabz.lmscandidate.service.ILmsStatusService;


@RestController
@RequestMapping("/lmsstatus")
public class LmsStatusController 
{
	@Autowired(required = true)
	private ILmsStatusService statusService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAllStatus()
	{
		ResponseDTO resDTO = statusService.getAllStatus(); 
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	@PostMapping("/createstatus")
	public ResponseEntity<ResponseDTO> createStatus(@RequestBody LmsStatusDTO statusDTO)
	{

		ResponseDTO candidateData = statusService.createStatus(statusDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, statusDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatestatus/{id}")
	public ResponseEntity<ResponseDTO> updateStatusDataById(String token,int id,@RequestBody LmsStatusDTO statusDTO)
	{
		ResponseDTO respDTO = statusService.updateStatusDataById(token,id,statusDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletestatus/{id}")
	public ResponseEntity<ResponseDTO> deleteStatusDataById(String token,int id) 
	{
		statusService.deleteStatusDataById(token,id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Status Candidate with id : ", id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
