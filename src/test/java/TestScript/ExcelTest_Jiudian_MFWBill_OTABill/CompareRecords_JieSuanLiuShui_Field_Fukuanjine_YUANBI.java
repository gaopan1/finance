package TestScript.ExcelTest_Jiudian_MFWBill_OTABill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;

public class CompareRecords_JieSuanLiuShui_Field_Fukuanjine_YUANBI {
	
	
	String sourceFile;
	String destinationFile;
	String otaName;
	
	String mfwBill_sheet;
	String otaBill_sheet;
	
	String ota_dingdanID_mfwBill;
	String fukuanjine_YUANBI_mfwBill;
	String ota_dingdanID_OTABill;
	String jiesuanjia_OTABill;
	
	int ota_dingdanID_mfwBill_index;
	int fukuanjine_YUANBI_mfwBill_index;
	int ota_dingdanID_OTABill_index;
	int jiesuanjia_OTABill_index;
	
	
	Map<String,Double>  mfw_map = new HashMap<String,Double>();
	
	Map<String,Double>  ota_map = new HashMap<String,Double>();
	
	
	
	public CompareRecords_JieSuanLiuShui_Field_Fukuanjine_YUANBI(String sourceFile,
																String destinationFile,
																String otaName,
																String mfwBill_sheet,
																String otaBill_sheet,
																String ota_dingdanID_mfwBill,
																String fukuanjine_YUANBI_mfwBill,
																String ota_dingdanID_OTABill,
																String jiesuanjia_OTABill){
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.otaName = otaName;
		this.mfwBill_sheet = mfwBill_sheet;
		this.otaBill_sheet = otaBill_sheet;
		this.ota_dingdanID_mfwBill = ota_dingdanID_mfwBill;
		this.fukuanjine_YUANBI_mfwBill = fukuanjine_YUANBI_mfwBill;
		this.ota_dingdanID_OTABill = ota_dingdanID_OTABill;
		this.jiesuanjia_OTABill = jiesuanjia_OTABill;
		
	}
	
	
	@Test
	public void test() throws Exception{
		
		
		File file = new File(sourceFile);
		
		if(file.exists()){
			System.out.println("exists");
		}
		
		 //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_mfwSheet = xssfWorkbook.getSheetIndex(mfwBill_sheet);
        Dailylog.logInfo("index mfw sheet is :" + index_mfwSheet);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_mfwSheet);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
		
        
        /*
         * 
         *int ota_dingdanID_mfwBill_index;
		int fukuanjine_YUANBI_mfwBill_index;
         * 
         * 
         * */
		
        
        ota_dingdanID_mfwBill_index = WriterExcelUtil.getIndexOfFields(xssfRow, ota_dingdanID_mfwBill);
        fukuanjine_YUANBI_mfwBill_index =  WriterExcelUtil.getIndexOfFields(xssfRow, fukuanjine_YUANBI_mfwBill);
        
        
        
      
        XSSFRow row = null;

        for(int x = 1; x <= rowLength-1; x++){
        	
        	row = sheet.getRow(x);
        	
        	String ota_dingdanID_mfwBill_Str= "";
        	String fukuanjine_YUANBI_mfwBill_Str = "";
              
             XSSFCell cell = null;
              
              for(int y = 0; y<colLength;y++){
            	  
            	  cell = row.getCell(y);
            	  
            	  if(y == ota_dingdanID_mfwBill_index){
            		  ota_dingdanID_mfwBill_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == fukuanjine_YUANBI_mfwBill_index){
            		  fukuanjine_YUANBI_mfwBill_Str = WriterExcelUtil.getCellValue(cell);
            	  }
              }
              
             double dou_fukuanjine_YUANBI_mfwBill = Double.parseDouble(fukuanjine_YUANBI_mfwBill_Str);
             
             dou_fukuanjine_YUANBI_mfwBill = WriterExcelUtil.getValidNumbersOfDouble(dou_fukuanjine_YUANBI_mfwBill, "2.11");
            
              
             Dailylog.logInfo("ota_dingdanID_mfwBill_Str is :" + ota_dingdanID_mfwBill_Str);
             Dailylog.logInfo("fukuanjine_YUANBI_mfwBill_Str is :" + fukuanjine_YUANBI_mfwBill_Str);
             
             if(mfw_map.containsKey(ota_dingdanID_mfwBill_Str)){
            	 double value = mfw_map.get(ota_dingdanID_mfwBill_Str);
            	 
            	 value = value + dou_fukuanjine_YUANBI_mfwBill;
            	 
            	 mfw_map.put(ota_dingdanID_mfwBill_Str, value);
            	 
            	 
             }else{ 
            	 
            	 mfw_map.put(ota_dingdanID_mfwBill_Str, dou_fukuanjine_YUANBI_mfwBill);
             }
             
        }
             
             
        
