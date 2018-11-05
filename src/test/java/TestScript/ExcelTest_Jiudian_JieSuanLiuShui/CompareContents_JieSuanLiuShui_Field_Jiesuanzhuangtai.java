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

public class CompareContents_JieSuanLiuShui_Field_Jiesuanzhuangtai {

	
	
	String sourceFile;
	String destinationFile;
	String sheetName_Jiesuan;
	String sheetName_Liushui;
	String jiesuan_Status;
	
	//字段的顺序按照已结算流水表中的字段顺序进行排序
	
	// 已结算流水中的字段
	
	String liushui_id_Jiesuan;
	
	
	int liushui_id_Jiesuan_Index;
	
	
	//---------------------------------
	//流水中的字段
	
	String liushui_id_Liushui;
	String jiesuanzhuangtai_Liushui;
	
	int liushui_id_Liushui_Index;
	int jiesuanzhuangtai_Liushui_index;
	
	
	
	Map<String,String> map = new HashMap<String,String>();

	
	
	
	
	
	
	  public CompareContents_JieSuanLiuShui_Field_Jiesuanzhuangtai(String sourceFile,
	  												String destinationFile,
	  												String sheetName_Jiesuan,
	  												String sheetName_Liushui,
	  												String jiesuan_Status,
													String liushui_id_Jiesuan,
													String liushui_id_Liushui,
													String jiesuanzhuangtai_Liushui){
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.sheetName_Jiesuan = sheetName_Jiesuan;
		this.sheetName_Liushui = sheetName_Liushui;	
		this.jiesuan_Status = jiesuan_Status;
		this.liushui_id_Jiesuan = liushui_id_Jiesuan;
		this.liushui_id_Liushui = liushui_id_Liushui;
		this.jiesuanzhuangtai_Liushui = jiesuanzhuangtai_Liushui;
	}
	
	@Test
	public void test() throws Exception{
		
		File file = new File(sourceFile);
		
		if(file.exists()){
			System.out.println("exists");
		}
		
		
		 //2.Excel工作薄对象
		 XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
         int index_Liushuisheet = xssfWorkbook.getSheetIndex(sheetName_Liushui);
         Dailylog.logInfo("index Liushuisheet is :" + index_Liushuisheet);
         XSSFSheet sheet1 = xssfWorkbook.getSheetAt(index_Liushuisheet);
         //总行数
         int rowLength1 = sheet1.getLastRowNum()+1;
         System.out.println("row length is :" + rowLength1);
         //4.得到Excel工作表的行
         XSSFRow xssfRow1 = sheet1.getRow(0);
         //总列数
         int colLength1 = xssfRow1.getLastCellNum();
         System.out.println("colLength1 is :" + colLength1);
         
    	 
         // 得到流水表中相应字段的indexdingdan_id_Liushui_Index
         
     
     	
     	liushui_id_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, liushui_id_Liushui);
     	jiesuanzhuangtai_Liushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, jiesuanzhuangtai_Liushui);
     	
     
     	Dailylog.logInfo("liushui_id_Liushui_Index is :" + liushui_id_Liushui_Index + "liushui_id_Liushui is :" + liushui_id_Liushui);

     	XSSFRow row_liushui = null;
     	
     	ArrayList<String> list_Liushui = null;
    	 
    	 for(int x = 1; x< rowLength1;x++){
    		 
    		 row_liushui = sheet1.getRow(x);
//    		 Dailylog.logInfo("x is null ?:" + (row1==null));
	
			String liushui_id_Liushui_Str="";
			String jiesuanzhuangtai_Liushui_Str = "";
	 
    		 for(int y = 0; y<colLength1; y++){
    			 
//    			 Dailylog.logInfo("x is :：：：" + x +"   y is ：：：：：：" +y);
    			 
    			 XSSFCell xssfCell = row_liushui.getCell(y);
    			 
    			 if(y ==  liushui_id_Liushui_Index){
    				 liushui_id_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == jiesuanzhuangtai_Liushui_index){
    				 jiesuanzhuangtai_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }
 	 
    		 }
    		 
    		 if(!jiesuanzhuangtai_Liushui_Str.equals(jiesuan_Status)){
    			 
    			 map.put(liushui_id_Liushui_Str, jiesuanzhuangtai_Liushui_Str);
    			 
    			 
    		 }
    		
    	 }
    	
        
    	 
    	 

    	 List<String> firstRowList = new ArrayList<String>();

    	 firstRowList.add("流水ID_流水");
    	 firstRowList.add("结算状态");

    	 writeContent2Excels_Contents(destinationFile,"结算状态",firstRowList,map);

	}
	
	
	
public void writeContent2Excels_Contents(String destinationTable,String sheetName,List<String> list,Map<String,String> map){
		
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
//				Dailylog.logInfo("m is :" + m + "temp_sheetName is :" + temp_sheetName+ "temp_sheetName length is :" + temp_sheetName.length());
//				Dailylog.logInfo("m is :" + m + "sheet name is :" + sheetName);
				if(temp_sheetName.equals(sheetName)){
					Dailylog.logInfo("+++++++++++++++++++++++++++++++++++++++++++++");
					book.removeSheetAt(m);
					break;
				}
			}
			//创建sheet
			HSSFSheet sheet = book.createSheet(sheetName);
			
			HSSFRow firstRow = sheet.createRow(0);
			
			
			for(int x =0; x<list.size(); x++){
				
				HSSFCell HSSFCell_0 = firstRow.createCell(x);
				HSSFCell_0.setCellValue(list.get(x));
			}
			
		
			if(map.size() != 0){
				
				Set<String> set = map.keySet();
				
				Iterator<String> it = set.iterator();
				
				HSSFRow  row = null;
				
				int num = 1;
				
				while(it.hasNext()){
					
					String key = it.next();
					String value = map.get(key);
					
					row = sheet.createRow(num);
					
					HSSFCell cell0 = row.createCell(0);
					cell0.setCellValue(key);
					HSSFCell cell1 = row.createCell(1);
					cell1.setCellValue(value);
					
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