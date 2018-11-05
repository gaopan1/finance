package TestScript.ExcelTest_Jiudian;

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

public class CompareContents_Zhekou_Test {

//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	
	String tag = "AAA";
	
	String sourceFile;
	String destinationFile;
	String account_sheetName;
	String payid;
	String zhekou;
	String sales_Price;
	String actual_Sales_Price;
	String zhifudingdanID;
	
	
	int payid_index;
	int zhekou_index;
	int sales_Price_index;
	int actual_Sales_Price_index;
	int zhifudingdanID_index;
	
	
	
	
	public Map<String,String> map_pay = new HashMap();
	
	public List<String> list_pay = new ArrayList<String>();
	
	public Map<String,String> map_account = new HashMap();
	
	public List<String> list_account = new ArrayList<String>();
	
	public Map<String,List<String>> result_map = new HashMap<String,List<String>>();
	
	
	

	public CompareContents_Zhekou_Test(String sourceFile,String destinationFile,String account_sheetName,String payid,String zhifudingdanID,String zhekou,String sales_Price,String actual_Sales_Price){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.account_sheetName = account_sheetName;
		this.payid = payid;
		this.zhekou = zhekou;
		this.sales_Price = sales_Price;
		this.actual_Sales_Price = actual_Sales_Price;
		this.zhifudingdanID = zhifudingdanID;
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
        int index_paysheet = xssfWorkbook.getSheetIndex(account_sheetName);
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
        
        
        /*
         * 订单号
			折扣
			销售价
			实际销售价
			
			int payid_index;
			int zhekou_index;
			int sales_Price_index;
			int actual_Sales_Price_index;
	
			
			
         * */
        
        // 获取支付id的index
        payid_index = WriterExcelUtil.getIndexOfFields(xssfRow, payid);
        Dailylog.logInfo("pay id index>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + payid_index);

        //获取想要获得字段的index  
   
        zhekou_index =  WriterExcelUtil.getIndexOfFields(xssfRow, zhekou);
        sales_Price_index =  WriterExcelUtil.getIndexOfFields(xssfRow, sales_Price);
        actual_Sales_Price_index =  WriterExcelUtil.getIndexOfFields(xssfRow, actual_Sales_Price);
        zhifudingdanID_index = WriterExcelUtil.getIndexOfFields(xssfRow, zhifudingdanID);
        
        for(int x = 1; x <= rowLength-1;x++){
        	xssfRow = sheet.getRow(x);
        	
        	String payId_str = "";
        	String zhekou_str = "";
        	String sales_Price_str = "";
        	String actual_Sales_Price_str= "";
        	String zhifudingdanId_str = "";
        	
        	// 得到表格中需要字段的值
        	
        	List<String> list = null;
        
        	for(int y =0 ;y<colLength;y++){
        		
        		list = new ArrayList<String>();
        		
        		XSSFCell xssfCell = xssfRow.getCell(y);
        		
        		if(y == payid_index){
        			payId_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == zhekou_index){
        			zhekou_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == sales_Price_index){
        			sales_Price_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == actual_Sales_Price_index){
        			actual_Sales_Price_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == zhifudingdanID_index){
        			zhifudingdanId_str = WriterExcelUtil.getCellValue(xssfCell);
        		}
        	}
        	
        	// 根据不同的模式  计算收入  然后判断收入是否正确
        	
        	Dailylog.logInfo("pay id is :::::::::::::::::::::::::::::::::" + payId_str);
        	
        	
        	double f_sales_Price = WriterExcelUtil.getFloatPrice(sales_Price_str);
        	Dailylog.logInfo("f_sales_Price is :" + f_sales_Price);

        	
        	double f_actual_Sales_Price = WriterExcelUtil.getFloatPrice(actual_Sales_Price_str);
        	Dailylog.logInfo("f_actual_Sales_Price is :" + f_actual_Sales_Price);
        	
        	double f_zhekou = WriterExcelUtil.getFloatPrice(zhekou_str);
        	Dailylog.logInfo("f_zhekou is :" + f_zhekou);
        	
        	
        	Dailylog.logInfo("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        	
        	//计算公式
        	double calculate_zhekou = f_sales_Price-f_actual_Sales_Price;
        	
        	calculate_zhekou = WriterExcelUtil.getValidNumbersOfDouble(calculate_zhekou, 2);
        	
        	Dailylog.logInfo("折扣的计算结果是：" + calculate_zhekou);
        	
        	
        	List<String> list_detail = null;
        	
        	if(f_zhekou != calculate_zhekou){
        		
        		list_detail = new ArrayList<String>();
        		
        		list_detail.add(sales_Price_str);
        		list_detail.add(actual_Sales_Price_str);
        		
        		list_detail.add(calculate_zhekou + "");
        		list_detail.add(zhekou_str);
        		
        		result_map.put(payId_str+tag+zhifudingdanId_str, list_detail);
        	}
        }
        
        ArrayList<String> al_firstRowNames = new ArrayList<String>();
        
        al_firstRowNames.add("订单ID");
        al_firstRowNames.add("支付订单ID");
        al_firstRowNames.add("销售价");
	    al_firstRowNames.add("实际销售价");
	    al_firstRowNames.add("折扣（计算结果）");
	    al_firstRowNames.add("折扣");
 
        writeContent2Excels_Contents(destinationFile,account_sheetName+"<>"+zhekou,al_firstRowNames,result_map);
        
    
	}
	
public void writeContent2Excels_Contents(String destinationTable,String sheetName,ArrayList<String> firstRowNames,Map<String,List<String>> map){
		
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
			
			if(map.size() != 0){
				Set<String> set1 = map.keySet();
				
				Iterator<String> itt = set1.iterator();
				
				int num = 1;
				while(itt.hasNext()){
					
					String str = itt.next();
					List<String> list_result = map.get(str);
					
					HSSFRow row = sheet.createRow(num);
					
					HSSFCell cell_2 = row.createCell(0);
					cell_2.setCellValue(str.split(tag)[0]);
					
					HSSFCell cell_3 = row.createCell(1);
					cell_3.setCellValue(str.split(tag)[1]);
					
					for(int t = 2;t<=list_result.size()+1;t++){
						HSSFCell cell_1 = row.createCell(t);
						cell_1.setCellValue(list_result.get(t-2));
					}
					
					num++;
				}	
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
