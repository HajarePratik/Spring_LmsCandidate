package com.bridgelabz.lmscandidate.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.lmscandidate.model.LmsCandidateBatch;



@Repository
public interface LmsBatchRespository extends JpaRepository<LmsCandidateBatch, Integer>
{

}
