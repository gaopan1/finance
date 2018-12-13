package TestScript.ExcelTest_Songji_Qingsuanliushui;

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

public class CompareContents_Songji_Calclate_Qingsuanshijian {
	
	public String sourceFile;
	public String destinationFile;
	public String sheetName;
	public String resultSheetName;
	
	
	public String dingdanhao;
	public String hezuomoshi;
	public String yingjiesuanjine;
	public String jiesuanjine;
	public String zhifujine;
	public String butie;
	public String shouru;
	public String qingsuanshijian;
	public String chuxingshijian;
	
	
	int index_dingdanhao;
	int index_hezuomoshi;
	int index_yingjiesuanjine;
	int index_jiesuanjine;
	int index_zhifujine;
	int index_butie;
	int index_shouru;
	int index_qingsuanshijian;
	int index_chuxingshijian;
	
	List<String> list = null;
	
	HashMap<String,List<String>> resultMap = new HashMap<String,List<String>>();
	
	
	
	
	
	public CompareContents_Songji_Calclate_Qingsuanshijian(String sourceFile,
												String destinationFile,
												String sheetName,
												String resultSheetName,
												String dingdanhao,
												String hezuomoshi,
												String yingjiesuanjine,
												String jiesuanjine,
												String zhifujine,
												String butie,
												String shouru,
												String qingsuanshijian,
												String chuxingshijian){
		
		this.sourceFile = sourceFile;
		this.destinationFile =destinationFile;
		this.sheetName = sheetName;
		this.resultSheetName =resultSheetName;
		this.dingdanhao = dingdanhao;
		this.hezuomoshi =hezuomoshi;
		this.yingjiesuanjine = yingjiesuanjine;
		this.jiesuanjine = jiesuanjine;
		this.zhifujine = zhifujine;
		this.butie =butie;
		this.shouru =shouru;
		this.qingsuanshijian = qingsuanshijian;
		this.chuxingshijian = chuxingshijian;
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
        int index_sheet_qingsuan = xssfWorkbook.getSheetIndex(sheetName);
        Dailylog.logInfo("index qingsuan is :" + index_sheet_qingsuan);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_sheet_qingsuan);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
        
        
        index_dingdanhao = WriterExcelUtil.getIndexOfFields(xssfRow, dingdanhao);
        index_hezuomoshi = WriterExcelUtil.getIndexOfFields(xssfRow, hezuomoshi);
        index_yingjiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, yingjiesuanjine);
        index_jiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanjine);
        index_zhifujine = WriterExcelUtil.getIndexOfFields(xssfRow, zhifujine);
        index_butie = WriterExcelUtil.getIndexOfFields(xssfRow, butie);
        index_shouru = WriterExcelUtil.getIndexOfFields(xssfRow, shouru);
        index_qingsuanshijian = WriterExcelUtil.getIndexOfFields(xssfRow, qingsuanshijian);
        index_chuxingshijian = WriterExcelUtil.getIndexOfFields(xssfRow, chuxingshijian);
        
        XSSFRow calculateRow = null;
        
        for(int x =1; x<=rowLength-1;x++){
        	
        	calculateRow = sheet.getRow(x);
        	
        	XSSFCell calculateCell = null;
        	
        	 String dingdanhao_Str="";
        	 String hezuomoshi_Str="";
        	 String yingjiesuanjine_Str="";
        	 String jiesuanjine_Str="";
        	 String zhifujine_Str="";
        	 String butie_Str="";
        	 String shouru_Str="";
        	 String qingsuanshijian_Str="";
        	 String chuxingshijian_Str="";
        	
        	 
        	 for(int y = 0; y<colLength; y++){
        		 
        		 calculateCell = calculateRow.getCell(y);
        		 
        		 if(y == index_dingdanhao){
        			 dingdanhao_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }else if(y == index_hezuomoshi){
        			 hezuomoshi_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }else if(y == index_yingjiesuanjine){
        			 yingjiesuanjine_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }else if(y == index_jiesuanjine){
        			 jiesuanjine_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }else if(y == index_zhifujine){
        			 zhifujine_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }else if(y == index_butie){
        			 butie_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }else if(y == index_shouru){
        			 shouru_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }else if(y == index_qingsuanshijian){
        			 qingsuanshijian_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }else if(y == index_chuxingshijian){
        			 chuxingshijian_Str = WriterExcelUtil.getCellValue(calculateCell);
        		 }	 
        		 
        	 }
        	 
        	 
        	 //应结算金额：  支付金额+ 补贴
        	 
        	 
        	 String result_Qingsuanshijian = WriterExcelUtil.getDateString(chuxingshijian_Str, 3);
        	
        	 
        	
        	 
        	 Dailylog.logInfo("result_Qingsuanshijian is ：" + result_Qingsuanshijian);
        	 
        	 
        	 if(!result_Qingsuanshijian.equals(qingsuanshijian_Str)){
        		 list = new ArrayList<String>();
        		 
        		 list.add(qingsuanshijian_Str);
        		 list.add(chuxingshijian_Str);
        		 
        		 resultMap.put(dingdanhao_Str, list);
	 
        	 }
  	
        }
        
        
        List<String> firstRowList = new ArrayList<String>();
        
        firstRowList.add("订单号");
        firstRowList.add("清算日期");
        firstRowList.add("确认服务时间");
   
        writeContent2Excels_Contents(destinationFile,resultSheetName,firstRowList,resultMap);

		
	}
	
	
	public void writeContent2Excels_Contents(String destinationTable,String sheetName,List<String> firstRowNames,Map<String,List<String>> map){
		
		
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
