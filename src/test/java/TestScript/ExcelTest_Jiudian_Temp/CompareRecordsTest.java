package TestScript.ExcelTest_Jiudian_Temp;

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
	String zhifushishoujine;
	
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

	
	
	public CompareRecordsTest(String sourceTable,
								String destinationTable,
								String caseName,
								String pay_sheetName,
								String getPayColumnName,
								String account_sheetName,
								String getAccountColumnName,
								String zhifushishoujine,
								String result_sheetName){
		this.sourceTable = sourceTable;
		this.destinationTable = destinationTable;
		this.caseName = caseName;
		this.pay_sheetName = pay_sheetName;
		this.account_sheetName = account_sheetName;
		this.result_sheetName = result_sheetName;
		this.getPayColumnName = getPayColumnName;
		this.getAccountColumnName = getAccountColumnName;
		this.zhifushishoujine = zhifushishoujine;
		
	}
	
	@Test
	public void test() throws Exception{
		
	
	
		File file = new File(sourceTable);
		
		if(file.exists()){
			System.out.println("exists");
		}
		
	
        //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
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
        	
        	
        }
        
        XSSFRow xssfRow1 = null;
        XSSFCell xssfCell1 = null;
 
        String cellValue1 = null;
   
        
        for(int y = 1; y<rowLength;y++){
   	
        	xssfRow1  = sheet.getRow(y);
        	
        	xssfCell1 = xssfRow1.getCell(zhifu_id_col);
        	
        	cellValue1 = xssfCell1.getStringCellValue().replace("'", "");
        	
        	
        	zhifu_id_list.add(cellValue1);
        	
        }   
        
        Dailylog.logInfo(zhifu_id_list.toString());
        
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
        	
        	if(cellvalue.equals(zhifushishoujine)){
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
        	
        	if(cellValue1_zhengxiang.equals("51180713010232063")){
        		Dailylog.logInfo("------------------------------------------------------------------------------------------");
        	}
        	
        	
        	cellValue1_zhifudingdanID = WriterExcelUtil.getCellValue(xssfCell1_zhifudingdanID, "0.00");
        	
//        	Dailylog.logInfo("  cellValue1_zhengxiang is :" + cellValue1_zhengxiang);
        	
        	
        	cellValue1_zhengxiang  = cellValue1_zhengxiang  + tag + cellValue1_zhifudingdanID;
        	
        	zhengxiangduizhang_id_list.add(cellValue1_zhengxiang);
        	
        	
    }
        
        
        ArrayList<String>  resultList = new ArrayList<String>();
        

        for(String str : zhengxiangduizhang_id_list){
        	
        	String[] strs = str.split(tag);
        	
        	if(strs[0].equals("51180713010232063")){
        		Dailylog.logInfo("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        	}
        	
        	if(zhifu_id_list.contains(strs[0])){        		
        		resultList.add(str);	
        	}	
        }
  
 
        writeContent2Excels_Records(destinationTable,resultList,"result with 支付实收金额");

        
		
	}
	
	public void writeContent2Excels_Records(String destinationTable,List<String> resultList,String sheetName) throws Exception{
		
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
			
			cell.setCellValue("订单ID");
			
			
			
			HSSFCell cell1 = row1.createCell(1);
			
			 cell1.setCellValue("支付实收金额");
			 
			 for(int x = 1;x <resultList.size(); x++){
				 
				 HSSFRow row = sheet.createRow(x);
				 
				 HSSFCell cell11 = row.createCell(0);
				 cell11.setCellValue(resultList.get(x-1).split(tag)[0]);
				 HSSFCell cell22 = row.createCell(1);
				 cell22.setCellValue(resultList.get(x-1).split(tag)[1]);	 
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
