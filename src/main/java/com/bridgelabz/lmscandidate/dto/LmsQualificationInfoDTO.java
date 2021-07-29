package com.bridgelabz.lmscandidate.dto;

import com.sun.istack.NotNull;

import lombok.Data;

public @Data class LmsQualificationInfoDTO {

	@NotNull
	public boolean diploma;
	@NotNull
	public String degree;
	@NotNull
	public String filed;
	@NotNull
	public String yearOfPassing;
	@NotNull
	public String finalPercentage;
	@NotNull
	public String aggrPercentage;
	@NotNull
	public String enggPercentage;
	@NotNull
	public String finalCertification;
	@NotNull
	public String trainingInstitute;
	@NotNull
	public String trainingDuration;
	@NotNull
	public String course;
}
