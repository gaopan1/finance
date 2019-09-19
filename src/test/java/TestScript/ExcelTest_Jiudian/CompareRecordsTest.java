package TestScript.ExcelTest_Jiudian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
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



public class CompareRecordsTest {
	
	
	// 在支付订单ID 后面打上tag  可以区分支付ID 和支付订单ID
	
	String tag = "AAA";
	
	
	String caseName;
	String pay_sheetName;
	String account_sheetName;
	String result_sheetName;
	String getPayColumnName;
	String getAccountColumnName;
	String sourceTable;
	String destinationTable;
	String getPayBusinessColumnName;
	String getZhifuDingDanID;
	
//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	int zhifu_id_col = 0;
	int zhifu_business_id_col = 0;
	int duizhang_id_col = 0;
	int zhifudingdan_id_col  = 0;
	
	ArrayList<String> zhifu_id_list =  new ArrayList<String>();
	ArrayList<String> zhengxiangduizhang_id_list =  new ArrayList<String>();
	ArrayList<String> common =  new ArrayList<String>();
	ArrayList<String> left_zhifu_id_list =  new ArrayList<String>();
	ArrayList<String> left_zhengxiangduizhang_id_list =  new ArrayList<String>();

	
	
	public CompareRecordsTest(String sourceTable,String destinationTable,String caseName,String pay_sheetName,String getPayColumnName,String getPayBusinessColumnName,String account_sheetName,String getAccountColumnName,String getZhifuDingDanID,String result_sheetName){
		this.sourceTable = sourceTable;
		this.destinationTable = destinationTable;
		this.caseName = caseName;
		this.pay_sheetName = pay_sheetName;
		this.account_sheetName = account_sheetName;
		this.result_sheetName = result_sheetName;
		this.getPayColumnName = getPayColumnName;
		this.getAccountColumnName = getAccountColumnName;
		this.getPayBusinessColumnName = getPayBusinessColumnName;
		this.getZhifuDingDanID = getZhifuDingDanID;
		
	}
	
