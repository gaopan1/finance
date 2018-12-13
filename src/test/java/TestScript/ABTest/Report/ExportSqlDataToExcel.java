package TestScript.ABTest.Report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.SQLHelper;
import CommonFunction.WriterExcelUtil;

public class ExportSqlDataToExcel {
	
	
	String querySql = "select * from abtestresult_layer2";
	
	String destinationTable = "D:\\ABTestReport\\abtestReport_正交.xlsx";
	
	String sheetName="result1";
	
	SQLHelper helper = new SQLHelper();
	
	String[] queryParameters = {};
	
	@Test
	public void test(){

		ResultSet rs = helper.executeQuery(querySql, queryParameters);
		
		createNewExcelFile(destinationTable);
		
		XSSFWorkbook book = null;
		FileInputStream fis = null;
		
		File file = new File(destinationTable);
		
		try{
			fis = new FileInputStream(file);
			
			book = new XSSFWorkbook(fis);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		int sheetNums = book.getNumberOfSheets();
		
		for(int m =0 ; m< sheetNums;m++){
			String temp_sheetName = book.getSheetName(m);
			if(temp_sheetName.equals(sheetName)){
				book.removeSheetAt(m);
				break;
			}
		}
		//创建sheet
		XSSFSheet sheet = book.createSheet(sheetName);
		
		
		//给标题行赋值
		XSSFRow firstRow = sheet.createRow(0);
	
		XSSFRow row = null;
		XSSFCell cell = null;
		
		List<String> firstRowNames = new ArrayList<String>();
		
		firstRowNames.add("udid");
		firstRowNames.add("layerid");
		firstRowNames.add("policyid");
		firstRowNames.add("version");
		firstRowNames.add("hit");
		
		for(int x = 0; x< firstRowNames.size(); x++){
			
			cell = firstRow.createCell(x);
			
			cell.setCellValue(firstRowNames.get(x));
			
		}
		
		int rowNum = 1;

		try {
			while(rs.next()){
				
				row = sheet.createRow(rowNum);
				
				cell = row.createCell(0);
				cell.setCellValue(rs.getString(2));
				cell = row.createCell(1);
				cell.setCellValue(rs.getString(3));
				cell = row.createCell(2);
				cell.setCellValue(rs.getString(4));
				cell = row.createCell(3);
				cell.setCellValue(rs.getString(5));
				cell = row.createCell(4);
				cell.setCellValue(rs.getString(6));
				
				rowNum++;
			
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			
			book.write(fos);
			
			fos.close();
			book.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	public void createNewExcelFile(String filePath){

		File file = new File(filePath);
		
		if(!file.exists()){
			XSSFWorkbook book = new XSSFWorkbook();
			
			FileOutputStream fos = null;		
			
			try {
				fos = new FileOutputStream(file);
				book.write(fos);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(fos != null){
						fos.close();
					}	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

}
