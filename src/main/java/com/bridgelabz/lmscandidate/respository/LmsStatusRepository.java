package com.bridgelabz.lmscandidate.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.lmscandidate.model.LmsStatus;

@Repository
public interface LmsStatusRepository extends JpaRepository<LmsStatus, Integer>{



}
