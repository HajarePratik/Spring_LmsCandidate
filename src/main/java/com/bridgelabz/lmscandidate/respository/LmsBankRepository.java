package com.bridgelabz.lmscandidate.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.lmscandidate.model.LmsBankInfo;
@Repository
public interface LmsBankRepository extends JpaRepository<LmsBankInfo, Integer> {

}
