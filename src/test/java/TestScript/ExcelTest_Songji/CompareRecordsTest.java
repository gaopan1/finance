package TestScript.ExcelTest_Songji;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;



public class CompareRecordsTest {
	
	String caseName;
	String pay_sheetName;
	String account_sheetName;
	String result_sheetName;
	String getPayColumnName;
	String getAccountColumnName;
	String sourceTable;
	String destinationTable;
	
//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	int zhifu_id_col = 0;
	int duizhang_id_col = 0;
	
	ArrayList<String> zhifu_id_list =  new ArrayList<String>();
	ArrayList<String> zhengxiangduizhang_id_list =  new ArrayList<String>();
	ArrayList<String> common =  new ArrayList<String>();
	ArrayList<String> left_zhifu_id_list =  new ArrayList<String>();
	ArrayList<String> left_zhengxiangduizhang_id_list =  new ArrayList<String>();

	
	
	public CompareRecordsTest(String sourceTable,String destinationTable,String caseName,String pay_sheetName,String getPayColumnName,String account_sheetName,String getAccountColumnName,String result_sheetName){
		this.caseName = caseName;
		this.pay_sheetName = pay_sheetName;
		this.account_sheetName = account_sheetName;
		this.result_sheetName = result_sheetName;
		this.getPayColumnName = getPayColumnName;
		this.getAccountColumnName = getAccountColumnName;
		this.sourceTable = sourceTable;
		this.destinationTable = destinationTable;
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
        		break;
        	}
        }
        
        XSSFRow xssfRow1 = null;
        XSSFCell xssfCell1 = null;
        String cellValue1 = null;
        
        for(int y = 1; y<rowLength;y++){
   	
        	xssfRow1  = sheet.getRow(y);
        	
        	xssfCell1 = xssfRow1.getCell(zhifu_id_col);
        	
        	
        	
        	if(getPayColumnName.equals("业务单号")){
        		cellValue1 = xssfCell1.getStringCellValue().replace("'", "");
        		cellValue1 = cellValue1.substring(0, 17);
        	}else{
        		cellValue1 = xssfCell1.getStringCellValue().replace("'", "");
        	}
        	
        	Dailylog.logInfo("cell value is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>:" + cellValue1);
        	zhifu_id_list.add(cellValue1);	
        }

        
        
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
        		break;
        	}
        }
        
        XSSFRow xssfRow1_zhengxiang = null;
        XSSFCell xssfCell1_zhengxiang = null;
        String cellValue1_zhengxiang = null;
        
        for(int y = 1; y<rowLength_zhengxiang;y++){
           	
        	xssfRow1_zhengxiang  = sheet_zhengxiang.getRow(y);
        	
        	xssfCell1_zhengxiang = xssfRow1_zhengxiang.getCell(duizhang_id_col);
        	
        	cellValue1_zhengxiang = xssfCell1_zhengxiang.getStringCellValue().replace("'", "");
        	
        	Dailylog.logInfo("cell value is <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<:" +cellValue1_zhengxiang);
        	
        	zhengxiangduizhang_id_list.add(cellValue1_zhengxiang);
      
    }
        
//    	ArrayList<String> zhifu_id_list =  new ArrayList<String>();
//    	ArrayList<String> zhengxiangduizhang_id_list =  new ArrayList<String>();
//    	ArrayList<String> common =  new ArrayList<String>();
//    	ArrayList<String> left_zhifu_id_list =  new ArrayList<String>();
//    	ArrayList<String> left_zhengxiangduizhang_id_list =  new ArrayList<String>();

        
        if(zhengxiangduizhang_id_list.size() >=zhifu_id_list.size()){
        	for(String str : zhengxiangduizhang_id_list){
        		if(zhifu_id_list.contains(str)){
        			common.add(str);
        		}
        	}
        }else{
        	for(String str : zhifu_id_list){
        		if(zhengxiangduizhang_id_list.contains(str)){
        			common.add(str);
        		}
        	}
        }
        
        Dailylog.logInfo("common size is :" + common.size());
        
        
//        for(String str : common){
//        	if(!zhengxiangduizhang_id_list.contains(str)){
//        		 Dailylog.logInfo("str ----- is :" + str);
//        		left_zhengxiangduizhang_id_list.add(str);
//        	}
//        }
        
        for(int x =0; x <zhifu_id_list.size();x++){
        	if(!common.contains(zhifu_id_list.get(x))){
        		Dailylog.logInfo("index is  :" + zhifu_id_list.get(x));
        		left_zhifu_id_list.add(zhifu_id_list.get(x));
        	}
        }
        for(String str : zhengxiangduizhang_id_list){
        	if(!common.contains(str)){
        		left_zhengxiangduizhang_id_list.add(str);
        	}
        }
        

        System.out.println("left of zhifu :" + left_zhifu_id_list.size());
        System.out.println("left of duizhang :" + left_zhengxiangduizhang_id_list.size());
     
 
        WriterExcelUtil.writeContent2Excels_Records(destinationTable,left_zhifu_id_list, left_zhengxiangduizhang_id_list,pay_sheetName + "_compareresult",pay_sheetName+" : "+ rowLength,account_sheetName + ": " +rowLength_zhengxiang);

        
		
	}

}
