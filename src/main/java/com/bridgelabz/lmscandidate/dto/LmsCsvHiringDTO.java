package com.bridgelabz.lmscandidate.dto;

import java.time.LocalDate;


import lombok.Data;

@Data
public class LmsCsvHiringDTO {

		private Integer id;
		private String firstName;
		private String middleName;
		private String lastName;
		private String email;
		private String mobileNum;
		private String hiredcity;
		private String parentName;
		private String parentMobile;
		private String temporaryAddress;
		private String parentOccupation;
		private String parentAnnualSalary;
		private String permanentAddress;
		private LocalDate creatorStamp;
		private LocalDate updateStamp;

	
}
