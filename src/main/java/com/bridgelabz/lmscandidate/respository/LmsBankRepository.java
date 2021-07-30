package com.bridgelabz.lmscandidate.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.lmscandidate.model.LmsBankInfo;

public interface LmsBankRepository extends JpaRepository<LmsBankInfo, Integer> {

}
