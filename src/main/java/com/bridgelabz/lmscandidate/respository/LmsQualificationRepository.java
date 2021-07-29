package com.bridgelabz.lmscandidate.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.lmscandidate.model.LmsQualificationInfo;

public interface LmsQualificationRepository extends JpaRepository<LmsQualificationInfo, Integer> {

}
