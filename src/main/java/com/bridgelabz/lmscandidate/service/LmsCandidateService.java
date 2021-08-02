package com.bridgelabz.lmscandidate.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsCandidateDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.exception.LmsException;
import com.bridgelabz.lmscandidate.model.LmsCandidate;
import com.bridgelabz.lmscandidate.respository.LmsCandidateRepository;

@Service
public class LmsCandidateService implements ILmsCandidateService {

	
	@Autowired(required = true)
	private LmsCandidateRepository candidateRespository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public ResponseDTO getCandidateData() {
		List<LmsCandidate> isCandidatePresent = candidateRespository.findAll();
		return new ResponseDTO("List of all Candidate : ", isCandidatePresent);
	}
	
	@Override
	public ResponseDTO getAllCandidateDetail(String token, int id) {
		Optional<LmsCandidate> isUserPresent = candidateRespository.findById(id);
		LmsCandidate candidates = isUserPresent.get();
		return new ResponseDTO("List of Candidates Details : ", candidates);
	}

	@Override
	public ResponseDTO createCandidateData(String token,LmsCandidateDTO candidateDTO) 
	{
		LmsCandidate candidate = modelmapper.map(candidateDTO, LmsCandidate.class);
		candidateRespository.save(candidate);
		return new ResponseDTO("Candidate is Added :", candidate);
	}

	@Override
	public ResponseDTO updateCandidateDataById(String token,int id, LmsCandidateDTO candidateDTO) 
	{
	
		Optional<LmsCandidate> isUserPresent = candidateRespository.findById(id);
		if (isUserPresent.isPresent()) 
		{
			isUserPresent.get().setFirstName(candidateDTO.getFirstName());
			isUserPresent.get().setMiddleName(candidateDTO.getMiddleName());
			isUserPresent.get().setLastName(candidateDTO.getLastName());
			isUserPresent.get().setEmail(candidateDTO.getEmail());
			isUserPresent.get().setMobileNum(candidateDTO.getMobileNum());
			isUserPresent.get().setHiredCity(candidateDTO.getHiredCity());
			isUserPresent.get().setHiredDate(candidateDTO.getHiredDate());
			isUserPresent.get().setDegree(candidateDTO.getDegree());
			isUserPresent.get().setHiredLab(candidateDTO.getHiredLab());
			isUserPresent.get().setAttitudeRemark(candidateDTO.getAttitudeRemark());
			isUserPresent.get().setKnowledgeRemark(candidateDTO.getKnowledgeRemark());
			isUserPresent.get().setOnboardingStatus(candidateDTO.getOnboardingStatus());
			isUserPresent.get().setCreatorUser(candidateDTO.getCreatorUser());
			isUserPresent.get().setJoindate(candidateDTO.getJoindate());
			isUserPresent.get().setLocation(candidateDTO.getLocation());
			isUserPresent.get().setAggrPer(candidateDTO.getAggrPer());
			isUserPresent.get().setCurrentPincode(candidateDTO.getCurrentPincode());
			isUserPresent.get().setPermanentPincode(candidateDTO.getPermanentPincode());
			candidateRespository.save(isUserPresent.get());
			return new ResponseDTO("Candidate Data Successfully Updated", isUserPresent);
		}
		else
		{
			throw new LmsException(400,"Candidate Not found");
		}
	}

	@Override
	public ResponseDTO deleteCandidateDataById(String token,int id)
	{
	
		Optional<LmsCandidate> isUserPresent = candidateRespository.findById(id);
		if(isUserPresent.isPresent())
		{
			candidateRespository.deleteById(id);
			return new ResponseDTO("Deleted Successfully", HttpStatus.OK);
		}
		else
		{
			throw new LmsException(400,"Delete Candidate Not found");
		}
	}

	@Override
	public ResponseDTO updateCandidateStatus(String token, int id, String keyText) 
	{
		Optional<LmsCandidate> isUserPresent = candidateRespository.findById(id);
		if (isUserPresent.isPresent()) 
		{
			isUserPresent.get().setStatus(keyText);
			candidateRespository.save(isUserPresent.get());
			return new ResponseDTO("Status of Hiring Successfully Updated", isUserPresent);
		} 
		else 
		{
			throw new LmsException(400, "Candidate to be Updated Not found");
		}
	}

}
