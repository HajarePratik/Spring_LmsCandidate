package com.bridgelabz.lmscandidate.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.lmscandidate.model.LmsHiring;

@Repository
public interface LmsHiringRepository extends JpaRepository<LmsHiring, Integer> {


}
