package TestScript.ExcelTest_Jiudian_EcouponSplitting.useScenery;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

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

public class CompareRecordS {
	
	String sourceFile;
	String destinationFile;
	
	String sheet_butiechaifen;
	String mfwid_butiechaifen;
	String useScenery_butiechaifen;
	String useScenery_Detail_butiechaifen;
	
	String sheet_youhuiquanCenter;
	String mfwid_youhuiquanCenter;
	String useScenery_youhuiquanCenter;
	String useScenery_Detail_youhuiquanCenter;
	
	
	int index_mfwid_butiechaifen;
	int index_useScenery_butiechaifen;
	
	int index_mfwid_youhuiquanCenter;
	int index_useScenery_youhuiquanCenter;
	
	List<String> butiechaifen_list = new ArrayList<String>();
	
	List<String> youhuiquancenter_list = new ArrayList<String>();
	
	List<String> common = new ArrayList<String>();
	
	
	List<String> left_butiechaifen = new ArrayList<String>();
	
	List<String> left_youhuiquanCenter = new ArrayList<String>();
	
	public CompareRecordS(String sourceFile,
						  String destinationFile,
						  
						  String sheet_butiechaifen,
						  String mfwid_butiechaifen,
						  String useScenery_butiechaifen,
						  String useScenery_Detail_butiechaifen,
						 
						  String sheet_youhuiquanCenter,
						  String mfwid_youhuiquanCenter,
						  String useScenery_youhuiquanCenter,
						  String useScenery_Detail_youhuiquanCenter){
		
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		
		
		this.sheet_butiechaifen = sheet_butiechaifen;
		this.mfwid_butiechaifen = mfwid_butiechaifen;
		this.useScenery_butiechaifen = useScenery_butiechaifen;
		this.useScenery_Detail_butiechaifen =useScenery_Detail_butiechaifen;
		
		
		this.sheet_youhuiquanCenter = sheet_youhuiquanCenter;
		this.mfwid_youhuiquanCenter = mfwid_youhuiquanCenter;
		this.useScenery_youhuiquanCenter = useScenery_youhuiquanCenter;
		this.useScenery_Detail_butiechaifen = useScenery_Detail_butiechaifen;
		
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
        int index_butiechaifen = xssfWorkbook.getSheetIndex(sheet_butiechaifen);
        Dailylog.logInfo("index butiechaifen is :" + index_butiechaifen);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_butiechaifen);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
		
		
        
        index_mfwid_butiechaifen = WriterExcelUtil.getIndexOfFields(xssfRow, mfwid_butiechaifen);
        index_useScenery_butiechaifen = WriterExcelUtil.getIndexOfFields(xssfRow, useScenery_butiechaifen);
        
        XSSFRow butiechaifenRow = null;
        
        
        for(int x =1; x<=rowLength-1;x++){
        	
        	
        	butiechaifenRow = sheet.getRow(x);
        	
        	String mfwid_butiechaifen_Str = "";
        	String useScenery_butiechaifen_Str = "";
        	
        	
        	XSSFCell butiechaifenCell = null;
        	
        	 for(int y = 0; y<colLength; y++){
        		 
        		 butiechaifenCell = butiechaifenRow.getCell(y);
        		 
        		 if(y == index_mfwid_butiechaifen){
        			 mfwid_butiechaifen_Str = WriterExcelUtil.getCellValue(butiechaifenCell);
        		 }else if(y == index_useScenery_butiechaifen){
        			 useScenery_butiechaifen_Str = WriterExcelUtil.getCellValue(butiechaifenCell).trim();
        		 }
        		 
        	 }
        	 
        	 if(useScenery_butiechaifen_Str.equals(useScenery_Detail_butiechaifen)){
        		 butiechaifen_list.add(mfwid_butiechaifen_Str);
        	 }
        }
		
        
        //解析第二个sheet
        
        //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook_center = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_youhuiquanCenter = xssfWorkbook_center.getSheetIndex(sheet_youhuiquanCenter);
        Dailylog.logInfo("index youhuiquanCenter is :" + index_youhuiquanCenter);
        XSSFSheet sheet_youhuiquanCenter = xssfWorkbook_center.getSheetAt(index_youhuiquanCenter);
        //总行数
        int rowLength_youhuiquanCenter = sheet_youhuiquanCenter.getLastRowNum()+1;
        System.out.println("row length of youhuiquanCenter is :" + rowLength_youhuiquanCenter);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_youhuiquanCenter = sheet_youhuiquanCenter.getRow(0);
        //总列数
        int colLength_youhuiquanCenter = xssfRow_youhuiquanCenter.getLastCellNum();
        System.out.println("colLength of youhuiquanCenter is :" + colLength_youhuiquanCenter);
        
        
        
