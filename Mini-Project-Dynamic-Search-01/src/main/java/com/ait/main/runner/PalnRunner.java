package com.ait.main.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;
import org.springframework.stereotype.Component;

import com.ait.main.entity.CitizenInsurancePlan;
import com.ait.main.repository.CitizenPlanRepo;

@Component
public class PalnRunner implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepo repo;
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		CitizenInsurancePlan c1=new CitizenInsurancePlan();
		c1.setCitizenName("Abhijit");
		c1.setGender("Male");
		c1.setPalnStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setPlanName("Cash");
		c1.setPlanStatus("Aproved");
		c1.setBenifitAmount(100000.00);
		
		CitizenInsurancePlan c2=new CitizenInsurancePlan();
		c2.setCitizenName("Biswajit");
		c2.setGender("Male");
		c2.setPalnStartDate(LocalDate.now());
		//c2.setPlanEndDate(LocalDate.now().plusMonths(6));
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		//c2.setBenifitAmount(100000.00);
		c2.setDeniedReason("salar holder");
		
		CitizenInsurancePlan c3=new CitizenInsurancePlan();
		c3.setCitizenName("Raja");
		c3.setGender("Male");
		c3.setPalnStartDate(LocalDate.now());
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setPlanName("Food");
		c3.setPlanStatus("Aproved");
		c3.setBenifitAmount(500000.00);
		
		
		repo.saveAll(Arrays.asList(c1,c2,c3));
		
	}

}
