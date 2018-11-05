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

public class CompareContents_JieSuanLiuShui_Field_Jiesuanjine {
	
	
	String sourceFile;
	String destinationFile;
	String jiesuan_sheet;
	String liushuiID;
	String dingdanID;
	String yingjiesuanjine;
	String ota_dingdanID;
	String duizhangchayi;
	String ota_bianjia;
	String xianshangpeifu;
	String xianxiapeifu;
	String qita;
	String jiesuanjine;
	
	int index_liushuiID;
	int index_dingdanID;
	int index_yingjiesuanjine;
	int index_ota_dingdanID;
	int index_duizhangchayi;
	int index_ota_bianjia;
	int index_xianshangpeifu;
	int index_xianxiapeifu;
	int index_qita;
	int index_jiesuanjine;
	
	
	Map<String,List<String>> map_jiesuan = new HashMap<String,List<String>>();
	
	
	public CompareContents_JieSuanLiuShui_Field_Jiesuanjine(String sourceFile,
															String destinationFile,
															String jiesuan_sheet,
															String liushuiID,
															String dingdanID,
															String yingjiesuanjine,
															String ota_dingdanID,
															String duizhangchayi,
															String ota_bianjia,
															String xianshangpeifu,
															String xianxiapeifu,
															String qita,
															String jiesuanjine){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.jiesuan_sheet = jiesuan_sheet;
		this.liushuiID = liushuiID;
		this.dingdanID = dingdanID;
		this.yingjiesuanjine = yingjiesuanjine;
		this.ota_dingdanID = ota_dingdanID;
		this.duizhangchayi = duizhangchayi;
		this.ota_bianjia = ota_bianjia;
		this.xianshangpeifu = xianshangpeifu;
		this.xianxiapeifu = xianxiapeifu;
		this.qita = qita;
		this.jiesuanjine = jiesuanjine;
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
        index_yingjiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, yingjiesuanjine);
    	index_ota_dingdanID = WriterExcelUtil.getIndexOfFields(xssfRow, ota_dingdanID);
        index_duizhangchayi = WriterExcelUtil.getIndexOfFields(xssfRow, duizhangchayi);
    	index_ota_bianjia = WriterExcelUtil.getIndexOfFields(xssfRow, ota_bianjia);
    	index_xianshangpeifu = WriterExcelUtil.getIndexOfFields(xssfRow, xianshangpeifu);
    	index_xianxiapeifu = WriterExcelUtil.getIndexOfFields(xssfRow, xianxiapeifu);
    	index_qita = WriterExcelUtil.getIndexOfFields(xssfRow, qita);
    	index_jiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanjine);
        
        List<String> list = null;
        XSSFRow row = null;

        for(int x = 1; x <= rowLength-1; x++){
        	
        	list = new ArrayList<String>();
        	row = sheet.getRow(x);
        	
        	  String liushuiID_Str = "";
              String dingdanID_Str = "";
              String yingjiesuanjine_Str = "";
              String ota_dingdanID_Str = "";
              String duizhangchayi_Str = "";
              String ota_bianjia_Str = "";
              String xianshangpeifu_Str = "";
              String xianxiapeifu_Str = "";
              String qita_Str = "";
              String jiesuanjine_Str = "";
              
             XSSFCell cell = null;
              
              for(int y = 0; y<colLength;y++){
            	  
            	  cell = row.getCell(y);
            	  
            	  if(y == index_liushuiID){
            		  liushuiID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_dingdanID){
            		  dingdanID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_yingjiesuanjine){
            		  yingjiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_ota_dingdanID){
            		  ota_dingdanID_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_duizhangchayi){
            		  duizhangchayi_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_ota_bianjia){
            		  ota_bianjia_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_xianshangpeifu){
            		  xianshangpeifu_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_xianxiapeifu){
            		  xianxiapeifu_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_qita){
            		  qita_Str = WriterExcelUtil.getCellValue(cell);
            	  }else if(y == index_jiesuanjine){
            		  jiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
            	  }
              }
              Dailylog.logInfo("index_yingjiesuanjine is :" + index_yingjiesuanjine);
              Dailylog.logInfo("x is :" + x +"      yingjiesuanjine_Str is：" + yingjiesuanjine_Str);
             
              
             double dou_yingjiesuanjine = Double.parseDouble(yingjiesuanjine_Str);
             double dou_duizhangchayi = Double.parseDouble(duizhangchayi_Str);
             double dou_jiesuanjine = Double.parseDouble(jiesuanjine_Str);
             
             dou_yingjiesuanjine = WriterExcelUtil.getValidNumbersOfDouble(dou_yingjiesuanjine, "2.11");
             dou_duizhangchayi = WriterExcelUtil.getValidNumbersOfDouble(dou_duizhangchayi, "2.11");
             
             
             double calculate_jiesuanjine = dou_yingjiesuanjine-dou_duizhangchayi;
              
             if(calculate_jiesuanjine != dou_jiesuanjine){
            	list.add(dingdanID_Str);
             	list.add(ota_dingdanID_Str);
             	list.add(yingjiesuanjine_Str);
             	list.add(duizhangchayi_Str);
             	list.add(ota_bianjia_Str);
             	list.add(xianshangpeifu_Str);
             	list.add(xianxiapeifu_Str);
             	list.add(qita_Str);  	
             	list.add(jiesuanjine_Str);
             	list.add(calculate_jiesuanjine + "");
             	
             	map_jiesuan.put(liushuiID_Str, list);
             }
 	
        }
        
        
        List<String> firstRowNameList = new ArrayList<String>();
        
        firstRowNameList.add("流水ID");
        firstRowNameList.add("订单ID");
        firstRowNameList.add("OTA订单ID");
        firstRowNameList.add("应结算金额");
        firstRowNameList.add("对账差异");
        firstRowNameList.add("ota变价");
        firstRowNameList.add("线上赔付");
        firstRowNameList.add("线下赔付");
        firstRowNameList.add("其它");
        firstRowNameList.add("结算金额");
        firstRowNameList.add("结算金额(计算结果)");
        
        
        
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
