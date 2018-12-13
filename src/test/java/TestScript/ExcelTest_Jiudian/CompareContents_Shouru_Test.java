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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class CompareContents_Shouru_Test {

//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	String tag = "AAA";
	
	String sourceFile;
	String destinationFile;
	String account_sheetName;
	String payid;
	String co_model;
	String actual_SalesPrice;
	String salesPrice;
	String chengbenPrice;
	String yongjin_rate;
	String shouru;
	String zhifudingdanID;
	
	
	double f_yongjin_rate = 0.04;
	
	
	int payid_index;
	int co_model_index;
	int actual_SalesPrice_index;
	int salesPrice_index;
	int chengbenPrice_index;
	int yongjin_rate_index;
	int shouru_index;
	int zhifudingdanID_index;
	
	
	public Map<String,String> map_pay = new HashMap();
	
	public List<String> list_pay = new ArrayList<String>();
	
	public Map<String,String> map_account = new HashMap();
	
	public List<String> list_account = new ArrayList<String>();
	
	public Map<String,List<String>> result_map = new HashMap<String,List<String>>();
	
	
	//String actual_SalesPrice,String salesPrice,String chengbenPrice,String yongjin_rate,String shouru

	public CompareContents_Shouru_Test(String sourceFile,String destinationFile,String account_sheetName,String payid,String zhifudingdanID,String co_model,String actual_SalesPrice,String salesPrice,String chengbenPrice,String yongjin_rate,String shouru){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.account_sheetName = account_sheetName;
		this.payid = payid;
		this.co_model = co_model;
		this.actual_SalesPrice = actual_SalesPrice;
		this.salesPrice = salesPrice;
		this.chengbenPrice = chengbenPrice;
		this.yongjin_rate = yongjin_rate;
		this.shouru = shouru;
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
		       合作模式
		   实际销售价
		   销售价
		   成本价
		   佣金比率
		   收入
			
			int payid_index;
			int co_model_index;
			int actual_SalesPrice_index;
			int salesPrice_index;
			int chengbenPrice_index;
			int yongjin_rate_index;
			int shouru_index;
			
			
         * */
        
        // 获取支付id的index
        payid_index = WriterExcelUtil.getIndexOfFields(xssfRow, payid);
        Dailylog.logInfo("pay id index>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + payid_index);

        //获取想要获得字段的index  
        co_model_index = WriterExcelUtil.getIndexOfFields(xssfRow, co_model);
        actual_SalesPrice_index =  WriterExcelUtil.getIndexOfFields(xssfRow, actual_SalesPrice);
        salesPrice_index =  WriterExcelUtil.getIndexOfFields(xssfRow, salesPrice);
        chengbenPrice_index =  WriterExcelUtil.getIndexOfFields(xssfRow, chengbenPrice);
        yongjin_rate_index =  WriterExcelUtil.getIndexOfFields(xssfRow, yongjin_rate);
        shouru_index =  WriterExcelUtil.getIndexOfFields(xssfRow, shouru);
        zhifudingdanID_index = WriterExcelUtil.getIndexOfFields(xssfRow, zhifudingdanID);
        
        for(int x = 1; x <= rowLength-1;x++){
        	xssfRow = sheet.getRow(x);
        	
        	String payId_str = "";
        	String co_model_str = "";
        	String actual_SalesPrice_str = "";
        	String salesPrice_str = "";
        	String chengbenPrice_str = "";
        	String yongjin_rate_str= "";
        	String shouru_str= "";
        	String zhifudingdanID_str = "";
        	
        	// 得到表格中需要字段的值
        	
        	List<String> list = null;
        
        	for(int y =0 ;y<colLength;y++){
        		
        		list = new ArrayList<String>();
        		
        		XSSFCell xssfCell = xssfRow.getCell(y);
        		
        		if(y == payid_index){
        			payId_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == co_model_index){
        			co_model_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == actual_SalesPrice_index){
        			actual_SalesPrice_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == salesPrice_index){
        			salesPrice_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == chengbenPrice_index){
        			chengbenPrice_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == yongjin_rate_index){
        			yongjin_rate_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == shouru_index){
        			shouru_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == zhifudingdanID_index){
        			zhifudingdanID_str = WriterExcelUtil.getCellValue(xssfCell);
        		}
        	}
        	
        	// 根据不同的模式  计算收入  然后判断收入是否正确
        	
//        	Dailylog.logInfo("pay id is :::::::::::::::::::::::::::::::::" + payId_str);
//        	Dailylog.logError("合作模式:::::::::::" +  co_model_str);
        	

        	double f_actual_SalesPrice = WriterExcelUtil.getFloatPrice(actual_SalesPrice_str);
//        	Dailylog.logInfo("f_actual_SalesPrice is :" + f_actual_SalesPrice);
        	
        	double f_salesPrice = WriterExcelUtil.getFloatPrice(salesPrice_str);
//        	Dailylog.logInfo("f_salesPrice is :" + f_salesPrice);
        	
           	double f_chengbenPrice = WriterExcelUtil.getFloatPrice(chengbenPrice_str);
//        	Dailylog.logInfo("f_chengbenPrice is :" + f_chengbenPrice);
        	
        	double f_yongjin_rate = WriterExcelUtil.getFloatPrice(yongjin_rate_str);
//        	Dailylog.logInfo("f_yongjin_rate is :" + f_yongjin_rate);
        	
        	double f_shouru = WriterExcelUtil.getFloatPrice(shouru_str);
//        	Dailylog.logInfo("f_shouru is :" + f_shouru);

        	
//        	Dailylog.logInfo("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        	
        	if(co_model_str.equals("jj")){
	       	
        		//加价模式 = 实际销售价- 销售价
	
	        	double f_calculate_shouru_jiajia = f_actual_SalesPrice - f_chengbenPrice;
	        	
	        	int num = 0;
	        	if((f_shouru+ "").contains(".")){
	        		String str1 = (f_shouru+ "").split("\\.")[1];
	        		
	        		num = str1.length();
	        		
//	        		Dailylog.logInfo( "shouru_str is :::::" + (f_shouru+ "") + "    num is :::" + num);
	        	}
	    		
	        	f_calculate_shouru_jiajia = WriterExcelUtil.getValidNumbersOfDouble(f_calculate_shouru_jiajia, num);
	        	
//	        	Dailylog.logInfo("calculate is :" + f_calculate_shouru_jiajia + " shouru is : " + f_shouru + "judge is ::::::"+ (f_calculate_shouru_jiajia != f_shouru));
	        	if(f_calculate_shouru_jiajia != f_shouru){
	        		
	            	list.add(co_model_str);
	            	list.add(actual_SalesPrice_str);
	            	list.add(salesPrice_str);
	            	list.add(chengbenPrice_str);
	            	list.add(yongjin_rate_str);
	            	list.add(f_calculate_shouru_jiajia + "");
	            	list.add(shouru_str);
	            	
	            	result_map.put(payId_str+tag+zhifudingdanID_str, list);
	        		
	        	}

        	}else if(co_model_str.equals("fy") || co_model_str.equals("fyjj")){
        		
        		//返佣模式/返佣+加价 = 成本价*佣金比率 + 销售价-成本价
        		
        		double f_calculate_shouru_fanyong = f_chengbenPrice*f_yongjin_rate+f_salesPrice-f_chengbenPrice;
        		
        		int num = 0;
	        	if((f_shouru+"").contains(".")){
	        		String str1 = (f_shouru+"").split("\\.")[1];
	        		
	        		num = str1.length();
//	        		Dailylog.logInfo( "shouru_str is :::::" + (f_shouru+"") + "    num is :::" + num);
	        	}
	    		
	        	f_calculate_shouru_fanyong = WriterExcelUtil.getValidNumbersOfDouble(f_calculate_shouru_fanyong, num);
	        	
	        	
        		
        		
//        		Dailylog.logInfo("f_calculate_shouru_fanyong is <><><><><><><>:" + f_calculate_shouru_fanyong);
        		
//        		Dailylog.logInfo("calculate is :" + f_calculate_shouru_fanyong + " shouru is : " + f_shouru + "judge is ::::::"+ (f_calculate_shouru_fanyong != f_shouru));
        		
        		if(f_shouru != f_calculate_shouru_fanyong){
	        		
        			list.add(co_model_str);
	            	list.add(actual_SalesPrice_str);
	            	list.add(salesPrice_str);
	            	list.add(chengbenPrice_str);
	            	list.add(yongjin_rate_str);
	            	list.add(f_calculate_shouru_fanyong + "");
	            	list.add(shouru_str);
	            	
	            	result_map.put(payId_str+tag+zhifudingdanID_str, list);
	        	}
        		
        	}

        }
        
        Dailylog.logInfo("map size is :" + result_map.size());
        
        ArrayList<String> al_firstRowNames = new ArrayList<String>();
        al_firstRowNames.add("订单ID");
        al_firstRowNames.add("支付订单ID");
        al_firstRowNames.add("合作模式");
	    al_firstRowNames.add("实际销售价");
	    al_firstRowNames.add("销售价");
	    al_firstRowNames.add("成本价");
	    al_firstRowNames.add("佣金比率");
	    al_firstRowNames.add("计算结果（收入）");
	    al_firstRowNames.add("收入");

	    
        
        
        
        writeContent2Excels_Contents(destinationFile,account_sheetName+"<>"+shouru,al_firstRowNames,result_map);
        
    
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
//					System.out.println("------------------?????????");
					String str = itt.next();
					List<String> list_result = map.get(str);
					
					HSSFRow row = sheet.createRow(num);
					
					HSSFCell cell_2 = row.createCell(0);
					cell_2.setCellValue(str.split(tag)[0]);
					
					HSSFCell cell_3 = row.createCell(1);
					cell_3.setCellValue(str.split(tag)[1]);
					
//					System.out.println("value is :" + list_result.get(0));
					
					for(int t = 2;t<=list_result.size()+1;t++){
						HSSFCell cell_1 = row.createCell(t);
//						System.out.println("num is :" + num + "      value is ：" + list_result.get(t-1));
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
