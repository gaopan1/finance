package TestScript.ExcelTest_Jiudian_EcouponSplitting.useScenery;

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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;

public class CompareContentS {
	
	String sourceFile;
	String destinationFile;
	
	String sheet_butiechaifen;
	String mfwid_butiechaifen;
	String useScenery_butiechaifen;
	String useScenery_detail_butiechaifen;
	String qudao_butiechaifen;
	String jine_butiechaifen;
	
	String sheet_youhuiquanCenter;
	String mfwid_youhuiquanCenter;
	String useScenery_youhuiquanCenter;
	String useScenery_detail_youhuiquanCenter;
	String qudao_youhuiquanCenter;
	String jine_youhuiquanCenter;
	
	
	int index_mfwid_butiechaifen;
	int index_useScenery_butiechaifen;
	int index_qudao_butiechaifen;
	int index_jine_butiechaifen;
	
	int index_mfwid_youhuiquanCenter;
	int index_useScenery_youhuiquanCenter;
	int index_qudao_youhuiquanCenter;
	int index_jine_youhuiquanCenter;
	
	
	Map<String,List<String>> map_butiechaifen = new HashMap<String,List<String>>();
	
	Map<String,List<String>> map_youhuiquanCenter = new HashMap<String,List<String>>();
	
	List<String> common = new ArrayList<String>();
	
	Map<String,List<List<String>>> map_result = new HashMap<String,List<List<String>>>();
	
	
	public CompareContentS(String sourceFile,
						  String destinationFile,
						  
						  String sheet_butiechaifen,
						  String mfwid_butiechaifen,
						  String useScenery_butiechaifen,
						  String useScenery_detail_butiechaifen,
						  String qudao_butiechaifen,
						  String jine_butiechaifen,
						  
						  String sheet_youhuiquanCenter,
						  String mfwid_youhuiquanCenter,
						  String useScenery_youhuiquanCenter,
						  String useScenery_detail_youhuiquanCenter,
						  String qudao_youhuiquanCenter,
						  String jine_youhuiquanCenter){
		
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		
		this.sheet_butiechaifen = sheet_butiechaifen;
		this.mfwid_butiechaifen = mfwid_butiechaifen;
		this.useScenery_butiechaifen = useScenery_butiechaifen;
		this.useScenery_detail_butiechaifen = useScenery_detail_butiechaifen;
		this.qudao_butiechaifen = qudao_butiechaifen;
		this.jine_butiechaifen = jine_butiechaifen;
		
		this.sheet_youhuiquanCenter = sheet_youhuiquanCenter;
		this.mfwid_youhuiquanCenter = mfwid_youhuiquanCenter;
		this.useScenery_youhuiquanCenter = useScenery_youhuiquanCenter;
		this.useScenery_detail_youhuiquanCenter =useScenery_detail_youhuiquanCenter;
		this.qudao_youhuiquanCenter = qudao_youhuiquanCenter;
		this.jine_youhuiquanCenter = jine_youhuiquanCenter;
		
		
		
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
        int index_butiechaifen = xssfWorkbook.getSheetIndex(sheet_butiechaifen);
        Dailylog.logInfo("index butiechaifen is :" + index_butiechaifen);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_butiechaifen);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
		
		
        
        index_mfwid_butiechaifen = WriterExcelUtil.getIndexOfFields(xssfRow, mfwid_butiechaifen);
        index_useScenery_butiechaifen = WriterExcelUtil.getIndexOfFields(xssfRow, useScenery_butiechaifen);
        index_qudao_butiechaifen = WriterExcelUtil.getIndexOfFields(xssfRow, qudao_butiechaifen);
        index_jine_butiechaifen = WriterExcelUtil.getIndexOfFields(xssfRow, jine_butiechaifen);
        
        XSSFRow butiechaifenRow = null;
        
