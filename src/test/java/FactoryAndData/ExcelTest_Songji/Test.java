package FactoryAndData.ExcelTest_Songji;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log.output.FileOutputLogTarget;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String destination = "C:\\Users\\gaopan\\Desktop\\测试excel\\abcde.xls";
		
		HSSFWorkbook hssfWorkbook = null;
		
		
		File file = new File(destination);
		
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			file.delete();
		}
		
		try{
			//1，创建操作xlsx的对象
			
			 hssfWorkbook = new HSSFWorkbook();
			
			//2，创建sheet
			 int sheetNumber = hssfWorkbook.getNumberOfSheets();
			 
			 System.out.println("sheet number is :" + sheetNumber);
			 
			 HSSFSheet sheet = hssfWorkbook.createSheet("test1");
			 
			 HSSFSheet sheet1 = hssfWorkbook.createSheet("test2");
			 
			 
			//3,操作sheet
			HSSFRow row1 = sheet.createRow(0);
			
			HSSFCell cell = row1.createCell(0);
			
			cell.setCellValue("pay center result");
			
			
			HSSFRow row2 = sheet1.createRow(0);
			HSSFCell cell1 = row2.createCell(0);
		
			cell1.setCellValue("test2");
			
			FileOutputStream fos = new FileOutputStream(file);
			
			hssfWorkbook.write(fos);
			
			fos.close();
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
