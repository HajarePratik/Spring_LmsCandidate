package com.bridgelabz.lmscandidate.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.lmscandidate.dto.LmsStatusDTO;
import com.bridgelabz.lmscandidate.dto.ResponseDTO;
import com.bridgelabz.lmscandidate.exception.LmsException;
import com.bridgelabz.lmscandidate.model.LmsStatus;

import com.bridgelabz.lmscandidate.respository.LmsStatusRepository;

@Service
public class LmsStatusService implements ILmsStatusService {

	@Autowired(required = true)
	private LmsStatusRepository statusRespository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Autowired(required = true)
	RestTemplate restTemplate;
	
	@Override
	public ResponseDTO getStatus(String token) 
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			List<LmsStatus> isStatusPresent = statusRespository.findAll();
			return new ResponseDTO("List of all Candidate : ", isStatusPresent);
		}
		else
		{
			throw new LmsException(400,"Candidate Status Not found");
		}
	}

	@Override
	public ResponseDTO createStatus(String token,LmsStatusDTO statusDTO) 
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			LmsStatus status = modelmapper.map(statusDTO, LmsStatus.class);
			statusRespository.save(status);
			return new ResponseDTO("Candidate Status Added :", status);
		}
		else
		{
			throw new LmsException(400,"Candidate Status Not found");
		}
	}

	@Override
	public ResponseDTO updateStatusDataById(String token,int id, LmsStatusDTO statusDTO)
	{

		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{
			Optional<LmsStatus> isUserPresent = statusRespository.findById(id);
			if (isUserPresent.isPresent()) 
			{
				isUserPresent.get().setCreatedUser(statusDTO.getCreatedUser());
				isUserPresent.get().setCurrentStatus(statusDTO.getCurrentStatus());
				isUserPresent.get().setId(statusDTO.getId());
				isUserPresent.get().setKeyText(statusDTO.getKeyText());
				isUserPresent.get().setKeyType(statusDTO.getKeyType());
				isUserPresent.get().setKeyValue(statusDTO.getKeyValue());
				isUserPresent.get().setLastUpdatedUser(statusDTO.getLastUpdatedUser());
				isUserPresent.get().setSequenceNumber(statusDTO.getSequenceNumber());
				statusRespository.save(isUserPresent.get());
				return new ResponseDTO("Candidate Status Successfully Updated", isUserPresent);
			}
			else
			{
				throw new LmsException(400,"Candidate Status Not found");
			}
		}
		else
		{
			throw new LmsException(400,"Candidate Status Not found");
		}
		
	}

	@Override
	public ResponseDTO deleteStatusDataById(String token, int id)
	{
		boolean verify = restTemplate.getForObject("http://localhost:8080/verifyemail/"+token, Boolean.class);
		System.out.println("Value="+verify);
		if(verify)
		{

			Optional<LmsStatus> isUserPresent = statusRespository.findById(id);
			if(isUserPresent.isPresent())
			{
				statusRespository.deleteById(id);
				return new ResponseDTO("Deleted Successfully", HttpStatus.ACCEPTED);
			}
			else
			{
				throw new LmsException(400,"Status of Candidate Not found");
			}
			
		}
		else
		{
			throw new LmsException(400,"Status of Candidate Not found");
		}
		
	}


}