	@Test
	public void test() throws Exception{
		
	
	
		File file = new File(sourceTable);
		
		if(file.exists()){
			System.out.println("exists----------------");
		}
		
	
        //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
        Dailylog.logInfo("start ----------------------");
        //3.Excel工作表对象
        int index_paysheet = xssfWorkbook.getSheetIndex(pay_sheetName);
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
        
        for(int x = 0; x< colLength;x++){
        	XSSFCell xssfCell = xssfRow.getCell(x);
        	String cellvalue = xssfCell.getStringCellValue();
        	System.out.println("cellvalue is :" + cellvalue);
        	
        	if(cellvalue.equals(getPayColumnName)){
        		zhifu_id_col = x;
        		System.out.println("zhifu_id_col is :" + zhifu_id_col);
        	}
        	
        	if(cellvalue.equals(getPayBusinessColumnName)){
        		zhifu_business_id_col = x;
        		System.out.println("zhifu_business_id_col is : " + zhifu_business_id_col);
        	}
        	
        }
        
        XSSFRow xssfRow1 = null;
        XSSFCell xssfCell1 = null;
        XSSFCell xssfCell2 = null;
        String cellValue1 = null;
        String cellValue2 = null;
        
        for(int y = 1; y<rowLength;y++){
   	
        	xssfRow1  = sheet.getRow(y);
        	
        	xssfCell1 = xssfRow1.getCell(zhifu_id_col);
        	xssfCell2 = xssfRow1.getCell(zhifu_business_id_col);
        	
        	cellValue1 = xssfCell1.getStringCellValue().replace("'", "");
        	cellValue2 = xssfCell2.getStringCellValue().replace("'", "");
        	
        	if(cellValue1.startsWith("5318")){
        		zhifu_id_list.add(cellValue2);
        	}else{
        		zhifu_id_list.add(cellValue1);	
        	} 	
        }
        
        //list中的元素以及元素出现的次数
        
        /*Map<String,Integer> map_test = new HashMap<String,Integer>();
        
        for(int n = 0; n<zhifu_id_list.size();n++){
        	String str = zhifu_id_list.get(n);
        	
        	if(map_test.containsKey(str)){
        		map_test.put(str, map_test.get(str)+1);
        	}else{
        		map_test.put(str, 1);
        	}	
        }
        
        Set<String> set =map_test.keySet();
        
        Iterator<String> it = set.iterator();
        
        while(it.hasNext()){
        	
        	String obj = it.next();
        	int count = map_test.get(obj);
        	if(count >=2){
        		Dailylog.logInfo(obj + ":::::::::" + count);
        	}
        
        	
        }
        */
        
        
        
        
      //3.Excel工作表对象
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
        
        for(int x = 0; x< colLength_zhengxiang;x++){
        	XSSFCell xssfCell = xssfRow_zhengxiang.getCell(x);
        	String cellvalue = xssfCell.getStringCellValue();
        	System.out.println("cellvalue of zhengxiang is :" + cellvalue);
        	
        	if(cellvalue.equals(getAccountColumnName)){
        		duizhang_id_col = x;
        		System.out.println("duizhang_id_col is :" + duizhang_id_col);
        	}
        	
        	if(cellvalue.equals(getZhifuDingDanID)){
        		zhifudingdan_id_col = x;
        		System.out.println("zhifudingdan_id_col is :" + zhifudingdan_id_col);
        	}
        }
        
        XSSFRow xssfRow1_zhengxiang = null;
        XSSFCell xssfCell1_zhengxiang = null;
        XSSFCell xssfCell1_zhifudingdanID = null;
        String cellValue1_zhengxiang = null;
        String cellValue1_zhifudingdanID = null;
        
        for(int y = 1; y<rowLength_zhengxiang;y++){
           	
        	xssfRow1_zhengxiang  = sheet_zhengxiang.getRow(y);
//        	Dailylog.logInfo("  y is :" + y);
        	
        	try{
        		xssfCell1_zhengxiang = xssfRow1_zhengxiang.getCell(duizhang_id_col);
        		xssfCell1_zhifudingdanID = xssfRow1_zhengxiang.getCell(zhifudingdan_id_col);
        	}catch(Exception e){
        		if(e instanceof NullPointerException){
        			break;
        		}
        	}
        	
        	cellValue1_zhengxiang = xssfCell1_zhengxiang.getStringCellValue().replace("'", "");
        	cellValue1_zhifudingdanID = xssfCell1_zhifudingdanID.getStringCellValue().replace("'", "");
        	
//        	Dailylog.logInfo("  cellValue1_zhengxiang is :" + cellValue1_zhengxiang);
        	
        	
        	cellValue1_zhengxiang  = cellValue1_zhengxiang  + tag + cellValue1_zhifudingdanID;
        	
        	zhengxiangduizhang_id_list.add(cellValue1_zhengxiang);
        	
        	
    }
        
//    	ArrayList<String> zhifu_id_list =  new ArrayList<String>();
//    	ArrayList<String> zhengxiangduizhang_id_list =  new ArrayList<String>();
//    	ArrayList<String> common =  new ArrayList<String>();
//    	ArrayList<String> left_zhifu_id_list =  new ArrayList<String>();
//    	ArrayList<String> left_zhengxiangduizhang_id_list =  new ArrayList<String>();
        
        
        if(zhengxiangduizhang_id_list.size() >=zhifu_id_list.size()){
        	for(String str : zhengxiangduizhang_id_list){
        		String str_tag = str;
        		String[] strs = str.split(tag);
        		
        		if(!strs[1].equals("0")){
        			if(zhifu_id_list.contains(strs[1])){
        				common.add(str_tag);
        			}
        		}else{
        			if(zhifu_id_list.contains(strs[0])){
        				common.add(str_tag);
        			}
        		}
        		
        	}
        }else{
        	for(String str : zhifu_id_list){
        		for(int x = 0; x <zhengxiangduizhang_id_list.size(); x++){
        			String[] strr = zhengxiangduizhang_id_list.get(x).split(tag);
        			if(!strr[1].equals("0")){
        				if(str.equals(strr[1])){
        					common.add(str);
        					break;
        				}
        			}else{
        				if(str.equals(strr[0])){
        					common.add(str);
        					break;
        				}
        			}
        		}
        	}
        }

        
       // 从上面得到common结果    要么里面的元素全部是含有tag的  要么里面的元素是不含有标记的
        
        Dailylog.logInfo("common size is :" + common.size());
        
        String firstElement_Common = common.get(0);
        
        if(!firstElement_Common.contains(tag)){
        	
        	//  common 中的元素不包含tag
        	
        	for(int x = 0; x <zhifu_id_list.size();x++){
        		
        		String str = zhifu_id_list.get(x);
        		
        		if(!common.contains(str)){
        			left_zhifu_id_list.add(str);
        		}	
        	}
        	
        	for(String str : zhengxiangduizhang_id_list){
        		String[] strs = str.split(tag);
        		
        		if(!strs[1].equals("0")){
        			if(!common.contains(strs[1])){
        				left_zhengxiangduizhang_id_list.add(str);
        			}
        		}else{
        			if(!common.contains(strs[0])){
        				left_zhengxiangduizhang_id_list.add(str);
        			}
        		}
        		
        	}

        }else{
        	//common 中的元素包含tag   	
        	
        	for(int x = 0; x <zhifu_id_list.size(); x++){
        		
        		String zhifu_str = zhifu_id_list.get(x);
        		
        		boolean flag = false;
        		
        		for(String str : common){
        			String[] strs = str.split(tag);
        			
        			if(!strs[1].equals("0")){
        				if(strs[1].equals(zhifu_str)){
        					flag = true;
        					break;
        				}
        			}else{
        				
        				if(strs[0].equals(zhifu_str)){
        					flag = true;
        					break;
        				}
        				
        			}
        		}
        		
        		if(!flag){
        			left_zhifu_id_list.add(zhifu_str);
        		}		
        	}
        	
        	for(String str : zhengxiangduizhang_id_list){
        		
        		if(!common.contains(str)){
        			left_zhengxiangduizhang_id_list.add(str);
        		}	
        	}

        	
        }

        System.out.println("left of zhifu :" + left_zhifu_id_list.size());
        System.out.println("left of duizhang :" + left_zhengxiangduizhang_id_list.size());
     
 
        writeContent2Excels_Records(destinationTable,left_zhifu_id_list, left_zhengxiangduizhang_id_list,pay_sheetName + "_compareresult",pay_sheetName+" : "+ rowLength,account_sheetName + ": " +rowLength_zhengxiang);

        
		
	}
	
