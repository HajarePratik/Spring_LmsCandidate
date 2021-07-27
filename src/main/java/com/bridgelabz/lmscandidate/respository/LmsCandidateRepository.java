package com.bridgelabz.lmscandidate.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.lmscandidate.model.LmsCandidate;

@Repository
public interface LmsCandidateRepository extends JpaRepository<LmsCandidate, Integer> {

}
