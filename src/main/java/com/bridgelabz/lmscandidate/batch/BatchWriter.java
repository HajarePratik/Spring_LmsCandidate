package com.bridgelabz.lmscandidate.batch;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.lmscandidate.dto.LmsCsvHiringDTO;
import com.bridgelabz.lmscandidate.model.LmsHiring;
import com.bridgelabz.lmscandidate.respository.LmsHiringRepository;


@Component
public class BatchWriter implements ItemWriter<LmsCsvHiringDTO> 
{
	@Autowired(required = true)
	ModelMapper modelmapper;
	
	@Autowired
	private LmsHiringRepository hiringRepository;
	
    @Autowired
    public BatchWriter (LmsHiringRepository hiringRepository) {
        this.hiringRepository = hiringRepository;
    }
    
    @Override
    public void write(List<? extends LmsCsvHiringDTO> users) throws Exception
    {
        System.out.println("Data Saved for Users: " + users);
        
        for (LmsCsvHiringDTO user : users) 
        {
			System.out.println(user);
			LmsHiring hiringperson =modelmapper.map(user,LmsHiring.class);
			hiringperson.setCreatorStamp(LocalDate.now());
			hiringRepository.save(hiringperson);
		}
    }
}