	public void writeContent2Excels_Records(String destinationTable,List<String> left_zhifu_list,List<String> left_duizhang_list,String sheetName,String pay_total,String account_total) throws Exception{
		
		WriterExcelUtil.createNewExcelFile(destinationTable);
		
//		String destination = "C:\\Users\\gaopan\\Desktop\\测试excel\\"+tableName+".xls";
		
		HSSFWorkbook book = null;
		
		
//		createNewExcels(destinationTable);
		
		//自己手动创建没有问题  但是程序创建就会有问题
		
		try{
			//1，创建操作xlsx的对象
			
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
			
			//2，创建sheet
			 			 
			 HSSFSheet sheet = book.createSheet(sheetName);
			 
			 
			 
			//3,操作sheet
			HSSFRow row1 = sheet.createRow(0);
			
			HSSFCell cell = row1.createCell(0);
			
			cell.setCellValue("pay center result");
			
			
			
			HSSFCell cell1 = row1.createCell(1);
			
			 cell1.setCellValue("duizhang_订单ID");
			 
			 HSSFCell cell2 = row1.createCell(2);
			 
			 cell2.setCellValue("duizhang_支付订单ID");
			 
			 
			 
			 
			
			
			 System.out.println("left of zhifu :::::" + left_zhifu_list.size());
		     System.out.println("left of duizhang ::::::" + left_duizhang_list.size());

		 
			
			 if(left_zhifu_list.size() >= left_duizhang_list.size()){
				 int left_zhifu = left_zhifu_list.size();
				 int left_duizhang = left_duizhang_list.size();
				 for(int x =0; x<left_zhifu-left_duizhang;x++){
					 left_duizhang_list.add("");
				 }
			 }else{
				 int left_zhifu = left_zhifu_list.size();
				 int left_duizhang = left_duizhang_list.size();
				 for(int x =0; x<left_duizhang-left_zhifu;x++){
					 left_zhifu_list.add("");
				 }
			 }
			
			Dailylog.logInfo("zhifu list size is : "+ left_zhifu_list.size());
			Dailylog.logInfo("duizhang list size is : "+ left_duizhang_list.size());
			
			for(int t = 1; t<=left_zhifu_list.size();t++){
				row1 = sheet.createRow(t);
				
				cell = row1.createCell(0);
				cell.setCellValue(left_zhifu_list.get(t-1));
				
				
				
				if(left_duizhang_list.get(t-1) != ""){
					cell = row1.createCell(1);
					cell.setCellValue(left_duizhang_list.get(t-1).split(tag)[0]);
					cell = row1.createCell(2);
					cell.setCellValue(left_duizhang_list.get(t-1).split(tag)[1]);
				}else{
					cell = row1.createCell(1);
					cell.setCellValue("");
					cell = row1.createCell(2);
					cell.setCellValue("");
				}
				
				
				
				if(t==left_zhifu_list.size()){
					row1 = sheet.createRow(t+1);
					cell1 = row1.createCell(3);
					cell1.setCellValue(pay_total);
					row1 = sheet.createRow(t+2);
					
					cell1 = row1.createCell(3);
					
					cell1.setCellValue(account_total);
				}
			}


			
			FileOutputStream fout = new FileOutputStream(destinationTable);    

			book.write(fout);   
           
			
			
			fout.close();    
		
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				book.close();
			}catch(Exception e){
				
			}
		}
	
	}

}
