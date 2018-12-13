package TestScript.ExcelTest_Jiudian_EcouponSplitting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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



public class CompareContentsTest_payTime {

	
	
	String caseName;
	String pay_sheetName;
	String account_sheetName;
	String result_sheetName;
	String getPayColumnName;
	String getAccountColumnName;
	String sourceTable;
	String destinationTable;
	
	String getPayJine;
	String getAccount_youhuiquan;
	
	String tag = "AAA";
	
	
	
	int zhifu_id_col = 0;
	int duizhang_id_col = 0;
	
	int getPayJine_col = 0;
	int getAccount_youhuiquan_col = 0;
	
	ArrayList<String> zhifu_id_list =  new ArrayList<String>();
	ArrayList<String> zhengxiangduizhang_id_list =  new ArrayList<String>();
	ArrayList<String> left_zhifu_id_list =  new ArrayList<String>();
	ArrayList<String> left_zhengxiangduizhang_id_list =  new ArrayList<String>();
	
	
	HashMap<String,String> youhuiquan_map = new HashMap<String,String>();
	HashMap<String,String> liushui_map = new HashMap<String,String>();
	
	HashMap<String,String> result_map = new HashMap<String,String>();
	
	
	public CompareContentsTest_payTime(String sourceTable,
									String destinationTable,
									String caseName,
									String pay_sheetName,
									String getPayColumnName,
									String account_sheetName,
									String getAccountColumnName,
									String result_sheetName,
									String getPayJine,
									String getAccount_youhuiquan){
		
		this.sourceTable = sourceTable;
		this.destinationTable = destinationTable;
		this.caseName = caseName;
		this.pay_sheetName = pay_sheetName;
		this.account_sheetName = account_sheetName;
		this.result_sheetName = result_sheetName;
		this.getPayColumnName = getPayColumnName;
		this.getAccountColumnName = getAccountColumnName;
		
		this.getPayJine = getPayJine;
		this.getAccount_youhuiquan = getAccount_youhuiquan;
		
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
        	
        	if(cellvalue.equals(getPayJine)){
        		getPayJine_col = x;
        		System.out.println("getPayJine_col is :" + getPayJine_col);
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
        	xssfCell2 = xssfRow1.getCell(getPayJine_col);
        	
        	cellValue1 = xssfCell1.getStringCellValue().replace("'", "");
        	cellValue2 = WriterExcelUtil.getCellValue1(xssfCell2,"yyyy-MM-dd");
        	cellValue2 = cellValue2.split(" ")[0];
  	
        	if(!cellValue2.contains("0000-00-00")){
        		youhuiquan_map.put(cellValue1, cellValue2);	
        	}
	
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
        	}
        	
        	if(cellvalue.equals(getAccount_youhuiquan)){
        		
        		//流水表中的优惠券
        		getAccount_youhuiquan_col = x;
        		System.out.println("getAccount_youhuiquan_col is :" + getAccount_youhuiquan_col);
        	}
        	
        	
        }
        
        XSSFRow xssfRow1_zhengxiang = null;
        
        XSSFCell xssfCell1_zhengxiang = null;
        XSSFCell xssfCell2_zhengxiang = null;
       
        String cellValue1_zhengxiang = null;
        String cellValue2_zhengxiang = null;
       
        
        for(int y = 1; y<rowLength_zhengxiang;y++){
           	
        	xssfRow1_zhengxiang  = sheet_zhengxiang.getRow(y);
        	
        	xssfCell1_zhengxiang = xssfRow1_zhengxiang.getCell(duizhang_id_col);
        	xssfCell2_zhengxiang = xssfRow1_zhengxiang.getCell(getAccount_youhuiquan_col);
        	

        	cellValue1_zhengxiang = xssfCell1_zhengxiang.getStringCellValue().replace("'", "");
        	cellValue2_zhengxiang = WriterExcelUtil.getCellValue1(xssfCell2_zhengxiang,"yyyy-MM-dd");
        	cellValue2_zhengxiang = cellValue2_zhengxiang.split(" ")[0].trim();
        	
        	Dailylog.logInfo("cellValue2_zhengxiang is :"+ cellValue2_zhengxiang);
        	if(!cellValue2_zhengxiang.contains("0000-00-00")){
        		liushui_map.put(cellValue1_zhengxiang, cellValue2_zhengxiang);
        	}	
        	
    }
        

        //从map中得到相同的id的集合
      
        Set<String> set_youhuiquan = youhuiquan_map.keySet();
        Set<String> set_liushui  = liushui_map.keySet();
        
        Set<String> commonSet = new TreeSet<String>();
        
        int len_youhuiquan = set_youhuiquan.size();
        int len_liushui = set_liushui.size();
        
        
        if(len_youhuiquan >= len_liushui){
        	
        	for(String str : set_youhuiquan){
        		
        		if(set_liushui.contains(str)){
        			commonSet.add(str);
        		}	
        	}  	
        }else{
        	
        	for(String str : set_liushui){
        		
        		if(set_youhuiquan.contains(str)){
        			commonSet.add(str);
        		}		
        	}
        }

        
        Dailylog.logInfo("commonSet size is :" + commonSet.size());
        
        String value_youhuiquan = "";
        String value_liushui = "";
        
        String resultValue = "";
        
        
        
        
        for(String str : commonSet){
        	
        	value_youhuiquan = youhuiquan_map.get(str);
        	
        	value_liushui = liushui_map.get(str);
        	
        	if(!value_youhuiquan.equals(value_liushui)){
        		
        		resultValue = value_youhuiquan + tag + value_liushui;
        		
//        		Dailylog.logInfo("str is ：" + str + "：：：：：：：：：resultValue is :" + resultValue);
        		
        		result_map.put(str, resultValue);
        		
        	}	
        	
        }

        System.out.println("result map size is  :" + result_map.size());
     
 
        writeContent2Excels_Records(destinationTable,caseName+"_compareRecords",result_map);

        
		
	}
	
	public void writeContent2Excels_Records(String destinationTable,String sheetName,Map<String,String> resultMap) throws Exception{
		
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
			
			HSSFCell cell1 = row1.createCell(0);
			
			 cell1.setCellValue("订单ID");
			 
			 HSSFCell cell2 = row1.createCell(1);
			 
			 cell2.setCellValue("补贴拆分-"+getPayJine);
			 
			 HSSFCell cell3 = row1.createCell(2);
			 
			 cell3.setCellValue("流水-"+getPayJine);

			
			
			 HSSFRow row = null;
			 
			 
			Set<String> resultSet = result_map.keySet();
			
			String result = "";
			
			int rowNum = 1;
			
			for(String str : resultSet){
				
				row = sheet.createRow(rowNum);
				
				result = result_map.get(str);
				
//				Dailylog.logInfo("str is :" + str + "::::::::::::result is :" + result);
				
				String[] strs = result.split(tag);
				
				cell1 = row.createCell(0);
				cell2 = row.createCell(1);
				cell3 = row.createCell(2);
				
				
				cell1.setCellValue(str);
				cell2.setCellValue(strs[0]);
				cell3.setCellValue(strs[1]);
				
				
				rowNum++;
				
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
