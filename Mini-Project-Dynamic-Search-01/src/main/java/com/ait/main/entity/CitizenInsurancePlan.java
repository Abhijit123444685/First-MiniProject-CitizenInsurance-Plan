package com.ait.main.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Data
public class CitizenInsurancePlan {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate palnStartDate;
	private LocalDate planEndDate;
	private Double benifitAmount;
	private String deniedReason;
	

}
