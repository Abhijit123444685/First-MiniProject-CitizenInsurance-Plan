package com.ait.main.utills;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.ait.main.entity.CitizenInsurancePlan;


@Component
public class ExportExcel {
	public void exportExcelReport(HttpServletResponse response,List<CitizenInsurancePlan> plan,File f) throws IOException {
		
		
		 Workbook wk=new HSSFWorkbook();
		 Sheet createSheet = wk.createSheet();
		 
		 Row headerRow = createSheet.createRow(0);
		 
		 headerRow.createCell(0).setCellValue("Id");
		 headerRow.createCell(1).setCellValue("Citizen Name");
		 headerRow.createCell(2).setCellValue("Plan Name");
		 headerRow.createCell(3).setCellValue("Plan Status");
		 headerRow.createCell(4).setCellValue("Plan Start Date");
		 headerRow.createCell(5).setCellValue("Plan End Date");
		 
		 headerRow.createCell(6).setCellValue("Benifit Amout");
		 
		 int index=1;
		 for(CitizenInsurancePlan p:plan) {
			 Row r1 = createSheet.createRow(index);
			 r1.createCell(0).setCellValue(p.getCitizenId());
			 r1.createCell(1).setCellValue(p.getCitizenName());
			 r1.createCell(2).setCellValue(p.getPlanName());
			 r1.createCell(3).setCellValue(p.getPlanStatus());
			 r1.createCell(4).setCellValue(p.getPalnStartDate());
			 r1.createCell(5).setCellValue(p.getPlanEndDate());
			 if(null!=p.getBenifitAmount()) {
			 r1.createCell(6).setCellValue(p.getBenifitAmount());
			 }else {
				 r1.createCell(6).setCellValue("N/A");
			 }
			 index++;
		 }
		 
		 FileOutputStream fis=new FileOutputStream(f);
		 
		 wk.write(fis);
		 
		 ServletOutputStream outputStream = response.getOutputStream();
		 wk.write(outputStream);
		 
		 wk.close();
		 
			
		}
}