             //2.Excel工作薄对象
             XSSFWorkbook xssfWorkbook_ota = new XSSFWorkbook(new FileInputStream(file));
             //3.Excel工作表对象
             int index_otaSheet = xssfWorkbook_ota.getSheetIndex(otaBill_sheet);
             Dailylog.logInfo("index ota sheet is :" + index_otaSheet + "otaBill_sheet IS :" + otaBill_sheet);
             XSSFSheet sheet_ota = xssfWorkbook_ota.getSheetAt(index_otaSheet);
             //总行数
             int rowLength1 = sheet_ota.getLastRowNum()+1;
             System.out.println("row length1 is :" + rowLength1);
             //4.得到Excel工作表的行
             XSSFRow xssfRow_ota = sheet_ota.getRow(0);
             //总列数
             int colLength_ota = xssfRow_ota.getLastCellNum();
             System.out.println("colLength_ota is :" + colLength_ota); 
             
             /**
              * int ota_dingdanID_OTABill_index;
				int jiesuanjia_OTABill_index;
              */
             
             ota_dingdanID_OTABill_index = WriterExcelUtil.getIndexOfFields(xssfRow_ota, ota_dingdanID_OTABill);
             jiesuanjia_OTABill_index =  WriterExcelUtil.getIndexOfFields(xssfRow_ota, jiesuanjia_OTABill);
             
             Dailylog.logInfo("ota_dingdanID_OTABill_index is :" + ota_dingdanID_OTABill_index);
             Dailylog.logInfo("jiesuanjia_OTABill_index is :" + jiesuanjia_OTABill_index);
             
             XSSFRow row_ota = null;

             for(int x = 1; x <= rowLength1-1; x++){
             	
            	 row_ota = sheet_ota.getRow(x);
             	
             	
            	 String ota_dingdanID_OTABill_Str= "";
             	String jiesuanjia_OTABill_Str = "";
                   
                 XSSFCell cell = null;
                 
                 for(int y = 0; y<colLength_ota;y++){
                	 
                	 cell = row_ota.getCell(y);
                	 
                	  if(y == ota_dingdanID_OTABill_index){
                	
                		  ota_dingdanID_OTABill_Str = WriterExcelUtil.getCellValue(cell,"0");
                	  }else if(y == jiesuanjia_OTABill_index){
                		  jiesuanjia_OTABill_Str = WriterExcelUtil.getCellValue(cell);
                	  }
                 }
                 
                 Dailylog.logInfo("ota_dingdanID_OTABill_Str is :" + ota_dingdanID_OTABill_Str + "x is :" + x);
                 Dailylog.logInfo("jiesuanjia_OTABill_Str is :" + jiesuanjia_OTABill_Str + "x is :" + x);
                 
             
                 
                 double dou_jiesuanjia_OTABill = Double.parseDouble(jiesuanjia_OTABill_Str);
                 
                 dou_jiesuanjia_OTABill = WriterExcelUtil.getValidNumbersOfDouble(dou_jiesuanjia_OTABill, "2.11");
                
                 
                 if(ota_map.containsKey(ota_dingdanID_OTABill_Str)){
                	 
                	 double value = ota_map.get(ota_dingdanID_OTABill_Str);
                	 
                	 value = value + dou_jiesuanjia_OTABill;
                	 
                	 ota_map.put(ota_dingdanID_OTABill_Str, value);
                	 
                	 
                 }else{
                	 ota_map.put(ota_dingdanID_OTABill_Str, dou_jiesuanjia_OTABill);
                 }
             }
             