        index_mfwid_youhuiquanCenter = WriterExcelUtil.getIndexOfFields(xssfRow_youhuiquanCenter, mfwid_youhuiquanCenter);
        index_useScenery_youhuiquanCenter = WriterExcelUtil.getIndexOfFields(xssfRow_youhuiquanCenter, useScenery_youhuiquanCenter);
        
        XSSFRow youhuiquanCenter = null;
        
        
        for(int x = 1; x<=rowLength_youhuiquanCenter-1; x++){
        	
        	youhuiquanCenter = sheet_youhuiquanCenter.getRow(x);
        	
        	String mfwid_youhuiquanCenter_Str= "";
        	String useScenery_youhuiquanCenter_Str = "";
        	
        	XSSFCell youhuiquanCenterCell = null;
        	
        	 for(int y = 0; y<colLength_youhuiquanCenter; y++){
        		 
        		 youhuiquanCenterCell = youhuiquanCenter.getCell(y);
        		 
        		 if(y == index_mfwid_youhuiquanCenter){
        			 
        			 mfwid_youhuiquanCenter_Str = WriterExcelUtil.getCellValue(youhuiquanCenterCell);
        			 
        		 }else if(y == index_useScenery_youhuiquanCenter){
        			 useScenery_youhuiquanCenter_Str = WriterExcelUtil.getCellValue(youhuiquanCenterCell);
        		 }
	 
        	 }
        	
        	 if(useScenery_youhuiquanCenter_Str.equals(useScenery_Detail_youhuiquanCenter)){
        		 youhuiquancenter_list.add(useScenery_youhuiquanCenter_Str);
        	 }
        }
        
        
        Dailylog.logInfo("butiechaifen_list size is " + butiechaifen_list.size());
        Dailylog.logInfo("youhuiquancenter_list size is " + youhuiquancenter_list.size());
        
        
       if(butiechaifen_list.size()>=youhuiquancenter_list.size()){
    	   
    	   for(int x = 0; x <butiechaifen_list.size(); x++){
    		   
    		   String temp = butiechaifen_list.get(x);
    		   
    		   if(youhuiquancenter_list.contains(temp)){
    			   common.add(temp);
    		   }  
    	   }	   
       }else{
    	   
    	   for(int x = 0; x<youhuiquancenter_list.size(); x++){
    		   
    		   String temp = youhuiquancenter_list.get(x);
    		   
    		   if(butiechaifen_list.contains(temp)){
    			   common.add(temp);
    		   }		   
    	   }
       }
        
        Dailylog.logInfo("common size is ：" + common.size());
        
        
        for(String str : butiechaifen_list){
        	
        	if(!common.contains(str)){
        		
        		left_butiechaifen.add(str);
        	}	
        }
        
        for(String str : youhuiquancenter_list){
        	
        	if(!common.contains(str)){
        		left_youhuiquanCenter.add(str);
        	}	
        }
        
        Dailylog.logInfo("left_butiechaifen size is :" + left_butiechaifen.size());
        
        Dailylog.logInfo("left_youhuiquanCenter size is :" + left_youhuiquanCenter.size());
        
        
        
        //处理一下两个list：  left_butiechaifen    left_youhuiquanCenter ， 使得两个list的size是相同的
        
        
        if(left_butiechaifen.size() >left_youhuiquanCenter.size()){
        	
        	int len = left_butiechaifen.size()-left_youhuiquanCenter.size();
        	
        	
        	for(int x = 1; x<= len; x++){
        		
        		left_youhuiquanCenter.add("");
        		
        	}
        	
        }else if(left_youhuiquanCenter.size() > left_butiechaifen.size()){
        	
        	int len = left_youhuiquanCenter.size() - left_butiechaifen.size();
        	
        	for(int x = 1; x<= len; x++){
        		left_butiechaifen.add("");
        	}
        	
        	
        }
        
        
        List<String> firstRowNames = new ArrayList<String>();
        
        firstRowNames.add("补贴拆分_left");
        
        firstRowNames.add("优惠券_left");
        
		
        writeContent2Excels_Contents(destinationFile,useScenery_Detail_butiechaifen+"_Records",firstRowNames,left_butiechaifen,left_youhuiquanCenter);
		
		
		
	}
	
	public void writeContent2Excels_Contents(String destinationTable,String sheetName,List<String> firstRowNames,List<String> left_butiechaifen,List<String> left_youhuiquanCenter){
		
		
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
			
			HSSFRow row = null;
			
			HSSFCell cell1 =  null;
			
			for(int x = 1; x<=left_butiechaifen.size();x++){
				
				row = sheet.createRow(x);
				
				cell1 = row.createCell(0);
				cell1.setCellValue(left_butiechaifen.get(x-1));
				
				cell1 = row.createCell(1);
				cell1.setCellValue(left_youhuiquanCenter.get(x-1));
				
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
