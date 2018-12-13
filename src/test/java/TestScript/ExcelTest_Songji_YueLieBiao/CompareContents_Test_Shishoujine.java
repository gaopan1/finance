package TestScript.ExcelTest_Songji_YueLieBiao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;

public class CompareContents_Test_Shishoujine {
	
	
	String sourceFile;
	String destinationFile;
	String total_sheetName;
	String total_value_sheetName;
	String biaotouming;
	String result_SheetName;
	
	//需要从表中获取的字段
	
	String zhifujine;
	String butiejine;
	String gongyingshangbutie;
	String yingjiesuanjine;
	String jiesuanjine;
	String jiesuanjine_RMB;
	String shouru;

	
	
	int totalRecords = 0;
	
	int index_zhifujine;
	int index_butiejine;
	int index_gongyingshangbutie;
	int index_yingjiesuanjine;
	int index_jiesuanjine;
	int index_jiesuanjine_RMB;
	int index_shouru;
	
	List<String> zhifujine_al = new ArrayList<String>();
	List<String> butiejine_al = new ArrayList<String>();
	List<String> gongyingshangbutie_al = new ArrayList<String>();
	List<String> yingjiesuanjine_al = new ArrayList<String>();
	List<String> jiesuanjine_al = new ArrayList<String>();
	List<String> jiesuanjine_RMB_al = new ArrayList<String>();
	List<String> shouru_al = new ArrayList<String>();
	
	
	
	List<String> calculate_Result = new ArrayList<String>();
	List<String> result  = new ArrayList<String>();
	
	
	
	

