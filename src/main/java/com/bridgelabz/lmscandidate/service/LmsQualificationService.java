package com.bridgelabz.lmscandidate.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.lmscandidate.dto.LmsQualificationInfoDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.exception.LmsException;
import com.bridgelabz.lmscandidate.model.LmsQualificationInfo;
import com.bridgelabz.lmscandidate.respository.LmsQualificationRepository;

@Service
public class LmsQualificationService implements ILmsQualificationService{

	
	@Autowired(required = true)
	private LmsQualificationRepository qualificationRespository;

	@Autowired
	ModelMapper modelmapper;
	
	@Autowired(required = true)
	RestTemplate restTemplate;

	@Override
	public ResponseDTO getQualificationData(String token) 
	{
		LmsQualificationInfo verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, LmsQualificationInfo.class);
		System.out.println("Value="+verify);
		if(verify!=null)
		{
			List<LmsQualificationInfo> isCandidatePresent = qualificationRespository.findAll();
			return new ResponseDTO("List of all Qualification Candidate : ", isCandidatePresent);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Qualification Not found");
		}
	}

	@Override
	public ResponseDTO createQualificationData(String token,LmsQualificationInfoDTO qualificationDTO)
	{
		
		LmsQualificationInfo verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, LmsQualificationInfo.class);
		System.out.println("Value="+verify);
		if(verify!=null)
		{
			LmsQualificationInfo candidate = modelmapper.map(qualificationDTO, LmsQualificationInfo.class);
			qualificationRespository.save(candidate);
			return new ResponseDTO("Candidate Qualification is Added :", candidate);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Qualification Not found");
		}
		
	}

	@Override
	public ResponseDTO updateQualificationDataById(String token,int id, LmsQualificationInfoDTO qualificationDTO) {
		LmsQualificationInfo verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, LmsQualificationInfo.class);
		System.out.println("Value="+verify);
		if(verify!=null)
		{
			Optional<LmsQualificationInfo> isUserPresent = qualificationRespository.findById(id);
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
		else
		{
			throw new LmsException(400,"Hiring Candidate Qualification Not found");
		}
		
	}

	@Override
	public ResponseDTO deleteQualificationDataById(String token,int id) 
	{
		LmsQualificationInfo verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, LmsQualificationInfo.class);
		System.out.println("Value="+verify);
		if(verify!=null)
		{
			Optional<LmsQualificationInfo> isUserPresent = qualificationRespository.findById(id);
			if(isUserPresent.isPresent())
			{
				qualificationRespository.deleteById(id);
				return new ResponseDTO("Deleted Successfully", HttpStatus.ACCEPTED);
			}
			else
			{
				throw new LmsException(400,"Qualification of Candidate Not found");
			}
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Qualification Not found");
		}
		
	}

}