        List<String> butiechaifenList = null;
        
        
        for(int x =1; x<=rowLength-1;x++){
        	
        	
        	butiechaifenRow = sheet.getRow(x);
        	
        	String mfwid_butiechaifen_Str = "";
        	String useScenery_butiechaifen_Str = "";
        	String qudao_butiechaifen_Str = "";
        	String jine_butiechaifen_Str = "";
        	
        	
        	XSSFCell butiechaifenCell = null;
        	
        	 for(int y = 0; y<colLength; y++){
        		 
        		 butiechaifenCell = butiechaifenRow.getCell(y);
        		 
        		 if(y == index_mfwid_butiechaifen){
        			 mfwid_butiechaifen_Str = WriterExcelUtil.getCellValue(butiechaifenCell);
        		 }else if(y == index_useScenery_butiechaifen){
        			 useScenery_butiechaifen_Str = WriterExcelUtil.getCellValue(butiechaifenCell).trim();
        		 }else if(y == index_qudao_butiechaifen){
        			 qudao_butiechaifen_Str = WriterExcelUtil.getCellValue(butiechaifenCell);
        		 }else if(y == index_jine_butiechaifen){
        			 jine_butiechaifen_Str = WriterExcelUtil.getCellValue(butiechaifenCell);
        		 }
        		 
        	 }
        	 
        	 if(useScenery_butiechaifen_Str.equals(useScenery_detail_butiechaifen)){
        		 
        		 if(map_butiechaifen.containsKey(mfwid_butiechaifen_Str)){
        			 
        			 List<String> tempList = map_butiechaifen.get(mfwid_butiechaifen_Str);
        			 
        			 //去除金额，看是多少
        			 String jine_before = tempList.get(0);
        			 
        			 double d_before = Double.parseDouble(jine_before);
        			 
        			 double d_now = Double.parseDouble(jine_butiechaifen_Str);
        			 
        			 double total = d_before + d_now;
        			 
        			
        			 butiechaifenList = new ArrayList<String>();
        			 
        			 //金额
        			 butiechaifenList.add(total+"");
        			 //渠道
        			 butiechaifenList.add(qudao_butiechaifen_Str);
        			 //使用场景
        			 butiechaifenList.add(useScenery_detail_butiechaifen);
         
        		 }else{
        			 
        			 butiechaifenList = new ArrayList<String>();
        			 
        			 butiechaifenList.add(jine_butiechaifen_Str);
        			 butiechaifenList.add(qudao_butiechaifen_Str);
        			 butiechaifenList.add(useScenery_detail_butiechaifen);
        		 }
        		 
        		 
        		 map_butiechaifen.put(mfwid_butiechaifen_Str, butiechaifenList);
        		 
        		 
        	 }
        }
		
        
        //解析第二个sheet
        
        //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook_center = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_youhuiquanCenter = xssfWorkbook_center.getSheetIndex(sheet_youhuiquanCenter);
        Dailylog.logInfo("index youhuiquanCenter is :" + index_youhuiquanCenter);
        XSSFSheet sheet_youhuiquanCenter = xssfWorkbook_center.getSheetAt(index_youhuiquanCenter);
        //总行数
        int rowLength_youhuiquanCenter = sheet_youhuiquanCenter.getLastRowNum()+1;
        System.out.println("row length of youhuiquanCenter is :" + rowLength_youhuiquanCenter);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_youhuiquanCenter = sheet_youhuiquanCenter.getRow(0);
        //总列数
        int colLength_youhuiquanCenter = xssfRow_youhuiquanCenter.getLastCellNum();
        System.out.println("colLength of youhuiquanCenter is :" + colLength_youhuiquanCenter);
        
        
        
        index_mfwid_youhuiquanCenter = WriterExcelUtil.getIndexOfFields(xssfRow_youhuiquanCenter, mfwid_youhuiquanCenter);
        index_useScenery_youhuiquanCenter = WriterExcelUtil.getIndexOfFields(xssfRow_youhuiquanCenter, useScenery_youhuiquanCenter);
        index_qudao_youhuiquanCenter = WriterExcelUtil.getIndexOfFields(xssfRow_youhuiquanCenter, qudao_youhuiquanCenter);
        index_jine_youhuiquanCenter = WriterExcelUtil.getIndexOfFields(xssfRow_youhuiquanCenter, jine_youhuiquanCenter);
        
        XSSFRow youhuiquanCenter = null;
        
        List<String> youhuiquanCenterList = null;
        
        
        for(int x = 1; x<=rowLength_youhuiquanCenter-1; x++){
        	
        	youhuiquanCenter = sheet_youhuiquanCenter.getRow(x);
        	
        	String mfwid_youhuiquanCenter_Str= "";
        	String useScenery_youhuiquanCenter_Str = "";
        	String qudao_youhuiquanCenter_Str = "";
        	String jine_youhuiquanCenter_Str = "";
        	
        	XSSFCell youhuiquanCenterCell = null;
        	
        	 for(int y = 0; y<colLength_youhuiquanCenter; y++){
        		 
        		 youhuiquanCenterCell = youhuiquanCenter.getCell(y);
        		 
        		 if(y == index_mfwid_youhuiquanCenter){
        			 
        			 mfwid_youhuiquanCenter_Str = WriterExcelUtil.getCellValue(youhuiquanCenterCell);
        			 
        		 }else if(y == index_useScenery_youhuiquanCenter){
        			 useScenery_youhuiquanCenter_Str = WriterExcelUtil.getCellValue(youhuiquanCenterCell);
        		 }else if(y == index_qudao_youhuiquanCenter){
        			 qudao_youhuiquanCenter_Str = WriterExcelUtil.getCellValue(youhuiquanCenterCell);
        		 }else if(y == index_jine_youhuiquanCenter){
        			 jine_youhuiquanCenter_Str = WriterExcelUtil.getCellValue(youhuiquanCenterCell);
        		 }
	 
        	 }
        	 
     
        	
        	 if(useScenery_youhuiquanCenter_Str.equals(useScenery_detail_youhuiquanCenter)){
        		 
        		 if(map_youhuiquanCenter.containsKey(mfwid_youhuiquanCenter_Str)){
        			 
        			 List<String> tempList = map_youhuiquanCenter.get(mfwid_youhuiquanCenter_Str);
        			 
        			 String jine_before = tempList.get(0);
        			 
        			 double d_before = Double.parseDouble(jine_before);
        			 
        			 double d_now = Double.parseDouble(jine_youhuiquanCenter_Str);
        			 
        			 double total = d_before + d_now;
        			 
        			 youhuiquanCenterList = new ArrayList<String>();
        			 
        			 youhuiquanCenterList.add(total+"");
        			 
        			 youhuiquanCenterList.add(qudao_youhuiquanCenter_Str);
        			 
        			 youhuiquanCenterList.add(useScenery_detail_youhuiquanCenter);
        		 }else{
        			 
        			 youhuiquanCenterList = new ArrayList<String>();
        			 
        			 youhuiquanCenterList.add(jine_youhuiquanCenter_Str);
        			 youhuiquanCenterList.add(qudao_youhuiquanCenter_Str);
        			 youhuiquanCenterList.add(useScenery_detail_youhuiquanCenter);
 
        		 }
        		 
        		 map_youhuiquanCenter.put(mfwid_youhuiquanCenter_Str, youhuiquanCenterList);
        		 
        	 }
        }
        
        
        Dailylog.logInfo("map_butiechaifen size is " + map_butiechaifen.size());
        Dailylog.logInfo("map_youhuiquanCenter size is " + map_youhuiquanCenter.size());
        
        
       // 得到common 
        