             Dailylog.logInfo("mfw map size is :" + mfw_map.size());
             Dailylog.logInfo("ota map size is :" + ota_map.size());
             
             Set<String> mfw_set = mfw_map.keySet();
             
             Set<String> ota_set = ota_map.keySet();
             
             Set<String> commonSet = new HashSet<String>();
             
             if(mfw_set.size() >= ota_set.size()){
            	 
            	 for(String str : mfw_set){
            		 if(ota_set.contains(str)){
            			 commonSet.add(str);
            		 }
            	 }
            	 
             }else{
            	 
            	 for(String str : ota_set){
            		 if(mfw_set.contains(str)){
            			 commonSet.add(str);
            		 }
            	 }
            	 
             }
             
             Dailylog.logInfo("commmonSet size is :" + commonSet.size());
             
             
             List<String> mfw_left = new ArrayList<String>();
             List<String> ota_left = new ArrayList<String>();
             
             
             for(String str : mfw_set){
            	 
            	 if(!commonSet.contains(str)){
            		 mfw_left.add(str);
            	 } 
             }
             
             for(String str : ota_set){
            	 if(!commonSet.contains(str)){
            		 ota_left.add(str);
            	 }
             }   
        
        
        List<String> firstRowNameList = new ArrayList<String>();
        
        firstRowNameList.add("mfw账单中没有的ota订单");
        firstRowNameList.add("ota账单中没有的ota订单");
       
 
        writeContent2Excels_Contents(destinationFile,"记录数的对比",firstRowNameList,mfw_left,ota_left);
        
	
	}
	
	
	
public void writeContent2Excels_Contents(String destinationTable,String sheetName,List<String> firstRowNames,List<String> mfw_left,List<String> ota_left){
		
		
		WriterExcelUtil.createNewExcelFile(destinationTable);

		HSSFWorkbook book = null;
		
		try{
			
			File file = new File(destinationTable);
			
			FileInputStream fis = new FileInputStream(file);
			
			book = new HSSFWorkbook(fis);
			
			int sheetNums = book.getNumberOfSheets();
			
			for(int m =0 ; m< sheetNums;m++){
				String temp_sheetName = book.getSheetName(m);
				if(temp_sheetName.equals(sheetName)){
					book.removeSheetAt(m);
					break;
				}
			}
			//创建sheet
			HSSFSheet sheet = book.createSheet(sheetName);
			
			
			//给标题行赋值
			HSSFRow firstRow = sheet.createRow(0);
		
			HSSFCell cell = null;
			for(int x = 0; x< firstRowNames.size(); x++){
				
				cell = firstRow.createCell(x);
				
				cell.setCellValue(firstRowNames.get(x));
				
			}
			
			
			// 开始往表里写入内容
			
			
			if(mfw_left.size()>ota_left.size()){
				int len = mfw_left.size()-ota_left.size();
				
				for(int x = 0; x<len; x++){
					
					ota_left.add("");
					
				}
				
			}else{
				int len = ota_left.size()-mfw_left.size();
				
				for(int x = 0; x<len; x++){
					
					mfw_left.add("");
					
				}
			}
			
			HSSFRow row1 = null;
			
			
			for(int x = 1; x <=mfw_left.size(); x++){
				
				row1 = sheet.createRow(x);
				HSSFCell cell1 = row1.createCell(0);
				HSSFCell cell2 = row1.createCell(1);
				
				
				cell1.setCellValue(mfw_left.get(x-1));
				cell2.setCellValue(ota_left.get(x-1));
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			
			book.write(fos);
			
			fos.close();
			book.close();
	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
