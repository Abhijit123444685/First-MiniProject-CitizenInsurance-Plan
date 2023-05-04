package com.ait.main.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ait.main.entity.CitizenInsurancePlan;
import com.ait.main.formbinding.CitizenDTO;
import com.ait.main.repository.CitizenPlanRepo;
import com.ait.main.utills.ExpoetPDF;
import com.ait.main.utills.ExportExcel;
import com.ait.main.utills.SendEmail;
import com.lowagie.text.DocumentException;

@Service
public class CitizenPlanStatusIMPL  implements CititzenPlanService{
	
	@Autowired
	private CitizenPlanRepo repo;
	
	@Autowired
	private ExportExcel excel;
	
	@Autowired
	private ExpoetPDF pdf;
	
	@Autowired
	private SendEmail mail;

	@Override
	public List<String> getPlanNames() {
		
		
		return repo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		
		return repo.getPlanStatus();
	}

	public List<CitizenInsurancePlan> getCitizenData(CitizenDTO dto) {
		CitizenInsurancePlan c=new CitizenInsurancePlan();
		
		if(null!=dto.getPlanName() && !"".equals(dto.getPlanName())) {
			c.setPlanName(dto.getPlanName());
		}
		if(null!=dto.getPlanStatus() && !"".equals(dto.getPlanStatus())) {
			c.setPlanStatus(dto.getPlanStatus());
		}
		
		if(null!=dto.getGender() && !"".equals(dto.getGender())) {
			c.setGender(dto.getGender());
		}
		
		if(null!=dto.getStartDate() && !"".equals(dto.getStartDate())) {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			  //convert String to LocalDate
			 String startDate = dto.getStartDate();
			  LocalDate localDate = LocalDate.parse(startDate, formatter);
			  c.setPalnStartDate(localDate);
		}
		if(null!=dto.getEndDate() && !"".equals(dto.getEndDate())) {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			  //convert String to LocalDate
			 String endDate = dto.getEndDate();
			  LocalDate localDate = LocalDate.parse(endDate, formatter);
			  c.setPlanEndDate(localDate);
		}
		return repo.findAll(Example.of(c));
	}

	public boolean exportPdf(HttpServletResponse response) throws DocumentException, IOException {
		  
          List<CitizenInsurancePlan> findAll = repo.findAll();
          String subject="Test Mail Subject";
          String body="<h1> Test Mail Body<h1>";
          String to="avitewari82@gmail.com";
          
		
	    	pdf.exportPdfReport(response, findAll,new File("plan.pdf"));
	    	
	    	mail.sendMail(subject, body, to,new File("plan.pdf"));
	    	
	    	
		return true;
	}

	public boolean exportExcel(HttpServletResponse response) throws IOException {
		
		List<CitizenInsurancePlan> findAll = repo.findAll();
		String subject="Test Mail Subject";
        String body="<h1> Test Mail Body<h1>";
        String to="avitewari82@gmail.com";
		
		excel.exportExcelReport(response, findAll,new File("plan.xls"));
		mail.sendMail(subject, body, to,new File("plan.xls"));
		
		return true;
	}

}