        Set<String> butiechaifen_set =  map_butiechaifen.keySet();
        Set<String> youhuiquanCenter_set = map_youhuiquanCenter.keySet();
        
        
        if(butiechaifen_set.size() >= youhuiquanCenter_set.size()){
        	
        	for(String str : butiechaifen_set){
        		
        		if(youhuiquanCenter_set.contains(str)){
        			common.add(str);
        		}	
        	}	
        }else{
        	
        	for(String str : youhuiquanCenter_set){
        		if(butiechaifen_set.contains(str)){
        			common.add(str);
        		}
        	}
        }
        
        
        List<String> temp_butiechaifen = null;
        List<String> temp_youhuiquanCenter = null;
        
        List<List<String>> resultList = null;
        
        
        
        
        for(int x =0; x <common.size(); x++){
        	
        	String temp = common.get(x);
        	
        	temp_butiechaifen  = map_butiechaifen.get(temp);
        	temp_youhuiquanCenter = map_youhuiquanCenter.get(temp);
        	
        	List<String> errorNum = new ArrayList<String>();

        	for(int y = 0 ;y<temp_butiechaifen.size(); y++){
        		
        		String butiechaifenString = temp_butiechaifen.get(y);
            	String youhuiquanCenterString = temp_youhuiquanCenter.get(y);
        		
        		if(!butiechaifenString.equals(youhuiquanCenterString)){
        			
        			errorNum.add(y+"");
        			
        		}
        		
        	}
        	
        	if(errorNum.size() != 0){
    			resultList = new ArrayList<List<String>>();
    			
    			resultList.add(temp_butiechaifen);
    			resultList.add(temp_youhuiquanCenter);
    			resultList.add(errorNum);
    			
    			map_result.put(temp, resultList);
        	}
        	
        	
        }
        
        Dailylog.logInfo("map result size is :" + map_result.size());
        
        
        List<String> firstRowNames = new ArrayList<String>();
        
        firstRowNames.add("MFW订单ID");
        firstRowNames.add("金额");
        firstRowNames.add("渠道");
        firstRowNames.add("使用场景");
        
        
        
        
        

		
        writeContent2Excels_Contents(destinationFile,useScenery_detail_butiechaifen+"_Contents",firstRowNames,map_result);
		
		
		
	}
	
	
	public void writeContent2Excels_Contents(String destinationTable,String sheetName,List<String> firstRowNames,Map<String,List<List<String>>> map_result){
		
		
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
			
			
			if(map_result.size() != 0){
				
				
				Set<String> resultSet = map_result.keySet();
				
				Iterator<String> it = resultSet.iterator();
				
				List<String> tempList = null;
				
				int rowNum = 1;
				
				HSSFRow row1 = null;
				HSSFCell cell1 = null;
				
				CellStyle style= book.createCellStyle();
				
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				while(it.hasNext()){
					
					Dailylog.logInfo("rowNum is :" + rowNum);
					
					String str = it.next();
					
					List<List<String>> list = map_result.get(str);
					
					List<String> errorList = list.get(list.size()-1);
					for(int x = 0; x<list.size()-1;x++){
						Dailylog.logInfo("x is :" + x);
						
						tempList = list.get(x);
						
						row1 = sheet.createRow(rowNum);
						
						cell1 = row1.createCell(0);
						cell1.setCellValue(str);
						
						for(int y = 0; y<tempList.size(); y++){
							cell1 = row1.createCell(y+1);
							cell1.setCellValue(tempList.get(y));
							
							if(errorList.contains(y+"")){

								cell1.setCellStyle(style);
							}
						}
						
						rowNum++;
			
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
