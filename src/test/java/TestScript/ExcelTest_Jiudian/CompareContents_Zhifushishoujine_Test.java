package TestScript.ExcelTest_Jiudian;

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

public class CompareContents_Zhifushishoujine_Test {

//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	String tag = "AAA";
	
	String sourceFile;
	String destinationFile;
	
	String pay_sheetName;
	String account_sheetName;
	String pay_must_info;
	String account_must_info;
	String getPayColumnName;
	String getAccountColumnName;
	String getPayBusinessColumnName;
	String getZhifuDingdanIDColumnName;
	
	int zhifu_id_col;
	int zhifu_business_id_col;
	int duizhang_id_col;
	int zhifudingdan_id_col;
	
	
	
	public Map<String,List<String>> map_pay = new HashMap();
	
	public List<String> list_pay = new ArrayList<String>();
	
	public Map<String,List<String>> map_account = new HashMap();
	
	public List<String> list_account = new ArrayList<String>();
	
	public Map<String,List<String>> result_map = new HashMap<String,List<String>>();
	
	// 如果是pay 和positive account的比较
	// 　pay_must_info  account_must_info 每个数组里含有四个元素
	
	// 如果是 orders 和 double的比较
	// 那么每个数组里含有两个元素
	

	public CompareContents_Zhifushishoujine_Test(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,String getPayColumnName,String getPayBusinessColumnName,String getAccountColumnName,String getZhifuDingdanIDColumnName){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.pay_sheetName = pay_sheetName;
		this.account_sheetName = account_sheetName;
		this.account_must_info = account_must_info;
		this.pay_must_info = pay_must_info;
		this.getPayColumnName = getPayColumnName;
		this.getPayBusinessColumnName = getPayBusinessColumnName;
		this.getAccountColumnName = getAccountColumnName;
		this.getZhifuDingdanIDColumnName = getZhifuDingdanIDColumnName;
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
        
        // 获取订单号 也就是支付id的column的号码zhifu_id_col
        
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
        		System.out.println("zhifu_business_id_col is :" + zhifu_business_id_col);
        	}
        }
        
        System.out.println("zhifu_id_col out  is :" + zhifu_id_col);
        
        //获取想要获得字段的index  这里想要的字段是pay_must_info
        
        List<String> list = new ArrayList<String>();
        
        for(int x = 0; x <colLength;x++){
        	XSSFCell xssfCell = xssfRow.getCell(x);
        	String str = xssfCell.getStringCellValue();
        	
        	System.out.println("first row of the table is :" + str);
        	list.add(str);
        }
        
        int index = list.indexOf(pay_must_info);
        Dailylog.logInfo("index is :" + index);
        
        //获取支付id 以及 对对应想要获取的字段的取值
        
        for(int x = 1; x <= rowLength-1;x++){
        	xssfRow = sheet.getRow(x);
        	String value = "";
        	String pay_id = "";
        	String business_id = "";
        	for(int y =0 ;y<colLength;y++){
        		XSSFCell xssfCell = xssfRow.getCell(y);
//        		Dailylog.logInfo(" x is ::::::: " + x + " y is ::::::" + y + "row length is :" + rowLength);
        		
        		if(index == y){
        			
        			value = WriterExcelUtil.getCellValue(xssfCell).replace("'", "");
        			
//        			Dailylog.logInfo("pay  value >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>is :" + value);
        		}
        		
        		
        		if(zhifu_id_col == y){
        			pay_id = WriterExcelUtil.getCellValue(xssfCell).replace("'", "");
        			
//        			Dailylog.logInfo("pay id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + pay_id +  "y is :" +y);
        		}
        		
        		if(zhifu_business_id_col == y){
        			business_id = WriterExcelUtil.getCellValue(xssfCell).replace("'", "");
        			
//        			Dailylog.logInfo("pay id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + pay_id +  "y is :" +y);
        		}
        		
        	}
        	
        	List<String> list_price = null;
        	
        	if(pay_id.startsWith("5318")){
        		
        		if(!map_pay.containsKey(business_id)){
        			list_price = new ArrayList<String>();
        			list_price.add(value);
        		}else{
        			list_price = map_pay.get(business_id);
        			list_price.add(value);
        		}	
        		
        	}else{
        		
        		if(!map_pay.containsKey(pay_id)){
        			list_price = new ArrayList<String>();
        			list_price.add(value);
        		}else{
        			list_price = map_pay.get(pay_id);
        			list_price.add(value);
        		}
        		
        	}
        	
        	
        	
        	// 将得到的值放到map中
        	map_pay.put(business_id, list_price);
        	
        	Set<String> set_pay = map_pay.keySet();
        	
        	Iterator<String> it = set_pay.iterator();
        	
        	while(it.hasNext()){
        		String temp_id = it.next();
        		if(temp_id.equals(pay_id)){
        			List<String> temp_list = map_pay.get(temp_id);
        			
        			for(int y = 0; y <temp_list.size(); y++){
        				String temp_value = temp_list.get(y);
        				
        				if(temp_value != null && temp_value.contains("-")){
        					temp_list.set(y, temp_value.replace("-", ""));
        				}
        			}
        		}
        	}
        	
        	
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
        
        for(int x = 0; x< colLength_zhengxiang;x++){
        	XSSFCell xssfCell = xssfRow_zhengxiang.getCell(x);
        	String cellvalue = xssfCell.getStringCellValue();
        	System.out.println("cellvalue of zhengxiang is :" + cellvalue);
        	
        	if(cellvalue.equals(getAccountColumnName)){
        		duizhang_id_col = x;
        		System.out.println("duizhang_id_col is :" + duizhang_id_col);
        	}
        	
        	if(cellvalue.equals(getZhifuDingdanIDColumnName)){
        		zhifudingdan_id_col = x;
        		
        		System.out.println("zhifudingdan_id_col is :" + zhifudingdan_id_col);
        	}
        }
        
        // 获取想要获得字段的index  也就是对应的列号
        
        List<String> list1 = new ArrayList<String>();
        
        for(int x = 0; x <colLength_zhengxiang;x++){
        	XSSFCell xssfCell = xssfRow_zhengxiang.getCell(x);
        	String str = xssfCell.getStringCellValue();
        	
        	System.out.println("first row of the table is :" + str);
        	list1.add(str);
        }
        
        int index1 = list1.indexOf(account_must_info);
        
        Dailylog.logInfo("account table >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>is :" + account_sheetName);
        Dailylog.logInfo("account index >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>is :" + index1);
        
        // 得到想要获得字段  也就是支付id  以及 想要获得的内容
        
        for(int x = 1; x <=rowLength_zhengxiang-1;x++){
        	xssfRow_zhengxiang= sheet_zhengxiang.getRow(x);
        	String value = "";
        	String account_id = "";
        	String zhifudingdan_id = "";
        	for(int y = 0; y < colLength_zhengxiang; y++){
        		XSSFCell xssfCell = xssfRow_zhengxiang.getCell(y);
//        		Dailylog.logInfo(" x is ::::::: " + x + " y is ::::::" + y + "row length is :" + rowLength_zhengxiang);
        		
        		if(index1 == y){
        			
        			value = WriterExcelUtil.getCellValue(xssfCell);
        					

//            		Dailylog.logInfo("account value >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + value + "    x is :" + x);
        		}
        		
        		
        		if(duizhang_id_col == y){
        			
        			account_id = WriterExcelUtil.getCellValue(xssfCell);
        			
//        			Dailylog.logInfo("account_id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + account_id +"zhifu_id_col is :" + duizhang_id_col + "y is :" + y + "     colLength_zhengxiang is ：" + colLength_zhengxiang);
        		}
        		
        		if(zhifudingdan_id_col == y){
        			zhifudingdan_id = WriterExcelUtil.getCellValue(xssfCell);
        		}
          		       		
        	}
        	//51180629009743116
        	
        	
        	account_id = account_id + tag + zhifudingdan_id;
        	
        	List<String> list_price_account = null;
        	
        	
        	
        	if(!map_account.containsKey(account_id)){
        		list_price_account = new ArrayList<String>();
        		list_price_account.add(value);
        	}else{
        		list_price_account = map_account.get(account_id);
        		list_price_account.add(value);
        	}

        	map_account.put(account_id, list_price_account);
    		
    		Set<String> set_account = map_account.keySet();
        	
        	Iterator<String> it = set_account.iterator();
//        	Dailylog.logInfo("x is <<<<<<<<<<<<<<<<<:" +x);
        	while(it.hasNext()){
        		String temp_id = it.next();
        		if(temp_id.equals(account_id)){
        			List<String> temp_list = map_account.get(temp_id);
        			
        			for(int m = 0; m<temp_list.size(); m++){
        				String temp_value = temp_list.get(m);
        				
        				if(temp_value != null && temp_value.contains("-")){
        					temp_list.set(m, temp_value.replace("-", ""));
        				}
        			}
        		}
        	}
        }
        
       
        
        System.out.println("row length pay is :" + rowLength);
        System.out.println("row length account is :" + rowLength_zhengxiang);
        
        System.out.println(map_pay.size());
        System.out.println(map_account.size());
      
        Set<String> set_pay = map_pay.keySet();
        Dailylog.logInfo("set_pay size is :" + set_pay.size());
        Set<String> set_account = map_account.keySet();
        Dailylog.logInfo("set_account size is :" + set_account.size());
        
        
        Set<String> common = new HashSet<>();
        
        if(set_pay.size() >= set_account.size()){
        	for(String str : set_pay){
//        		System.out.println("str is ::::::::::::::::::::::::::::::::" +str);
        		
        		for(String account_str : set_account){
        			if(!account_str.split(tag)[1].equals("0")){
        				if(str.equals(account_str.split(tag)[1])){
        					common.add(str);
        				}
        			}else{
        				if(str.equals(account_str.split(tag)[0])){
        					common.add(str);
        				}
        			}
        		}
        	}
        }else{
        	
        	for(String str : set_account){
        		
        		String[] strs = str.split(tag);
        		
        		if(!strs[1].equals("0")){
        			if(set_pay.contains(strs[1])){
        				common.add(str);
        			}
        		}else{
        			if(set_pay.contains(strs[0])){
        				common.add(str);
        			}
        		}
	
        	}
 
        }
      
        
        
        
        Dailylog.logInfo("common size is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: "+ common.size());
        
        Iterator<String> it = common.iterator();
        
        List<String> list_detail = null;
        while(it.hasNext()){
        	
        	String id = it.next();
        	
        	List<String> value_pay =null;
        	List<String> value_account = null;
        	
        	if(!pay_must_info.contains("时间")){
        		
        		if(id.contains(tag)){
          			value_account = map_account.get(id);
        			
        			if(!id.split(tag)[1].equals("0")){
        				value_pay =  map_pay.get(id.split(tag)[1]); 
        			}else{
        				value_pay =  map_pay.get(id.split(tag)[0]); 
        			}
        			
        		}else{
        			value_pay =  map_pay.get(id);
        			
        			Set<String> set = map_account.keySet();
        			
        			for(String str : set){
        				if(!str.split(tag)[1].equals("0")){
        					if(id.equals(str.split(tag)[1])){
        						value_account = map_account.get(str);
        						break;
        					}
        				}else{
        					if(id.equals(str.split(tag)[0])){
        						value_account = map_account.get(str);
        						break;
        					}
        				}
        			}
        		}
        		
        		
        		boolean b_pay = WriterExcelUtil.isNumberic(value_pay);
//        		Dailylog.logInfo("value pay :" + value_pay + "    b_pay is :" + b_pay);
        		boolean b_account = WriterExcelUtil.isNumberic(value_account);
//        		Dailylog.logInfo("value account :" + value_account + "    b_account is :" + b_account);
        		
        		if(b_pay && b_account){
        			
        			double d_pay_total = 0;
        			double d_account_total =0;
        			
        			for(String str : value_pay){
        				double d_pay = WriterExcelUtil.getFloatPrice(str);
        				d_pay_total = d_pay_total + d_pay;
        			}
        			
        			for(String str : value_account){
        				double d_account = WriterExcelUtil.getFloatPrice(str);
        				d_account_total = d_account_total + d_account;
        			}
        			
        			d_pay_total = WriterExcelUtil.getValidNumbersOfDouble(d_pay_total, d_account_total+ "");
        			
        			if(d_pay_total != d_account_total){
        				
//        				Dailylog.logInfo("d_pay is >>>>>>>>>>>>:" + d_pay + "d_account is >>>>>>>>>>>>:" + d_account);
        				list_detail = new ArrayList<String>();
        				list_detail.add(d_pay_total + "");
        				list_detail.add(d_account_total + "");
        				
        				result_map.put(id, list_detail);
        			}
        		}
        		else{
        			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        		}

        	}
 
        }  
        
        Dailylog.logInfo("result map size is ：：：：：：：：：：：：：：：：：：：:" + result_map.size());
        
        
       writeContent2Excels_Contents(destinationFile, pay_sheetName+pay_must_info+"_"+account_must_info,pay_sheetName,account_sheetName,pay_must_info,account_must_info, result_map);
        
        
        
        
	}
	
	
	public void writeContent2Excels_Contents(String destinationTable,String sheetName,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,Map<String,List<String>> map){
		
		WriterExcelUtil.createNewExcelFile(destinationTable);
		
		HSSFWorkbook book = null;
		
		try{
			
			File file = new File(destinationTable);
			
			FileInputStream fis = new FileInputStream(file);
			
			book = new HSSFWorkbook(fis);
			
			int sheetNums = book.getNumberOfSheets();
			
			Dailylog.logInfo("sheet nums is " + sheetNums);
			
			for(int m =0 ; m< sheetNums;m++){
				String temp_sheetName = book.getSheetName(m);
				Dailylog.logInfo("m is :" + m + "temp_sheetName is :" + temp_sheetName+ "temp_sheetName length is :" + temp_sheetName.length());
				Dailylog.logInfo("m is :" + m + "sheet name is :" + sheetName);
				if(temp_sheetName.equals(sheetName)){
					Dailylog.logInfo("+++++++++++++++++++++++++++++++++++++++++++++");
					book.removeSheetAt(m);
					break;
				}
			}
			//创建sheet
			HSSFSheet sheet = book.createSheet(sheetName);
			
			HSSFRow firstRow = sheet.createRow(0);
			
			Iterator<String> it = map.keySet().iterator();
			
			boolean flag = false;
			
			while(it.hasNext()){
				String str = it.next();
						
				if(str.contains(tag)){
					flag = true;
				}
				break;
			}
			
			if(flag){
				
				HSSFCell cell = firstRow.createCell(0);
				cell.setCellValue("支付ID");
				
				cell = firstRow.createCell(1);
				cell.setCellValue("订单支付ID");
				
				cell = firstRow.createCell(2);
				cell.setCellValue(pay_sheetName+"--"+pay_must_info);
				
				cell = firstRow.createCell(3);
				cell.setCellValue(account_sheetName+"--"+account_must_info);
				
				if(map.size() != 0){
					
					Set<String> set1 = map.keySet();
					
					 Iterator<String> itt = set1.iterator();
					
					 int num = 1;
					 while(itt.hasNext()){
//						 Dailylog.logInfo("num is :" + num);
						 String str = itt.next();
//						 Dailylog.logInfo("str is :" + str);
						 List<String> list_2 = map.get(str);
						 
						 HSSFRow row = sheet.createRow(num);
						
						 HSSFCell cell1 = row.createCell(0);
						 cell1.setCellValue(str.split(tag)[0]);
						 
						 HSSFCell cell2 = row.createCell(1);
						 cell2.setCellValue(str.split(tag)[1]);
						 
						  for(int n = 2; n<=list_2.size()+1;n++){
							  cell = row.createCell(n);
							  cell.setCellValue(list_2.get(n-2));
						  }
						 
						 num++; 
					 }	
				}
				
				
			}else{
				
				HSSFCell cell = firstRow.createCell(0);
				cell.setCellValue("支付ID");
				
				cell = firstRow.createCell(1);
				cell.setCellValue(pay_sheetName+"--"+pay_must_info);
				
				cell = firstRow.createCell(2);
				cell.setCellValue(account_sheetName+"--"+account_must_info);
				
				
				if(map.size() != 0){
					
					Set<String> set1 = map.keySet();
					
					 Iterator<String> itt = set1.iterator();
					
					 int num = 1;
					 while(itt.hasNext()){
//						 Dailylog.logInfo("num is :" + num);
						 String str = itt.next();
//						 Dailylog.logInfo("str is :" + str);
						 List<String> list_2 = map.get(str);
						 
						 HSSFRow row = sheet.createRow(num);
						
						 HSSFCell cell1 = row.createCell(0);
						 
						 cell1.setCellValue(str);
						 
						  for(int n = 1; n<=list_2.size();n++){
							  cell = row.createCell(n);
							  cell.setCellValue(list_2.get(n-1));
						  }
						 
						 num++; 
					 }	
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
