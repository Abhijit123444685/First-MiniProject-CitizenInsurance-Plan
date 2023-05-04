package com.ait.main.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ait.main.entity.CitizenInsurancePlan;
import com.ait.main.formbinding.CitizenDTO;
import com.lowagie.text.DocumentException;

@Service
public interface CititzenPlanService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenInsurancePlan> getCitizenData(CitizenDTO dto);
	
	public boolean exportPdf(HttpServletResponse response)throws DocumentException, IOException;
	
	public boolean exportExcel(HttpServletResponse response) throws IOException;
	
	

}
