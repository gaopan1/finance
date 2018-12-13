package CommonFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import Logger.Dailylog;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriterExcelUtil {
	
	
	/**
	 * 
	 * @param time
	 * @param day
	 * @return 返回固定的日期，通过给定一个时间， 具体的时间形式是： 2018-11-29，然后给定天数，假如3天，然后的话返回一个加上给定天数的日期
	 * @throws ParseException
	 */
	
	public static String getDateString(String time,long day) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = sdf.parse(time);
	
		
		long timeMillis = date.getTime();
		day = day * 24 * 60 * 60 * 1000;
		timeMillis += day;
		Date d = new Date(timeMillis);
		
		return sdf.format(d);

	}
	
	
	
	
	public static void createNewExcelFile(String filePath){

		File file = new File(filePath);
		
		if(!file.exists()){
			HSSFWorkbook book = new HSSFWorkbook();
			
			FileOutputStream fos = null;		
			
			try {
				fos = new FileOutputStream(file);
				book.write(fos);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(fos != null){
						fos.close();
					}	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static String getValueFromConf(String filePath,String key){
		
		File file = new File(filePath);
		FileInputStream fis = null;
		String value = null;
		
		try{
			fis = new FileInputStream(file);
			
			Properties props = new Properties();
			
			props.load(fis);
			
			value = props.getProperty(key);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(fis != null){
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return value;
	}
	
	
	
	
	public static CellStyle getCellStyle(HSSFWorkbook book,String colors){
		
		CellStyle style= book.createCellStyle();

		style.setFillForegroundColor(getIndexedColors(colors).getIndex());
		
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		return style;
		
	}
	
	
	
	
	public static IndexedColors getIndexedColors(String colors){
		
		
		switch(colors){
			case "red" :
				return IndexedColors.RED;
			case "green" :
				return IndexedColors.GREEN;
			case "blue":
				return IndexedColors.BLUE;
			default :
				return IndexedColors.YELLOW;
	
		}	
		
	}
	
	
	public static void setCellColor(HSSFWorkbook book,HSSFCell cell,String colors){
		
		CellStyle style = getCellStyle(book, colors);
		
		cell.setCellStyle(style);
	}
	
	public static void setCellColor(CellStyle style,HSSFCell cell){
		cell.setCellStyle(style);
	}
	
	
	
	
	public static void createExcels(String filePath){
		
		File file = new File(filePath);
		
		if(file.exists()){
			file.delete();
		}else{
			HSSFWorkbook  book = new HSSFWorkbook();
			
			FileOutputStream fos = null;
			
			try{
				fos = new FileOutputStream(file);
				book.write(fos);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					fos.close();
					book.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}	
		}
	}
	
	
	public static double getValidNumbersOfDouble(double dou,int num){
		
		
		BigDecimal   b   =   new   BigDecimal(dou);  
		
		double   f1   =   b.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();  
		
		return f1;
		
	}
	
	public static double getValidNumbersOfDouble(double dou,String standard_str){
		
		int num = 0;
		
		if(standard_str.contains(".")){
			num = standard_str.split("\\.")[1].length();
		}
		
		BigDecimal b = new BigDecimal(dou);
		
		double f1 = b.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		return f1;
		
	}
	
	
	public static boolean isNumberic(List<String> list){
		
		boolean flag = true;
		
		for(int x = 0; x < list.size(); x++){
			
			String str = list.get(x);
			
			if(!WriterExcelUtil.isNumberic(str)){
				flag = false;
				break;
			}	
		}
		
		return flag;
	}
	
	
	public static boolean isNumberic(String str){
		
		String regex = "-?[0-9]*.?[0-9]+";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(str);
		
		if(matcher.matches()){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public static double getFloatPrice(String price){
		
		double ff = Double.parseDouble(price);
		

		double tt = (double)Math.round(ff*100)/100;
				
		return tt;	
		
	}
	
	public static double getFloatPrice(double price){

		double tt = (double)Math.round(price*100)/100;
				
		return tt;	
		
	}
	
	
	
	public static int getIndexOfFields(XSSFRow row,String filedName){
		
		int colLength = row.getLastCellNum();
		
		 List<String> list = new ArrayList<String>();
	        
	        for(int x = 0; x <colLength;x++){
	        	XSSFCell xssfCell = row.getCell(x);
	        	String str = xssfCell.getStringCellValue().trim();
	        	
//	        	System.out.println("first row of the table is :" + str + "x is :" + x);
	        	list.add(str);
	        }
	        
	        
	        int index = list.indexOf(filedName);
//	        Dailylog.logInfo("list is :" +  list.toString());
//	        Dailylog.logInfo("true or false ::::::::" + list.get(0).equals("id"));
//	        Dailylog.logInfo("Field index is :" + index + "<><><><>filedName is ：" + filedName);
	        
	        return index;
	}
	
	

	public static String getFormattedDate(String time,String format) throws Exception{
		
		//yyyy-MM-dd
		
		String date_time = "";
		
		 SimpleDateFormat sdf = null;
		 if(time.contains("/")){
			 
			 sdf = new SimpleDateFormat("yyyy/MM/dd");
			 Date date =  sdf.parse(time);
			 
			 sdf = new SimpleDateFormat(format);
			  
			 date_time =  sdf.format(date);
		 }else{
			 sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
			 
			 Date date =  sdf.parse(time);
			 
			 sdf = new SimpleDateFormat(format);
			  
			 date_time =  sdf.format(date);
		 }
		 
		 return date_time;
	}
	
	
	
	
	
	public static long getMillisTime(String time){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
		long lon = 0;
		
		try{
			lon = sdf.parse(time).getTime();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lon;
	} 
	
	
	
	public static String getCellValue(XSSFCell xssfCell,String formatString){
		
		String value = "";
		if(xssfCell.getCellType() == 1){
			value = xssfCell.getStringCellValue();
//			Dailylog.logInfo("value is ::::str::" + value);
		}else if (xssfCell.getCellType() == 0){
			if(HSSFDateUtil.isCellDateFormatted(xssfCell)){
				Date date = xssfCell.getDateCellValue();
				value = DateFormatUtils.format(date, "yyyy-MM-dd hh:mm:ss");
//				Dailylog.logInfo("value is ::::date::" + value);
			}else{
				DecimalFormat df = new DecimalFormat(formatString);
				value = df.format(xssfCell.getNumericCellValue());
				
//				Dailylog.logInfo("value is ::::numbers::" + value);
			}	
		}
		return value.replace("'", "").trim();

	}
	
	
	
	//"yyyy-MM-dd hh:mm:ss"
	
	public static String getCellValue1(XSSFCell xssfCell,String timeFormat){

		String value = "";
		if(xssfCell.getCellType() == 1){
			value = xssfCell.getStringCellValue();
//			Dailylog.logInfo("value is ::::str::" + value);
		}else if (xssfCell.getCellType() == 0){
			if(HSSFDateUtil.isCellDateFormatted(xssfCell)){
				Date date = xssfCell.getDateCellValue();
				value = DateFormatUtils.format(date, timeFormat);
//				Dailylog.logInfo("value is ::::date::" + value);
			}else{
//				DecimalFormat df = new DecimalFormat("0");
//				value = df.format(xssfCell.getNumericCellValue());
				
				value = xssfCell.getNumericCellValue()+"";
//				Dailylog.logInfo("value is ::::numbers::" + value);
			}	
		}
		return value.replace("'", "").trim();
	}
	
	public static String getCellValue(XSSFCell xssfCell){

		String value = "";
		if(xssfCell.getCellType() == 1){
			value = xssfCell.getStringCellValue();
//			Dailylog.logInfo("value is ::::str::" + value);
		}else if (xssfCell.getCellType() == 0){
			if(HSSFDateUtil.isCellDateFormatted(xssfCell)){
				Date date = xssfCell.getDateCellValue();
				value = DateFormatUtils.format(date, "yyyy-MM-dd hh:mm:ss");
//				Dailylog.logInfo("value is ::::date::" + value);
			}else{
//				DecimalFormat df = new DecimalFormat("0");
//				value = df.format(xssfCell.getNumericCellValue());
				
				value = xssfCell.getNumericCellValue()+"";
//				Dailylog.logInfo("value is ::::numbers::" + value);
			}	
		}
		return value.replace("'", "").trim();
	}
	
	
	
	
	
	public static HSSFSheet createNewSheet(HSSFWorkbook book,String sheetName){
		
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
		
		return sheet;
		
	}
	
	public static void writeContent2Excels_Contents(String destinationTable,String sheetName,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,Map<String,List<String>> map){
		
		
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
//					 Dailylog.logInfo("num is :" + num);
					 String str = itt.next();
//					 Dailylog.logInfo("str is :" + str);
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
			
			
			
			FileOutputStream fos = new FileOutputStream(file);
			
			book.write(fos);
			
			fos.close();
			book.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	
	public static void writeContent2Excels_Records(String destinationTable,List<String> left_zhifu_list,List<String> left_duizhang_list,String sheetName,String pay_total,String account_total) throws Exception{
		
		
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
			
			 cell1.setCellValue("duizhang account");
			
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
				cell = row1.createCell(1);
				cell.setCellValue(left_duizhang_list.get(t-1));
				
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

	
	
	public static void writeExcel(List<Map<String, Object>> list, String path,List<Map<String, Object>> data) {
        try {
            // Excel底部的表名
            String sheetn = "table1";
            String sheetn1 = "table2";
            // 用JXL向新建的文件中添加内容
            File myFilePath = new File(path);
            if (!myFilePath.exists())
                myFilePath.createNewFile();
            OutputStream outf = new FileOutputStream(path);
            WritableWorkbook wwb = Workbook.createWorkbook(outf);
            jxl.write.WritableSheet writesheet = wwb.createSheet(sheetn, 1);
            jxl.write.WritableSheet writesheet1 = wwb.createSheet(sheetn1, 1);
            
            // 设置标题
            if (list.size() > 0) {
                int j = 0;
                for (Entry<String, Object> entry : list.get(0).entrySet()) {
                    String title = entry.getKey();
                    writesheet.addCell(new Label(j, 0, title));
                    j++;
                }
            }
            
         // 设置标题
            if (list.size() > 0) {
                int j = 0;
                for (Entry<String, Object> entry : data.get(0).entrySet()) {
                    String title = entry.getKey();
                    writesheet1.addCell(new Label(j, 0, title));
                    j++;
                }
            }
            // 内容添加
            for (int i = 1; i <= list.size(); i++) {
                int j = 0;
                for (Entry<String, Object> entry : list.get(i - 1).entrySet()) {
                    Object o = entry.getValue();
                    if (o instanceof Double) {
                        writesheet.addCell(new jxl.write.Number(j, i, (Double) entry.getValue()));
                    } else if (o instanceof Integer) {
                        writesheet.addCell(new jxl.write.Number(j, i, (Integer) entry.getValue()));
                    } else if (o instanceof Float) {
                        writesheet.addCell(new jxl.write.Number(j, i, (Float) entry.getValue()));
                    } else if (o instanceof Float) {
                        writesheet.addCell(new jxl.write.DateTime(j, i,(Date) entry.getValue()));
                    } else if (o instanceof BigDecimal) {
                        writesheet.addCell(new jxl.write.Number(j, i, ((BigDecimal) entry
                                .getValue()).doubleValue()));
                    } else if (o instanceof Long) {
                        writesheet.addCell(new jxl.write.Number(j, i, ((Long) entry.getValue())
                                .doubleValue()));
                    } else {
                        writesheet.addCell(new Label(j, i, (String) entry.getValue()));
                    }
                    j++;
                }
            }
            
            // 内容添加
            for (int i = 1; i <= data.size(); i++) {
                int j = 0;
                for (Entry<String, Object> entry : data.get(i - 1).entrySet()) {
                    Object o = entry.getValue();
                    if (o instanceof Double) {
                        writesheet1.addCell(new jxl.write.Number(j, i, (Double) entry.getValue()));
                    } else if (o instanceof Integer) {
                        writesheet1.addCell(new jxl.write.Number(j, i, (Integer) entry.getValue()));
                    } else if (o instanceof Float) {
                        writesheet1.addCell(new jxl.write.Number(j, i, (Float) entry.getValue()));
                    } else if (o instanceof Float) {
                        writesheet1.addCell(new jxl.write.DateTime(j, i,(Date) entry.getValue()));
                    } else if (o instanceof BigDecimal) {
                        writesheet1.addCell(new jxl.write.Number(j, i, ((BigDecimal) entry
                                .getValue()).doubleValue()));
                    } else if (o instanceof Long) {
                        writesheet1.addCell(new jxl.write.Number(j, i, ((Long) entry.getValue())
                                .doubleValue()));
                    } else {
                        writesheet1.addCell(new Label(j, i, (String) entry.getValue()));
                    }
                    j++;
                }
            }
            wwb.write();
            wwb.close();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}