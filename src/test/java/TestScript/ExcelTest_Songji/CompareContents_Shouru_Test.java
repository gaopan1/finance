package TestScript.ExcelTest_Songji;

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

public class CompareContents_Shouru_Test {

//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	String sourceFile;
	String destinationFile;
	String account_sheetName;
	String payid;
	String co_model;
	String pay_money;
	String allowance;
	String ying_jie_suan_money;
	String shouru;
	
	double f_yongjin_rate = 0.04;
	
	
	int payid_index;
	int co_model_index;
	int pay_money_index;
	int allowance_index;
	int yongjin_rate_index;
	int ying_jie_suan_money_index;
	int shouru_index;
	
	
	
	public Map<String,String> map_pay = new HashMap();
	
	public List<String> list_pay = new ArrayList<String>();
	
	public Map<String,String> map_account = new HashMap();
	
	public List<String> list_account = new ArrayList<String>();
	
	public Map<String,List<String>> result_map = new HashMap<String,List<String>>();
	
	
	

	public CompareContents_Shouru_Test(String sourceFile,String destinationFile,String account_sheetName,String payid,String co_model,String pay_money,String allowance,String ying_jie_suan_money,String shouru){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.account_sheetName = account_sheetName;
		this.payid = payid;
		this.co_model = co_model;
		this.pay_money = pay_money;
		this.allowance = allowance;
		this.ying_jie_suan_money = ying_jie_suan_money;
		this.shouru = shouru;
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

			支付金额

			补贴
	
			佣金比例

			应结算金额
			
			int payid_index;
			int co_model_index;
			int pay_money_index;
			int allowance_index;
			int yongjin_rate_index;
			int ying_jie_suan_money_index;
			
			
         * */
        
        // 获取支付id的index
        payid_index = WriterExcelUtil.getIndexOfFields(xssfRow, payid);
        Dailylog.logInfo("pay id index>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + payid_index);

        //获取想要获得字段的index  
   
        co_model_index =  WriterExcelUtil.getIndexOfFields(xssfRow, co_model);
        pay_money_index =  WriterExcelUtil.getIndexOfFields(xssfRow, pay_money);
        allowance_index =  WriterExcelUtil.getIndexOfFields(xssfRow, allowance);
        ying_jie_suan_money_index =  WriterExcelUtil.getIndexOfFields(xssfRow, ying_jie_suan_money);
        shouru_index = WriterExcelUtil.getIndexOfFields(xssfRow, shouru);
        
        for(int x = 1; x <= rowLength-1;x++){
        	xssfRow = sheet.getRow(x);
        	
        	String payId_str = "";
        	String co_model_str = "";
        	String pay_money_str = "";
        	String allowance_str = "";
        	String ying_jie_suan_money_str= "";
        	String shouru_str = "";
        	
        	// 得到表格中需要字段的值
        	
        	List<String> list = null;
        
        	for(int y =0 ;y<colLength;y++){
        		
        		list = new ArrayList<String>();
        		
        		XSSFCell xssfCell = xssfRow.getCell(y);
        		
        		if(y == payid_index){
        			payId_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == co_model_index){
        			co_model_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == pay_money_index){
        			pay_money_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == allowance_index){
        			allowance_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == ying_jie_suan_money_index){
        			ying_jie_suan_money_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == shouru_index){
        			shouru_str = WriterExcelUtil.getCellValue(xssfCell);
        		}
        	}
        	
        	// 根据不同的模式  计算收入  然后判断收入是否正确
        	
        	Dailylog.logInfo("pay id is :::::::::::::::::::::::::::::::::" + payId_str);
        	
        	double f_pay_money = WriterExcelUtil.getFloatPrice(pay_money_str);
        	Dailylog.logInfo("f_pay_money is :" + f_pay_money);
        	
        	double f_allowance = WriterExcelUtil.getFloatPrice(allowance_str);
        	Dailylog.logInfo("f_allowance is :" + f_allowance);
        	
        	double f_ying_jie_suan_money = WriterExcelUtil.getFloatPrice(ying_jie_suan_money_str);
        	Dailylog.logInfo("f_ying_jie_suan_money is :" + f_ying_jie_suan_money);

        	
        	double f_shouru = WriterExcelUtil.getFloatPrice(shouru_str);
        	Dailylog.logInfo("f_shouru is :" + f_shouru);
        	
        	Dailylog.logInfo("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        	
        	if(co_model_str.equals("加价")){
	       	
	//        		加价是  支付➕补贴➖应结算金额
	
	        	double f_calculate_shouru_jiajia = f_pay_money+f_allowance-f_ying_jie_suan_money;
	        	f_calculate_shouru_jiajia = WriterExcelUtil.getFloatPrice(f_calculate_shouru_jiajia);
//	        	Dailylog.logInfo("f_calculate_shouru_jiajia is :" + f_calculate_shouru_jiajia);
	        	
	        	if(f_shouru != f_calculate_shouru_jiajia){
	        		
	            	list.add(co_model_str);
	            	list.add(pay_money_str);
	            	list.add(allowance_str);
	            	list.add(ying_jie_suan_money_str);
	            	list.add(f_calculate_shouru_jiajia+"");
	            	list.add(shouru_str);
	            	
	            	result_map.put(payId_str, list);
	        		
	        	}

        	}else if(co_model_str.equals("返佣")){
//        		反佣是   (支付金额+补贴)×佣金比例
        		double f_calculate_shouru_fanyong = (f_pay_money+f_allowance)*f_yongjin_rate;
        		f_calculate_shouru_fanyong = WriterExcelUtil.getFloatPrice(f_calculate_shouru_fanyong);
        		Dailylog.logInfo("f_calculate_shouru_fanyong is *****************************:" + f_calculate_shouru_fanyong);
        		
        		if(f_shouru != f_calculate_shouru_fanyong){
	        		
	            	list.add(co_model_str);
	            	list.add(pay_money_str);
	            	list.add(allowance_str);
	            	list.add(ying_jie_suan_money_str);
	            	list.add(f_calculate_shouru_fanyong+"");
	            	list.add(shouru_str);
	            	
	            	result_map.put(payId_str, list);
	        		
	        	}
        		
        	}

        }
        
        ArrayList<String> al_firstRowNames = new ArrayList<String>();
        al_firstRowNames.add("支付ID");
        al_firstRowNames.add("合作模式");
	    al_firstRowNames.add("支付金额");
	    al_firstRowNames.add("补贴");
	    al_firstRowNames.add("应结算金额");
	    al_firstRowNames.add("计算结果（收入）");
	    al_firstRowNames.add("收入");

	    
        
        
        
        writeContent2Excels_Contents(destinationFile,account_sheetName+"<>收入",al_firstRowNames,result_map);
        
    
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
					cell_2.setCellValue(str);
					
					for(int t = 1;t<=list_result.size();t++){
						HSSFCell cell_1 = row.createCell(t);
						cell_1.setCellValue(list_result.get(t-1));
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
