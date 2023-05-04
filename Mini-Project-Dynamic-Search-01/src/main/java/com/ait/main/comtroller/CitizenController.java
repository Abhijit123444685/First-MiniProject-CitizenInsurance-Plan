package com.ait.main.comtroller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ait.main.formbinding.CitizenDTO;
import com.ait.main.service.CitizenPlanStatusIMPL;

@Controller
public class CitizenController {
	
	@Autowired
   private CitizenPlanStatusIMPL ser;
	
	@GetMapping("/")
	public String loadIndexPage(Model m) {
		CitizenDTO d=new CitizenDTO();
		m.addAttribute("citizen",d);
		init(m,d);
		
		return "index";
		
	}

	private void init(Model m, CitizenDTO d) {
		
		m.addAttribute("planName",ser.getPlanNames());
		m.addAttribute("planStatus",ser.getPlanStatus());
	}
	
	@PostMapping("/search")
	public String getCitizenData(  CitizenDTO dto, Model m) {
		
		init(m, dto);
		
		m.addAttribute("search",ser.getCitizenData(dto));
		m.addAttribute("citizen",dto);
		
		return "index";
	}
   
	@GetMapping("/excel")
	public void exportExcelReport(HttpServletResponse res) throws IOException {
		  
		 res.setContentType("application/octet-stream");
		 
		 res.addHeader("Content-Disposition","attachment;filename=plans.xls");
		 
		 ser.exportExcel(res);
	}
	@GetMapping("/pdf")
	public void exportPdfReport(HttpServletResponse res) throws IOException {
		  
		 res.setContentType("application/pdf");
		 
		 res.addHeader("Content-Disposition","attachment;filename=plans.pdf");
		 
		 ser.exportPdf(res);
	}
}
