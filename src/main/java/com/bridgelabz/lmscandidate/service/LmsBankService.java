package com.bridgelabz.lmscandidate.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsBankInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.exception.LmsException;
import com.bridgelabz.lmscandidate.model.LmsBankInfo;
import com.bridgelabz.lmscandidate.respository.LmsBankRepository;

@Service
public class LmsBankService implements ILmsBankService{

	@Autowired(required = true)
	private LmsBankRepository bankRespository;

	@Autowired
	ModelMapper modelmapper;

	@Override
	public ResponseDTO getBankInfo() {
		List<LmsBankInfo> isCandidatePresent = bankRespository.findAll();
		return new ResponseDTO("List of all Bank Info Candidate : ", isCandidatePresent);
	}

	@Override
	public ResponseDTO createBankInfo(LmsBankInfoDTO bankDTO) 
	{
		LmsBankInfo bankDetails = modelmapper.map(bankDTO, LmsBankInfo.class);
		bankRespository.save(bankDetails);
		return new ResponseDTO("Add Bank Info: ",bankDetails);
	}

	@Override
	public ResponseDTO updateBankInfoDataById(String token, int id,LmsBankInfoDTO bankDTO)
	{
		Optional<LmsBankInfo> isUserPresent = bankRespository.findById(id);
		if (isUserPresent.isPresent()) 
		{
			isUserPresent.get().setAadharNumber(bankDTO.getAadharNumber());
			isUserPresent.get().setAadharPath(bankDTO.getAadharPath());
			isUserPresent.get().setBankAccountNumber(bankDTO.getBankAccountNumber());
			isUserPresent.get().setBankName(bankDTO.getBankName());
			isUserPresent.get().setCreatorStamp(bankDTO.getCreatorStamp());
			isUserPresent.get().setIfscCode(bankDTO.getIfscCode());
			isUserPresent.get().setPanNumber(bankDTO.getPanNumber());
			isUserPresent.get().setPanPath(bankDTO.getPanPath());
			isUserPresent.get().setPassbookPath(bankDTO.getPassbookPath());
			isUserPresent.get().setUpdateStamp(LocalDate.now());
			bankRespository.save(isUserPresent.get());
			return new ResponseDTO("Candidate Bank Data Successfully Updated", isUserPresent);
		} 
		else 
		{
				throw new LmsException(400, "Candidate to be Updated Not found");
		}
	}

	@Override
	public ResponseDTO deleteBankInfoDataById(String token, int id) 
	{
		Optional<LmsBankInfo> isUserPresent = bankRespository.findById(id);
		if(isUserPresent.isPresent())
		{
			bankRespository.deleteById(id);
			return new ResponseDTO("Deleted Successfully", HttpStatus.OK);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
	}
}
