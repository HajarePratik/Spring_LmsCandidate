package com.bridgelabz.lmscandidate.batch;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.bridgelabz.lmscandidate.dto.LmsCsvHiringDTO;

@Component
public class BatchProcessor implements ItemProcessor<LmsCsvHiringDTO, LmsCsvHiringDTO>
{

    @Override
    public LmsCsvHiringDTO process(LmsCsvHiringDTO user) throws Exception
    {
        return user;
    }
}