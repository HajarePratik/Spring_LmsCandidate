package com.bridgelabz.lmscandidate.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.exception.LmsException;
import com.bridgelabz.lmscandidate.model.LmsHiring;
import com.bridgelabz.lmscandidate.respository.LmsHiringRepository;
import com.bridgelabz.lmscandidate.util.TokenUtil;

@Service
public class LmsHiringService  implements ILmsHiringService {
	
	@Autowired(required = true)
	private LmsHiringRepository hiringRespository;

	@Autowired
	ModelMapper modelmapper;

	@Override
	public ResponseDTO getCandidateHiringData() 
	{
		List<LmsHiring> isCandidatePresent = hiringRespository.findAll();
		return new ResponseDTO("List of all Hiring Candidate : ", isCandidatePresent);
	}
	@Override
	public ResponseDTO createCandidateHiringData(LmsHiringDTO hiringDTO) 
	{
		LmsHiring candidate = modelmapper.map(hiringDTO, LmsHiring.class);
		hiringRespository.save(candidate);
		return new ResponseDTO("Candidate is Added :", candidate);
	}

	@Override
	public ResponseDTO updateCandidateHiringDataById(String token, LmsHiringDTO hiringDTO) {
		int tokenid = TokenUtil.decodeToken(token);
		Optional<LmsHiring> isUserPresent = hiringRespository.findById(tokenid);
		if (isUserPresent.isPresent()) 
		{
			isUserPresent.get().setFirstName(hiringDTO.getFirstName());
			isUserPresent.get().setMiddleName(hiringDTO.getMiddleName());
			isUserPresent.get().setLastName(hiringDTO.getLastName());
			isUserPresent.get().setEmail(hiringDTO.getEmail());
			isUserPresent.get().setMobileNum(hiringDTO.getMobileNum());
			isUserPresent.get().setHiredcity(hiringDTO.getHiredcity());
			isUserPresent.get().setParentName(hiringDTO.getParentName());
			isUserPresent.get().setParentMobile(hiringDTO.getParentMobile());
			isUserPresent.get().setTemporaryAddress(hiringDTO.getTemporaryAddress());
			isUserPresent.get().setOccupation(hiringDTO.getOccupation());
			isUserPresent.get().setParentAnnualSalary(hiringDTO.getParentAnnualSalary());
			isUserPresent.get().setPermanentAddress(hiringDTO.getPermanentAddress());
			isUserPresent.get().setProfileImage(hiringDTO.getProfileImage());
			isUserPresent.get().setFolderId(hiringDTO.getFolderId());
			hiringRespository.save(isUserPresent.get());
			return new ResponseDTO("Hiring Candidate Data Successfully Updated", isUserPresent);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
		
	}

	@Override
	public ResponseDTO deleteCandidateHiringDataById(String token) {
		int tokenid = TokenUtil.decodeToken(token);
		Optional<LmsHiring> isUserPresent = hiringRespository.findById(tokenid);
		if(isUserPresent.isPresent())
		{
			hiringRespository.deleteById(tokenid);
			return new ResponseDTO("Deleted Successfully", HttpStatus.ACCEPTED);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
	}
	@Override
	public ResponseDTO updateCandidateHiringStatus(String token, int id, String keyText) 
	{
		Optional<LmsHiring> isUserPresent = hiringRespository.findById(id);
		if (isUserPresent.isPresent()) {
			isUserPresent.get().setStatus(keyText);
			hiringRespository.save(isUserPresent.get());
			return new ResponseDTO("Status of Hiring Successfully Updated", isUserPresent);
		} 
		else
		{
			throw new LmsException(400, "Candidate to be Updated Not found");
		}
	}

	

	
}
