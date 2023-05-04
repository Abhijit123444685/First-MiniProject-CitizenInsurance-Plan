package com.ait.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ait.main.entity.CitizenInsurancePlan;


@Repository
public interface CitizenPlanRepo extends JpaRepository<CitizenInsurancePlan, Integer> {

	@Query("select distinct(planName) from CitizenInsurancePlan")
	public List<String> getPlanName();
	
	
	@Query("select distinct(planStatus) from CitizenInsurancePlan")
	public List<String> getPlanStatus();
	
	
	
	
	
}
