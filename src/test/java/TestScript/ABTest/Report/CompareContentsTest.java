package TestScript.ABTest.Report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
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

public class CompareContentsTest {

	
	String sourceFile = "D:\\ABTestReport\\abtestReport.xlsx";
	String destinationFile = "D:\\ABTestReport\\compareResult.xls";
	
	String pay_sheetName="result1";
	String account_sheetName="result2";
	
	String pay_udid = "udid";
	String pay_layerid = "layerid";
	String pay_policyid = "policyid";
	String pay_version = "version";
	String pay_hit = "hit";
	
	
	String account_udid = "udid";
	String account_layerid = "layerid";
	String account_policyid = "policyid";
	String account_version = "version";
	String account_hit = "hit";
	
	
	int index_pay_udid;
	int index_pay_layerid;
	int index_pay_policyid;
	int index_pay_version;
	int index_pay_hit;
	
	
	int index_account_udid;
	int index_account_layerid;
	int index_account_policyid;
	int index_account_version;
	int index_account_hit;
	
	
	
	
	public Map<String,List<String>> map_pay = new HashMap<String,List<String>>();
	
	
	public Map<String,List<String>> map_account = new HashMap<String,List<String>>();

	
	List<String> resultList = new ArrayList<String>();
	
	

	@Test
	public void test() throws Exception{
		
		File file = new File(sourceFile);
		
		if(file.exists()){
			System.out.println("exists");
		}
		
		 //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_paysheet = xssfWorkbook.getSheetIndex(pay_sheetName);
        	System.out.println("sheet name is :" + pay_sheetName);
        Dailylog.logInfo("index paysheet is :" + index_paysheet);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_paysheet);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
        
        // 获取订单号 也就是支付id的column的号码zhifu_id_col
        
        index_pay_udid = WriterExcelUtil.getIndexOfFields(xssfRow, pay_udid);
        index_pay_layerid = WriterExcelUtil.getIndexOfFields(xssfRow, pay_layerid);
        index_pay_policyid = WriterExcelUtil.getIndexOfFields(xssfRow, pay_policyid);
        index_pay_version = WriterExcelUtil.getIndexOfFields(xssfRow, pay_version);
        index_pay_hit = WriterExcelUtil.getIndexOfFields(xssfRow, pay_hit);
    
        
        String pay_udid_Str = "";
        String pay_layerid_Str = "";
        String pay_policyid_Str = "";
        String pay_version_Str = "";
        String pay_hit_Str = "";
        
        XSSFRow row = null;
        
        for(int x = 1; x <= rowLength-1;x++){
        	
        	row = sheet.getRow(x);
        	
        	List<String> list = null;
            
        	for(int y =0 ;y<colLength;y++){
        		
        		list = new ArrayList<String>();
        		
        		XSSFCell xssfCell = row.getCell(y);
        		
        		if(y == index_pay_udid){
        			pay_udid_Str = WriterExcelUtil.getCellValue(xssfCell);
        			Dailylog.logInfo("pay_udid_Str is :" + pay_udid_Str);
        		}else if(y == index_pay_layerid){
        			pay_layerid_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == index_pay_policyid){
        			pay_policyid_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == index_pay_version){
        			pay_version_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == index_pay_hit){
        			pay_hit_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}
        	}
        	
        	list.add(pay_layerid_Str);
        	list.add(pay_policyid_Str);
        	list.add(pay_version_Str);
        	list.add(pay_hit_Str);
        	
        	map_pay.put(pay_udid_Str, list); 	
        }
       
        

        
        // 关联第二张sheet
        
        int index_accountsheet = xssfWorkbook.getSheetIndex(account_sheetName);
        Dailylog.logInfo("index account is :" + index_accountsheet);
        XSSFSheet sheet_zhengxiang = xssfWorkbook.getSheetAt(index_accountsheet);
        //总行数
        int rowLength_zhengxiang = sheet_zhengxiang.getLastRowNum()+1;
        System.out.println("row length of rowLength_zhengxiang is :" + rowLength_zhengxiang);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_zhengxiang = sheet_zhengxiang.getRow(0);
        //总列数
        int colLength_zhengxiang = xssfRow_zhengxiang.getLastCellNum();
        System.out.println("colLength_zhengxiang is :" + colLength_zhengxiang);
        
