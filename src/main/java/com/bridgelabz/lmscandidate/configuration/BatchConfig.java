package com.bridgelabz.lmscandidate.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.bridgelabz.lmscandidate.dto.LmsCsvHiringDTO;


@Configuration
@EnableBatchProcessing
public class BatchConfig 
{
	@Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<LmsCsvHiringDTO> itemReader,
                   ItemProcessor<LmsCsvHiringDTO, LmsCsvHiringDTO> itemProcessor,
                   ItemWriter<LmsCsvHiringDTO> itemWriter
    ) {

        Step step = stepBuilderFactory.get("ETL-file-load")
                .<LmsCsvHiringDTO, LmsCsvHiringDTO>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public FlatFileItemReader<LmsCsvHiringDTO> itemReader() {

        FlatFileItemReader<LmsCsvHiringDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource("C:\\Users\\InfoGalaxy\\Spring Boot\\Spring_Boot_LMSCandidate\\candidate_data.csv"));
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<LmsCsvHiringDTO> lineMapper() 
    {

        DefaultLineMapper<LmsCsvHiringDTO> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","firstName", "middleName", "lastName","email",
        		"mobileNum","hiredCity","parentName","parentMobile","temporaryAddress","parentOccupation","parentAnnualSalary","permanentAddress");
        BeanWrapperFieldSetMapper<LmsCsvHiringDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(LmsCsvHiringDTO.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

}

