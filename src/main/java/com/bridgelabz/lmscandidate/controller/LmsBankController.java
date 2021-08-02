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

import com.bridgelabz.lmscandidate.dto.LmsBankInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.service.ILmsBankService;



@RestController
@RequestMapping("/lmsbankinfo")
public class LmsBankController {

	
	@Autowired(required = true)
	private ILmsBankService bankService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getBankInfo()
	{
		ResponseDTO resDTO = bankService.getBankInfo(); 
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	@PostMapping("/createbankdetails")
	public ResponseEntity<ResponseDTO> createBankInfo(@RequestBody LmsBankInfoDTO bankDTO)
	{

		ResponseDTO candidateData = bankService.createBankInfo(bankDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, bankDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatebankdetails/{id}")
	public ResponseEntity<ResponseDTO> updateBankInfoDataById(String token,@PathVariable int id,@RequestBody LmsBankInfoDTO bankDTO) 
	{
		ResponseDTO respDTO = bankService.updateBankInfoDataById(token,id,bankDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletebankdetails/{id}")
	public ResponseEntity<ResponseDTO> deleteBankInfoDataById(String token,@PathVariable int id) 
	{
		bankService.deleteBankInfoDataById(token,id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with id : ", token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