        // 获取支付id的列号码 duizhang_id_col
        
        index_account_udid = WriterExcelUtil.getIndexOfFields(xssfRow, account_udid);
        index_account_layerid = WriterExcelUtil.getIndexOfFields(xssfRow, account_layerid);
        index_account_policyid = WriterExcelUtil.getIndexOfFields(xssfRow, account_policyid);
        index_account_version = WriterExcelUtil.getIndexOfFields(xssfRow, account_version);
        index_account_hit = WriterExcelUtil.getIndexOfFields(xssfRow, account_hit);
    
        
        String account_udid_Str = "";
        String account_layerid_Str = "";
        String account_policyid_Str = "";
        String account_version_Str = "";
        String account_hit_Str = "";
        
        XSSFRow row1 = null;
        
        for(int x = 1; x <= rowLength_zhengxiang-1;x++){
        	
        	row1 = sheet_zhengxiang.getRow(x);
        	
        	List<String> list = null;
            
        	for(int y =0 ;y<colLength;y++){
        		
        		list = new ArrayList<String>();
        		
        		XSSFCell xssfCell = row1.getCell(y);
        		
        		if(y == index_account_udid){
        			account_udid_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == index_account_layerid){
        			account_layerid_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == index_account_policyid){
        			account_policyid_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == index_account_version){
        			account_version_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == index_account_hit){
        			account_hit_Str = WriterExcelUtil.getCellValue(xssfCell);
        		}
        	}
        	
        	list.add(account_layerid_Str);
        	list.add(account_policyid_Str);
        	list.add(account_version_Str);
        	list.add(account_hit_Str);
        	
        	map_account.put(account_udid_Str, list); 	
        }
        
        System.out.println("row length pay is :" + rowLength);
        System.out.println("row length account is :" + rowLength_zhengxiang);
        
        System.out.println("map_pay size is ：" + map_pay.size());
        System.out.println("map_account size is ：" + map_account.size());
      
        Set<String> set_pay = map_pay.keySet();
        Dailylog.logInfo("set_pay size is :" + set_pay.size());
        Set<String> set_account = map_account.keySet();
        Dailylog.logInfo("set_account size is :" + set_account.size());
        
        
        Set<String> common = new HashSet<>();
        
        if(set_pay.size() >= set_account.size()){
        	for(String str : set_pay){
        		if(set_account.contains(str)){
        			common.add(str);
        		}
        	}
        }else{
        	for(String str : set_account){
//        		Dailylog.logInfo("str is :" + str);
        		if(set_pay.contains(str)){
        			common.add(str);
        			
        		}
        	}	
        }
      
        
        
        
        Dailylog.logInfo("common size is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: "+ common.size());
        
        Iterator<String> it = common.iterator();
        
        List<String> list_pay = null;
        List<String> list_account = null;
        
        while(it.hasNext()){
        	
        	String id = it.next();
        	
        	list_pay = map_pay.get(id);
        	
        	list_account = map_account.get(id);
        	
        	String temp_pay = "";
        	
        	String temp_account = "";
        	
        	for(int x =0; x<list_pay.size(); x++){
        		
        		temp_pay = list_pay.get(x);
        		temp_account = list_account.get(x);
        		
        		
        		if(!temp_pay.equals(temp_account)){
        			
        			resultList.add(id);
        			
        			break;
        		}
        		
        	}
        }  
  
        Dailylog.logInfo("result list size is :" + resultList.size());
        
        
        List<String> firstRowNames = new ArrayList<String>();
        
        firstRowNames.add("id");
        
        writeContent2Excels_Contents(destinationFile,"compareResult",firstRowNames,resultList);
  
	}
	
	
	public void writeContent2Excels_Contents(String destinationTable,String sheetName,List<String> firstRowNames,List<String> resultList){
		
		
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
			HSSFCell cell1 = null;
			
			
			for(int x = 1; x<=resultList.size(); x++){
				
				row = sheet.createRow(x);
				
				cell1 = row.createCell(0);
					
				cell1.setCellValue(resultList.get(x-1));	
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
