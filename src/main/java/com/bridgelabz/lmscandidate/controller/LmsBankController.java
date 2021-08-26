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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.lmscandidate.dto.LmsBankInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.service.ILmsBankService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/lmsbankinfo")
public class LmsBankController {

	
	@Autowired(required = true)
	private ILmsBankService bankService;
	
	@GetMapping("/get/{token}")
	public ResponseEntity<ResponseDTO> getBankInfo(@PathVariable String token)
	{
		ResponseDTO resDTO = bankService.getBankInfo(token); 
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	@PostMapping("/createbankdetails/{token}")
	public ResponseEntity<ResponseDTO> createBankInfo(@PathVariable String token,@RequestBody LmsBankInfoDTO bankDTO)
	{

		ResponseDTO candidateData = bankService.createBankInfo(token,bankDTO);
		ResponseDTO resDTO = new ResponseDTO("Create Candidate Details Sucessfully :"+candidateData, bankDTO);
		return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatebankdetails/{token}/{id}")
	public ResponseEntity<ResponseDTO> updateBankInfoDataById(@PathVariable String token,@PathVariable int id,@RequestBody LmsBankInfoDTO bankDTO) 
	{
		ResponseDTO respDTO = bankService.updateBankInfoDataById(token,id,bankDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deletebankdetails/{token}")
	public ResponseEntity<ResponseDTO> deleteBankInfoDataById(@PathVariable String token,@PathVariable int id) 
	{
		bankService.deleteBankInfoDataById(token,id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Candidate with token : ", id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/upload/{token}/{id}", consumes = { "multipart/form-data" })
	@ApiOperation(value = "Upload Documents", response = ResponseDTO.class)
	public ResponseEntity<ResponseDTO> addBankDetail(String token,@PathVariable int id,
			@RequestParam("panCard") MultipartFile panFile, @RequestParam("aadharCard") MultipartFile AadharFile,
			@RequestParam("passBook") MultipartFile passBookFile) 
	{
		
		ResponseDTO respDTO = bankService.uploadDocument(token,id,panFile, AadharFile, passBookFile);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
}
