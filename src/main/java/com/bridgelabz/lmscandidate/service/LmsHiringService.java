package com.bridgelabz.lmscandidate.service;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.lmscandidate.dto.LmsHiringDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.exception.LmsException;
import com.bridgelabz.lmscandidate.model.LmsHiring;
import com.bridgelabz.lmscandidate.respository.LmsHiringRepository;
import com.bridgelabz.lmscandidate.util.JMSUtil;


@Service
public class LmsHiringService  implements ILmsHiringService {
	
	@Autowired(required = true)
	private LmsHiringRepository hiringRespository;

	@Autowired
	ModelMapper modelmapper;

	@Autowired(required = true)
	RestTemplate restTemplate;
	
	@Override
	public ResponseDTO getCandidateHiringData(String token) 
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			List<LmsHiring> isCandidatePresent = hiringRespository.findAll();
			return new ResponseDTO("List of all Hiring Candidate : ", isCandidatePresent);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
	}
	@Override
	public ResponseDTO createCandidateHiringData(String token,LmsHiringDTO hiringDTO) 
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			LmsHiring candidate = modelmapper.map(hiringDTO, LmsHiring.class);
			hiringRespository.save(candidate);
			return new ResponseDTO("Candidate is Added :", candidate);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
		
		
	}

	@Override
	public ResponseDTO updateCandidateHiringDataById(String token,int id, LmsHiringDTO hiringDTO) 
	{
		
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			Optional<LmsHiring> isUserPresent = hiringRespository.findById(id);
			if (isUserPresent.isPresent()) 
			{
				isUserPresent.get().setFirstName(hiringDTO.getFirstName());
				isUserPresent.get().setMiddleName(hiringDTO.getMiddleName());
				isUserPresent.get().setLastName(hiringDTO.getLastName());
				isUserPresent.get().setEmail(hiringDTO.getEmail());
				isUserPresent.get().setMobileNum(hiringDTO.getMobileNum());
				isUserPresent.get().setHiredCity(hiringDTO.getHiredCity());
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
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
		
	}

	@Override
	public ResponseDTO deleteCandidateHiringDataById(String token,int id)
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			Optional<LmsHiring> isUserPresent = hiringRespository.findById(id);
			if(isUserPresent.isPresent())
			{
				hiringRespository.deleteById(id);
				return new ResponseDTO("Deleted Successfully", HttpStatus.ACCEPTED);
			}
			else
			{
				throw new LmsException(400,"Hiring Candidate Not found");
			}
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
		
	}
	@Override
	public ResponseDTO updateCandidateHiringStatus(String token,int id, String keyText) 
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			Optional<LmsHiring> isUserPresent = hiringRespository.findById(id);
			if (isUserPresent.isPresent())
			{
				isUserPresent.get().setStatus(keyText);
				hiringRespository.save(isUserPresent.get());
				return new ResponseDTO("Status of Hiring Successfully Updated", isUserPresent);
			} 
			else
			{
				throw new LmsException(400, "Candidate to be Updated Not found");
			}
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
		
	}
	
	@Override
	public ResponseDTO jobOfferMail(String token, String email) 
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			Optional<LmsHiring> isUserPresent = hiringRespository.findAllByemail(email);
			boolean isPresent = isUserPresent.get().getEmail().matches(email);
			if (isPresent == true) 
			{
				String body = "This is a Candidate Job Offer Notification";
				JMSUtil.sendEmail(isUserPresent.get().getEmail(), "Job Offer", body);
				return new ResponseDTO("Email is Successfully Sent to ", email);
			} 
			else 
			{
				throw new LmsException(400, "Email Address not Found");
			}
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}		
					
	}
	
	@Override
	public ResponseDTO getCandidateCount(String token)
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			List<LmsHiring> isUserPresent = hiringRespository.findAll();
			long i = 0;
			for (Iterator<LmsHiring> iterator = isUserPresent.iterator(); iterator.hasNext();) 
			{
				 iterator.next();
				 i++;
			}
			return new ResponseDTO("Number of Candidates is Present: ", i);
		}
		else
		{
			throw new LmsException(400,"Hiring Candidate Not found");
		}
	}
	
}
