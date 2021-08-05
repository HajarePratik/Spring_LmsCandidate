package com.bridgelabz.lmscandidate.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.LmsQualificationInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.exception.LmsException;
import com.bridgelabz.lmscandidate.model.LmsQualificationInfo;
import com.bridgelabz.lmscandidate.respository.LmsQualificationRepository;
import com.bridgelabz.lmscandidate.util.TokenUtil;

@Service
public class LmsQualificationService implements ILmsQualificationService{

	
	@Autowired(required = true)
	private LmsQualificationRepository qualificationRespository;

	@Autowired
	ModelMapper modelmapper;

	@Override
	public ResponseDTO getQualificationData() 
	{
		List<LmsQualificationInfo> isCandidatePresent = qualificationRespository.findAll();
		return new ResponseDTO("List of all Qualification Candidate : ", isCandidatePresent);
	}

	@Override
	public ResponseDTO createQualificationData(LmsQualificationInfoDTO qualificationDTO) {
		LmsQualificationInfo candidate = modelmapper.map(qualificationDTO, LmsQualificationInfo.class);
		qualificationRespository.save(candidate);
		return new ResponseDTO("Candidate Qualification is Added :", candidate);
	}

	@Override
	public ResponseDTO updateQualificationDataById(String token, LmsQualificationInfoDTO qualificationDTO) {
		int tokenid = TokenUtil.decodeToken(token);
		Optional<LmsQualificationInfo> isUserPresent = qualificationRespository.findById(tokenid);
		if (isUserPresent.isPresent()) 
		{
			isUserPresent.get().setDegree(qualificationDTO.getDegree());
			isUserPresent.get().setFiled(qualificationDTO.getFiled());
			isUserPresent.get().setYearOfPassing(qualificationDTO.getYearOfPassing());
			isUserPresent.get().setFinalPercentage(qualificationDTO.getFinalPercentage());
			isUserPresent.get().setAggrPercentage(qualificationDTO.getAggrPercentage());
			isUserPresent.get().setEnggPercentage(qualificationDTO.getEnggPercentage());
			isUserPresent.get().setFinalCertification(qualificationDTO.getFinalCertification());
			isUserPresent.get().setTrainingInstitute(qualificationDTO.getTrainingInstitute());
			isUserPresent.get().setTrainingDuration(qualificationDTO.getTrainingDuration());
			isUserPresent.get().setCourse(qualificationDTO.getCourse());
			qualificationRespository.save(isUserPresent.get());
			return new ResponseDTO("Hiring Candidate Qualification Data Successfully Updated", isUserPresent);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Qualification Not found");
		}
	}

	@Override
	public ResponseDTO deleteQualificationDataById(String token) 
	{
		int tokenid = TokenUtil.decodeToken(token);
		Optional<LmsQualificationInfo> isUserPresent = qualificationRespository.findById(tokenid);
		if(isUserPresent.isPresent())
		{
			qualificationRespository.deleteById(tokenid);
			return new ResponseDTO("Deleted Successfully", HttpStatus.ACCEPTED);
		}
		else
		{
			throw new LmsException(400,"Qualification of Candidate Not found");
		}
	}

}
