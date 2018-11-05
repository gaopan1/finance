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

public class CompareContents_JieSuanLiuShui_Field_Jiesuanshouru_Jiajia {
	
	
	String sourceFile;
	String destinationFile;
	String jiesuan_sheet;
	
	String liushuiID;
	String dingdanID;
	String shijixiaoshoujia;
	String ota_dingdanID;
	String chengbenjia;
	String jiesuanshouru;
	
	int index_liushuiID;
	int index_dingdanID;
	int index_shijixiaoshoujia;
	int index_ota_dingdanID;
	int index_chengbenjia;
	int index_jiesuanshouru;
	
	
	
	
	Map<String,List<String>> map_jiesuan = new HashMap<String,List<String>>();
	
	
	public CompareContents_JieSuanLiuShui_Field_Jiesuanshouru_Jiajia(String sourceFile,
															String destinationFile,
															String jiesuan_sheet,
															String liushuiID,
															String dingdanID,
															String shijixiaoshoujia,
															String ota_dingdanID,
															String chengbenjia,
															String jiesuanshouru){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.jiesuan_sheet = jiesuan_sheet;
		this.liushuiID = liushuiID;
		this.dingdanID = dingdanID;
		this.shijixiaoshoujia = shijixiaoshoujia;
		this.ota_dingdanID = ota_dingdanID;
		this.chengbenjia = chengbenjia;
		this.jiesuanshouru =jiesuanshouru;
	
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
		
		
        index_liushuiID = WriterExcelUtil.getIndexOfFields(xssfRow, liushuiID);
        index_dingdanID = WriterExcelUtil.getIndexOfFields(xssfRow,dingdanID);
        index_shijixiaoshoujia = WriterExcelUtil.getIndexOfFields(xssfRow, shijixiaoshoujia);
    	index_ota_dingdanID = WriterExcelUtil.getIndexOfFields(xssfRow, ota_dingdanID);
    	index_chengbenjia = WriterExcelUtil.getIndexOfFields(xssfRow, chengbenjia);
    	index_jiesuanshouru = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanshouru);
    	
        
        List<String> list = null;
        XSSFRow row = null;

        for(int x = 1; x <= rowLength-1; x++){
        	
        	list = new ArrayList<String>();
        	row = sheet.getRow(x);
        	
        	  String liushuiID_Str = "";
              String dingdanID_Str = "";
              String shijixiaoshoujia_Str = "";
              String ota_dingdanID_Str = "";
              String chengbenjia_Str = "";
              String jiesuanshouru_Str = "";
              
              
              
             XSSFCell cell = null;
              
              for(int y = 0; y<colLength;y++){
            	  
            	  cell = row.getCell(y);
            	  
            	  if(y == index_liushuiID){
            		  liushuiID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_dingdanID){
            		  dingdanID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_shijixiaoshoujia){
            		  shijixiaoshoujia_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_ota_dingdanID){
            		  ota_dingdanID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_chengbenjia){
            		  chengbenjia_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_jiesuanshouru){
            		  jiesuanshouru_Str = WriterExcelUtil.getCellValue(cell);
            	  }
              }
              
//              Dailylog.logInfo("liushuiID_Str is >>>>>>>>>>:" + liushuiID_Str);
//              Dailylog.logInfo("dingdanID_Str is >>>>>>>>>>:" + dingdanID_Str);
//              Dailylog.logInfo("shijixiaoshoujia_Str is >>>>>>>>>>:" + shijixiaoshoujia_Str);
//              Dailylog.logInfo("ota_dingdanID_Str is >>>>>>>>>>:" + ota_dingdanID_Str);
//              Dailylog.logInfo("chengbenjia_Str is >>>>>>>>>>:" + chengbenjia_Str);
//              Dailylog.logInfo("jiesuanshouru_Str is >>>>>>>>>>:" + jiesuanshouru_Str);
              
              
           
          
              double shijixiaoshoujia_double = WriterExcelUtil.getFloatPrice(shijixiaoshoujia_Str);
              double chengbenjia_double = WriterExcelUtil.getFloatPrice(chengbenjia_Str);
              double jiesuanshouru_double = WriterExcelUtil.getFloatPrice(jiesuanshouru_Str);
              
              
             
              shijixiaoshoujia_double = WriterExcelUtil.getValidNumbersOfDouble(shijixiaoshoujia_double, "2.11");
              chengbenjia_double = WriterExcelUtil.getValidNumbersOfDouble(chengbenjia_double, "2.11");
              jiesuanshouru_double = WriterExcelUtil.getValidNumbersOfDouble(jiesuanshouru_double, "2.11");
             
             double calculate_jiesuanshouru = shijixiaoshoujia_double-chengbenjia_double;
             
             calculate_jiesuanshouru = WriterExcelUtil.getValidNumbersOfDouble(calculate_jiesuanshouru, "2.11");
              
             if(calculate_jiesuanshouru != jiesuanshouru_double){
            	 
            	list.add(dingdanID_Str);
             	list.add(ota_dingdanID_Str);
             	list.add(shijixiaoshoujia_Str);
             	list.add(chengbenjia_Str);
             	list.add(jiesuanshouru_Str);
             	list.add(calculate_jiesuanshouru+"");
             	
             
             	
             	map_jiesuan.put(liushuiID_Str, list);
             }
 	
        }
        
        
        List<String> firstRowNameList = new ArrayList<String>();
        
        firstRowNameList.add("流水ID");
        firstRowNameList.add("订单ID");
        firstRowNameList.add("OTA订单ID");
        firstRowNameList.add("实际销售价");
        firstRowNameList.add("成本价");
        firstRowNameList.add("结算收入");
        firstRowNameList.add("结算收入(计算结果)");
        
        
        
        writeContent2Excels_Contents(destinationFile,"结算金额",firstRowNameList,map_jiesuan);
        
	
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