	public CompareContents_Test_Shishoujine(String sourceFile,
										String destinationFile,
										String total_sheetName,
										String total_value_sheetName,
										String biaotouming,
										String result_SheetName,
										String zhifujine,
										String butiejine,
										String gongyingshangbutie,
										String yingjiesuanjine,
										String jiesuanjine,
										String jiesuanjine_RMB,
										String shouru){
		
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.total_sheetName = total_sheetName;
		this.total_value_sheetName = total_value_sheetName;
		this.biaotouming = biaotouming;
		this.result_SheetName = result_SheetName;
		
		this.zhifujine = zhifujine;
		this.butiejine = butiejine;
		this.gongyingshangbutie = gongyingshangbutie;
		this.yingjiesuanjine = yingjiesuanjine;
		this.jiesuanjine = jiesuanjine;
		this.jiesuanjine_RMB = jiesuanjine_RMB;
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
        int index_sheet_qingsuan = xssfWorkbook.getSheetIndex(total_sheetName);
        Dailylog.logInfo("index total is :" + index_sheet_qingsuan);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_sheet_qingsuan);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);

        /*
         * 
         * int index_zhifujine;
			int index_butiejine;
			int index_gongyingshangbutie;
			int index_yingjiesuanjine;
			int index_jiesuanjine;
			int index_jiesuanjine_RMB;
			int index_shouru;
         * 
         * */
        
        index_zhifujine = WriterExcelUtil.getIndexOfFields(xssfRow, zhifujine);
        index_butiejine = WriterExcelUtil.getIndexOfFields(xssfRow, butiejine);
        index_gongyingshangbutie = WriterExcelUtil.getIndexOfFields(xssfRow, gongyingshangbutie);
        index_yingjiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, yingjiesuanjine);
        index_jiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanjine);
        index_jiesuanjine_RMB = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanjine_RMB);
        index_shouru = WriterExcelUtil.getIndexOfFields(xssfRow, shouru);
        
        
        XSSFRow row = null;
        
        
        for(int x =1; x<=rowLength-1; x++){
        	
        	row = sheet.getRow(x);
        	
        	XSSFCell cell = null;
        	
        	String zhifujine_Str = "";
        	String butiejine_Str = "";
        	String gongyingshangbutie_Str = "";
        	String yingjiesuanjine_Str = "";
        	String jiesuanjine_Str = "";
        	String jiesuanjine_RMB_Str = "";
        	String shouru_Str = "";
        	
        	for(int y =0; y<colLength; y++){
        		
        		
        		
        		cell = row.getCell(y);
        		
        		if(y == index_zhifujine){
        			zhifujine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_butiejine){
        			butiejine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_gongyingshangbutie){
        			gongyingshangbutie_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_yingjiesuanjine){
        			yingjiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_jiesuanjine){
        			jiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_jiesuanjine_RMB){
        			jiesuanjine_RMB_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_shouru){
        			shouru_Str = WriterExcelUtil.getCellValue(cell);
        		}   
        		
        		String dingdanhao = "";
        		
        		if(y == 1){
        			dingdanhao = WriterExcelUtil.getCellValue(cell);
        		}
        		
//        		Dailylog.logInfo("x is :" + x +" y is :" + y + "订单号是：" + dingdanhao);
        	}
        
        	zhifujine_al.add(zhifujine_Str);
        	butiejine_al.add(butiejine_Str);
        	gongyingshangbutie_al.add(gongyingshangbutie_Str);
        	yingjiesuanjine_al.add(yingjiesuanjine_Str);
        	jiesuanjine_al.add(jiesuanjine_Str);
        	jiesuanjine_RMB_al.add(jiesuanjine_RMB_Str);
        	shouru_al.add(shouru_Str); 	
        }
        
        
        //3.Excel工作表对象
        Dailylog.logInfo("total_value_sheetName is :" + total_value_sheetName);
        int index_sheet_value = xssfWorkbook.getSheetIndex(total_value_sheetName);
        Dailylog.logInfo("index value is :" + index_sheet_value);
        XSSFSheet sheet_value = xssfWorkbook.getSheetAt(index_sheet_value);
        //总行数
        int rowLength_value = sheet_value.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength_value);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_value = sheet_value.getRow(0);
        //总列数
        int colLength_value = xssfRow_value.getLastCellNum();
        System.out.println("colLength is :" + colLength_value);
        
        
        XSSFRow firstRow = sheet_value.getRow(1);
        
        
        int dingdanshu_value = WriterExcelUtil.getIndexOfFields(xssfRow_value, "订单数");
        int zhifujine_value = WriterExcelUtil.getIndexOfFields(xssfRow_value, "支付金额");
        int butiejine_value = WriterExcelUtil.getIndexOfFields(xssfRow_value, "补贴金额");
        int gongyingshangbutie_value = WriterExcelUtil.getIndexOfFields(xssfRow_value, "供应商补贴");
        int yingjiesuanjine_value = WriterExcelUtil.getIndexOfFields(xssfRow_value, "应结算金额");
        int jiesuanjine_value = WriterExcelUtil.getIndexOfFields(xssfRow_value, "结算金额");
        int jiesuanjine_RMB_value = WriterExcelUtil.getIndexOfFields(xssfRow_value, "结算金额（RMB)");
        int shouru_value = WriterExcelUtil.getIndexOfFields(xssfRow_value, "收入");
        
        String dingdanshu_Str = "";
        String zhifujine_Str = "";
        String butiejine_Str = "";
        String gongyingshangbutie_Str = "";
        String yingjiesuanjine_Str = "";
        String jiesuanjine_Str = "";
        String jiesuanjine_RMB_Str = "";
        String shouru_Str = "";
        
        XSSFCell cell = null;
        
        for(int x = 0; x <colLength_value; x++){
        	
        	cell = firstRow.getCell(x);
        	
        	if(x == dingdanshu_value){
        		dingdanshu_Str = WriterExcelUtil.getCellValue(cell, "0");
        	}else if(x == zhifujine_value){
        		zhifujine_Str = WriterExcelUtil.getCellValue(cell);
        	}else if(x == butiejine_value){
        		butiejine_Str = WriterExcelUtil.getCellValue(cell);
        	}else if(x == gongyingshangbutie_value){
        		gongyingshangbutie_Str = WriterExcelUtil.getCellValue(cell);
        	}else if(x == yingjiesuanjine_value){
        		yingjiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
        	}else if(x == jiesuanjine_value){
        		jiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
        	}else if(x == jiesuanjine_RMB_value){
        		jiesuanjine_RMB_Str = WriterExcelUtil.getCellValue(cell);
        	}else if(x == shouru_value){
        		shouru_Str =WriterExcelUtil.getCellValue(cell);
        	}
 	
        }
        
        Dailylog.logInfo("dingdanshu_Str is :" + dingdanshu_Str);
        Dailylog.logInfo("zhifujine_Str is :" + zhifujine_Str);
        Dailylog.logInfo("butiejine_Str is :" + butiejine_Str);
        Dailylog.logInfo("gongyingshangbutie_Str is :" + gongyingshangbutie_Str);
        Dailylog.logInfo("yingjiesuanjine_Str is :" + yingjiesuanjine_Str);
        Dailylog.logInfo("jiesuanjine_Str is :" + jiesuanjine_Str);
        Dailylog.logInfo("jiesuanjine_RMB_Str is :" + jiesuanjine_RMB_Str);
        Dailylog.logInfo("shouru_Str is :" + shouru_Str);
        
        
        int int_dingdanshu = Integer.parseInt(dingdanshu_Str);
        
        double dou_zhifujine = Double.parseDouble(zhifujine_Str);
        dou_zhifujine = WriterExcelUtil.getValidNumbersOfDouble(dou_zhifujine, "2.11");
        
        double dou_butiejine = Double.parseDouble(butiejine_Str);
        dou_butiejine = WriterExcelUtil.getValidNumbersOfDouble(dou_butiejine, "2.11");
        
        double dou_gongyingshangbutie = Double.parseDouble(gongyingshangbutie_Str);
        dou_gongyingshangbutie = WriterExcelUtil.getValidNumbersOfDouble(dou_gongyingshangbutie, "2.11");
        
        double dou_yingjiesuanjine = Double.parseDouble(yingjiesuanjine_Str);
        dou_yingjiesuanjine = WriterExcelUtil.getValidNumbersOfDouble(dou_yingjiesuanjine, "2.11");
        
        double dou_jiesuanjine = Double.parseDouble(jiesuanjine_Str);
        dou_jiesuanjine = WriterExcelUtil.getValidNumbersOfDouble(dou_jiesuanjine, "2.11");
        
        double dou_jiesuanjine_RMB = Double.parseDouble(jiesuanjine_RMB_Str);
        dou_jiesuanjine_RMB = WriterExcelUtil.getValidNumbersOfDouble(dou_jiesuanjine_RMB, "2.11");
        
        double dou_shouru = Double.parseDouble(shouru_Str);
        dou_shouru = WriterExcelUtil.getValidNumbersOfDouble(dou_shouru, "2.11");
        
      
        Dailylog.logInfo("int_dingdanshu is :" + int_dingdanshu);
        Dailylog.logInfo("dou_zhifujine is :" + dou_zhifujine);
        Dailylog.logInfo("dou_butiejine is :" + dou_butiejine);
        Dailylog.logInfo("dou_gongyingshangbutie is :" + dou_gongyingshangbutie);
        Dailylog.logInfo("dou_yingjiesuanjine is :" + dou_yingjiesuanjine);
        Dailylog.logInfo("dou_jiesuanjine is :" + dou_jiesuanjine);
        Dailylog.logInfo("dou_jiesuanjine_RMB is :" + dou_jiesuanjine_RMB);
        Dailylog.logInfo("dou_shouru is :" + dou_shouru);
        
        result.add(int_dingdanshu+"");
        result.add(dou_zhifujine+"");
        result.add(dou_butiejine+"");
        result.add(dou_gongyingshangbutie+"");
        result.add(dou_yingjiesuanjine+"");
        result.add(dou_jiesuanjine+"");
        result.add(dou_jiesuanjine_RMB+"");
        result.add(dou_shouru+"");
        
		
        
    	
    	/*
    	 * 
    	 * List<String> zhifujine_al = new ArrayList<String>();
			List<String> butiejine_al = new ArrayList<String>();
			List<String> gongyingshangbutie_al = new ArrayList<String>();
			List<String> yingjiesuanjine_al = new ArrayList<String>();
			List<String> jiesuanjine_al = new ArrayList<String>();
			List<String> jiesuanjine_RMB_al = new ArrayList<String>();
			List<String> shouru_al = new ArrayList<String>();
    	 * 
    	 * 
    	 * */
    	
        totalRecords = rowLength-1;
		
        double calculate_zhifujine = calculateTotal(zhifujine_al);
        calculate_zhifujine = WriterExcelUtil.getValidNumbersOfDouble(calculate_zhifujine, "2.11");
        
        double calculate_butiejine = calculateTotal(butiejine_al);
        calculate_butiejine = WriterExcelUtil.getValidNumbersOfDouble(calculate_butiejine, "2.11");
        
        double calculate_gongyingshangbutie = calculateTotal(gongyingshangbutie_al);
        calculate_gongyingshangbutie = WriterExcelUtil.getValidNumbersOfDouble(calculate_gongyingshangbutie, "2.11");
        
        double calculate_yingjiesuanjine = calculateTotal(yingjiesuanjine_al);
        calculate_yingjiesuanjine = WriterExcelUtil.getValidNumbersOfDouble(calculate_yingjiesuanjine, "2.11");
          
        double calculate_jiesuanjine = calculateTotal(jiesuanjine_al);
        calculate_jiesuanjine = WriterExcelUtil.getValidNumbersOfDouble(calculate_jiesuanjine, "2.11");
        
        double calculate_jiesuanjine_RMB = calculateTotal(jiesuanjine_RMB_al);
        calculate_jiesuanjine_RMB = WriterExcelUtil.getValidNumbersOfDouble(calculate_jiesuanjine_RMB, "2.11");
        
        double calculate_shouru = calculateTotal(shouru_al);
        calculate_shouru = WriterExcelUtil.getValidNumbersOfDouble(calculate_shouru, "2.11");
        
        
        Dailylog.logInfo("totalRecords is :" + totalRecords);
        Dailylog.logInfo("calculate_zhifujine is :" + calculate_zhifujine);
        Dailylog.logInfo("calculate_butiejine is :" + calculate_butiejine);
        Dailylog.logInfo("calculate_gongyingshangbutie is :" + calculate_gongyingshangbutie);
        Dailylog.logInfo("calculate_yingjiesuanjine is :" + calculate_yingjiesuanjine);
        Dailylog.logInfo("calculate_jiesuanjine is :" + calculate_jiesuanjine);
        Dailylog.logInfo("calculate_jiesuanjine_RMB is :" + calculate_jiesuanjine_RMB);
        Dailylog.logInfo("calculate_shouru is :" + calculate_shouru);
        
		calculate_Result.add(totalRecords+"");
		calculate_Result.add(calculate_zhifujine+"");
		calculate_Result.add(calculate_butiejine+"");
		calculate_Result.add(calculate_gongyingshangbutie+"");
		calculate_Result.add(calculate_yingjiesuanjine+"");
		calculate_Result.add(calculate_jiesuanjine+"");
		calculate_Result.add(calculate_jiesuanjine_RMB+"");
		calculate_Result.add(calculate_shouru+"");
		
		List<Integer> errorList = new ArrayList<Integer>();
		
		String result_temp = null;
		String calculate_result_temp = null;
		
        for(int x = 0; x<calculate_Result.size(); x++){
        	
        	result_temp = result.get(x);
        	calculate_result_temp = calculate_Result.get(x);
        	
        	Dailylog.logInfo("result_temp is :" + result_temp + "    calculate_result_temp is :"+ calculate_result_temp + "true or false ? "  + (!result_temp.equals(calculate_result_temp)));
        	
        	if(!result_temp.equals(calculate_result_temp)){
        		errorList.add(x);
        	}
        }
		
		
		List<String> firstRowNames = new ArrayList<String>();
		firstRowNames.add(biaotouming);
		firstRowNames.add("订单数");
		firstRowNames.add("支付金额");
		firstRowNames.add("补贴金额");
		firstRowNames.add("供应商补贴");
		firstRowNames.add("应结算金额");
		firstRowNames.add("结算金额");
		firstRowNames.add("结算金额（RMB)");
		firstRowNames.add("收入");

		writeContent2Excels_Records(destinationFile,result_SheetName,firstRowNames,result,calculate_Result,errorList);
		
	}
	
	
	
	public double calculateTotal(List<String> al){
		
		double total = 0;
		
		for(int x = 0; x <al.size(); x++){
			
			String temp = al.get(x);
			
			double dou_temp = Double.parseDouble(temp);
			
			total = total + dou_temp;
			
		}
		
		return total;

	}
	
	
	
	public void writeContent2Excels_Records(String destinationTable,String sheetName,List<String> firstRowNames,List<String> result,List<String> calculate_Result,List<Integer> errorList) throws Exception{
		
		
		WriterExcelUtil.createNewExcelFile(destinationTable);
		
		
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
			HSSFCell cell1 = null;
			
			for(int x =0; x<firstRowNames.size(); x++){
				
				cell1 = row1.createCell(x);
				
				cell1.setCellValue(firstRowNames.get(x));
			}
			
			HSSFRow row2 = sheet.createRow(1);
			HSSFRow row3 = sheet.createRow(2);
			
			HSSFCell cell2_0 = row2.createCell(0);
			HSSFCell cell3_0 = row3.createCell(0);
			cell2_0.setCellValue("页面结果");
			cell3_0.setCellValue("计算结果");
			
			
			CellStyle style= book.createCellStyle();

			style.setFillForegroundColor(WriterExcelUtil.getIndexedColors("red").getIndex());
			
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			
			for(int y = 1; y<=result.size();y++){
				
				HSSFCell cell2_other = row2.createCell(y);
				HSSFCell cell3_other = row3.createCell(y);
				
				cell2_other.setCellValue(result.get(y-1)+"");
				cell3_other.setCellValue(calculate_Result.get(y-1)+"");
				
				if(errorList.contains(y-1)){
					WriterExcelUtil.setCellColor(style, cell2_other);
					WriterExcelUtil.setCellColor(style, cell3_other);
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
