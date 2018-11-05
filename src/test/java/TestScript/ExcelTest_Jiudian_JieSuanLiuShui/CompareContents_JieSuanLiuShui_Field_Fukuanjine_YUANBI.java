package TestScript.ExcelTest_Jiudian_JieSuanLiuShui;

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

public class CompareContents_JieSuanLiuShui_Field_Fukuanjine_YUANBI {
	
	
	String sourceFile;
	String destinationFile;
	String jiesuan_sheet;
	String otaName;
	String liushuiID;
	String dingdanID;
	String ota_dingdanID;
	String yewumoshi;
	String dingdanrihuilv;
	String yingjiesuanjine;
	String duizhangchayi;
	String jiesuanshouru;
	String fukuanjine_YUANBI;
	
	int index_sourceFile;
	int index_destinationFile;
	int index_jiesuan_sheet;
	
	int index_liushuiID;
	int index_dingdanID;
	int index_ota_dingdanID;
	int index_yewumoshi;
	int index_dingdanrihuilv;
	int index_yingjiesuanjine;
	int index_duizhangchayi;
	int index_jiesuanshouru;
	int index_fukuanjine_YUANBI;
	
	
	Map<String,List<String>> map_jiesuan = new HashMap<String,List<String>>();
	
	
	public CompareContents_JieSuanLiuShui_Field_Fukuanjine_YUANBI(String sourceFile,
																String destinationFile,
																String jiesuan_sheet,
																String otaName,
																String liushuiID,
																String dingdanID,
																String ota_dingdanID,
																String yewumoshi,
																String dingdanrihuilv,
																String yingjiesuanjine,
																String duizhangchayi,
																String jiesuanshouru,
																String fukuanjine_YUANBI){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.jiesuan_sheet = jiesuan_sheet;
		this.otaName = otaName;
		this.liushuiID = liushuiID;
		this.dingdanID = dingdanID;
		this.ota_dingdanID = ota_dingdanID;
		this.yewumoshi = yewumoshi;
		this.dingdanrihuilv = dingdanrihuilv;
		this.yingjiesuanjine = yingjiesuanjine;
		this.duizhangchayi = duizhangchayi;
		this.jiesuanshouru = jiesuanshouru;
		this.fukuanjine_YUANBI = fukuanjine_YUANBI;
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
        int index_paysheet = xssfWorkbook.getSheetIndex(jiesuan_sheet);
        Dailylog.logInfo("index jiesuan sheet is :" + index_paysheet);
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
         * 
         * int index_liushuiID;
			int index_dingdanID;
			int index_ota_dingdanID;
			int index_yewumoshi;
			int index_yingjiesuanjine;
			int index_duizhangchayi;
			int index_jiesuanshouru;
			int index_fukuanjine_YUANBI;
         * 
         * 
         * */
		
        index_liushuiID = WriterExcelUtil.getIndexOfFields(xssfRow, liushuiID);
        index_dingdanID = WriterExcelUtil.getIndexOfFields(xssfRow,dingdanID);
        index_ota_dingdanID = WriterExcelUtil.getIndexOfFields(xssfRow, ota_dingdanID);
        index_yewumoshi = WriterExcelUtil.getIndexOfFields(xssfRow, yewumoshi);
        index_dingdanrihuilv = WriterExcelUtil.getIndexOfFields(xssfRow, dingdanrihuilv);
        index_yingjiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, yingjiesuanjine);
        index_duizhangchayi = WriterExcelUtil.getIndexOfFields(xssfRow, duizhangchayi);
        index_jiesuanshouru = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanshouru);
        index_fukuanjine_YUANBI = WriterExcelUtil.getIndexOfFields(xssfRow, fukuanjine_YUANBI);
      
        
        
        
        List<String> list = null;
        XSSFRow row = null;

        for(int x = 1; x <= rowLength-1; x++){
        	
        	list = new ArrayList<String>();
        	row = sheet.getRow(x);
        	
        	String liushuiID_Str = "";
        	String dingdanID_Str = "";
        	String ota_dingdanID_Str = "";
        	String yewumoshi_Str = "";
        	String dingdanrihuilv_Str = "";
        	String yingjiesuanjine_Str = "";
        	String duizhangchayi_Str = "";
        	String jiesuanshouru_Str = "";
        	String fukuanjine_YUANBI_Str = "";
              
             XSSFCell cell = null;
              
              for(int y = 0; y<colLength;y++){
            	  
            	  cell = row.getCell(y);
            	  
            	  if(y == index_liushuiID){
            		  liushuiID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_dingdanID){
            		  dingdanID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_ota_dingdanID){
            		  ota_dingdanID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_yewumoshi){
            		  yewumoshi_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_dingdanrihuilv){
            		  dingdanrihuilv_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_yingjiesuanjine){
            		  yingjiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_duizhangchayi){
            		  duizhangchayi_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_jiesuanshouru){
            		  jiesuanshouru_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_fukuanjine_YUANBI){
            		  fukuanjine_YUANBI_Str = WriterExcelUtil.getCellValue(cell);
            	  }
              }
            
              
              Dailylog.logInfo("liushuiID_Str >>>>>>>>>>>>>>>>>:::::" + liushuiID_Str);
              Dailylog.logInfo("dingdanID_Str >>>>>>>>>>>>>>>>>:::::" + dingdanID_Str);
              Dailylog.logInfo("ota_dingdanID_Str >>>>>>>>>>>>>>>>>:::::" + ota_dingdanID_Str);
              Dailylog.logInfo("yewumoshi_Str >>>>>>>>>>>>>>>>>:::::" + yewumoshi_Str);
              Dailylog.logInfo("dingdanrihuilv_Str >>>>>>>>>>>>>>>>>:::::" + dingdanrihuilv_Str);
              Dailylog.logInfo("yingjiesuanjine_Str >>>>>>>>>>>>>>>>>:::::" + yingjiesuanjine_Str);
              Dailylog.logInfo("duizhangchayi_Str >>>>>>>>>>>>>>>>>:::::" + duizhangchayi_Str);
              Dailylog.logInfo("jiesuanshouru_Str >>>>>>>>>>>>>>>>>:::::" + jiesuanshouru_Str);
              Dailylog.logInfo("fukuanjine_YUANBI_Str >>>>>>>>>>>>>>>>>:::::" + fukuanjine_YUANBI_Str);

              
             double dou_dingdanrihuilv = Double.parseDouble(dingdanrihuilv_Str);
             double dou_yingjiesuanjine = Double.parseDouble(yingjiesuanjine_Str);
             double dou_duizhangchayi = Double.parseDouble(duizhangchayi_Str);
             double dou_jiesuanshouru = Double.parseDouble(jiesuanshouru_Str);
             double dou_fukuanjine_YUANBI = Double.parseDouble(fukuanjine_YUANBI_Str);
             
             dou_dingdanrihuilv = WriterExcelUtil.getValidNumbersOfDouble(dou_dingdanrihuilv, "2.1111");
             dou_yingjiesuanjine = WriterExcelUtil.getValidNumbersOfDouble(dou_yingjiesuanjine, "2.11");
             dou_duizhangchayi = WriterExcelUtil.getValidNumbersOfDouble(dou_duizhangchayi, "2.11");
             dou_jiesuanshouru = WriterExcelUtil.getValidNumbersOfDouble(dou_jiesuanshouru, "2.11");
             dou_fukuanjine_YUANBI = WriterExcelUtil.getValidNumbersOfDouble(dou_fukuanjine_YUANBI, "2.11");
             
             double dou_yingjiesuanjine_YUANBI = dou_yingjiesuanjine/dou_dingdanrihuilv;
             double dou_duizhangchayi_YUANBI = dou_duizhangchayi/dou_dingdanrihuilv;
             double dou_jiesuanshouru_YUANBI = dou_jiesuanshouru/dou_dingdanrihuilv;
             
             
             double calculate_Result = 99999.99;
              
             if(otaName.equals("tcc") || otaName.equals("ctrip_out") || otaName.equals("ctrip_in") || otaName.equals("jalan")){
            	 
            	 calculate_Result = dou_yingjiesuanjine_YUANBI - dou_duizhangchayi_YUANBI-dou_jiesuanshouru_YUANBI;
  	 
            	 calculate_Result = WriterExcelUtil.getValidNumbersOfDouble(calculate_Result, "2.11"); 
            	 	
             }else{
 
            	 calculate_Result = dou_yingjiesuanjine_YUANBI - dou_duizhangchayi_YUANBI;
            	 calculate_Result = WriterExcelUtil.getValidNumbersOfDouble(calculate_Result, "2.11");
             }
             
             if(dou_fukuanjine_YUANBI != calculate_Result){
            	 
            	list.add(dingdanID_Str);
              	list.add(ota_dingdanID_Str);
              	list.add(yingjiesuanjine_Str);
              	list.add(duizhangchayi_Str);
              	list.add(jiesuanshouru_Str);
            	 
            	list.add(fukuanjine_YUANBI_Str);
            	list.add(calculate_Result+"");
            	
            	map_jiesuan.put(liushuiID_Str, list);
            	 
             }
 	
        }
        
        
        List<String> firstRowNameList = new ArrayList<String>();
        
        firstRowNameList.add("流水ID");
        firstRowNameList.add("订单ID");
        firstRowNameList.add("OTA订单ID");
        firstRowNameList.add("应结算金额");
        firstRowNameList.add("对账差异");
        firstRowNameList.add("结算收入");
        firstRowNameList.add("付款金额-原币");
        firstRowNameList.add("付款金额-原币（计算结果）");
        
        
        
        writeContent2Excels_Contents(destinationFile,"付款金额-原币",firstRowNameList,map_jiesuan);
        
	
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
					
					HSSFCell cell_0 = row.createCell(0);
					
					cell_0.setCellValue(str);
					
					HSSFCell cells = null;
					
					for(int y = 1; y<=list_result.size();y++){
						cells = row.createCell(y);
						
						cells.setCellValue(list_result.get(y-1));
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
