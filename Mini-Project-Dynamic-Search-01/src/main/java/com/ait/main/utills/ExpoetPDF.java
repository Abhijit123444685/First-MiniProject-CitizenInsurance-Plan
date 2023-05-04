package com.ait.main.utills;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;
import org.springframework.stereotype.Component;

import com.ait.main.entity.CitizenInsurancePlan;
import com.ait.main.service.CititzenPlanService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class ExpoetPDF {
	
	public void exportPdfReport(HttpServletResponse res,List<CitizenInsurancePlan> plan,File f) throws DocumentException, IOException {
		
		Document doc=new Document(PageSize.A4);
		
		PdfWriter instance = PdfWriter.getInstance(doc,res.getOutputStream());
		 
		instance.getInstance(doc, new FileOutputStream(f));
		doc.open();
		
		Paragraph p=new Paragraph("Citizen Plan Info");
		
		doc.add(p);
		
       PdfPTable table=new PdfPTable(6);
		
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		
		for(CitizenInsurancePlan t:plan) {
			table.addCell(String.valueOf(t.getCitizenId()));
			table.addCell(t.getCitizenName());
			table.addCell(t.getPlanName());
			table.addCell(t.getPlanStatus());
			table.addCell(t.getPalnStartDate()+"");
			table.addCell(t.getPlanEndDate()+"");
		}
		
		doc.add(table);
		
		
		
		doc.close();
			
		}

	

}
