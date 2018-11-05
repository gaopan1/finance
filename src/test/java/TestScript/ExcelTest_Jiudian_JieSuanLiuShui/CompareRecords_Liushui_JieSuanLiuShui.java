package TestScript.ExcelTest_Jiudian_JieSuanLiuShui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

public class CompareRecords_Liushui_JieSuanLiuShui {

	
	
	String sourceFile;
	String destinationFile;
	String sheetName_Jiesuan;
	String sheetName_Liushui;
	
	//字段的顺序按照已结算流水表中的字段顺序进行排序
	
	// 已结算流水中的字段
	
	String liushui_id_Jiesuan;
	
	
	int liushui_id_Jiesuan_Index;
	
	
	//---------------------------------
	//流水中的字段
	
	String liushui_id_Liushui;
	
	int liushui_id_Liushui_Index;
	
	
	
	List<String> liuShui_ID_jiesuan = new ArrayList<String>();
	List<String> liuShui_ID_liushui = new ArrayList<String>();

	
	
	
	
	
	
	  public CompareRecords_Liushui_JieSuanLiuShui(String sourceFile,
	  												String destinationFile,
	  												String sheetName_Jiesuan,
	  												String sheetName_Liushui,
													String liushui_id_Jiesuan,
													String liushui_id_Liushui){
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.sheetName_Jiesuan = sheetName_Jiesuan;
		this.sheetName_Liushui = sheetName_Liushui;	
		this.liushui_id_Jiesuan = liushui_id_Jiesuan;
		this.liushui_id_Liushui = liushui_id_Liushui;
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
        int index_Jiesuansheet = xssfWorkbook.getSheetIndex(sheetName_Jiesuan);
        Dailylog.logInfo("index Jiesuansheet is :" + index_Jiesuansheet);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_Jiesuansheet);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
        
        // 得到结算流水表中相应字段的index
       
    	 liushui_id_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, liushui_id_Jiesuan);
    	
    	 
    	 
    	 
    	 XSSFRow row = null;
    	 
    	 ArrayList<String> list_Jiesuan = null;
        
    	 for(int x = 1; x < rowLength; x++){
    		 
    		 row = sheet.getRow(x);
//    		 Dailylog.logInfo("row is null ?" + (row==null));

    		String liushui_id_Jiesuan_Str= "";
    	
    		
    		 for(int y = 0; y<colLength; y++){
    			 
//    			 Dailylog.logInfo("x is :" + x+"    y is ---------：" + y);
    			 XSSFCell xssfCell = row.getCell(y);
    			 
    			
    			 	if(y == liushui_id_Jiesuan_Index){
    				 liushui_id_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }
    		 }
    		 
    	
//    		 Dailylog.logInfo("liushui_id_Jiesuan_Str is :" + liushui_id_Jiesuan_Str);

    		 liuShui_ID_jiesuan.add(liushui_id_Jiesuan_Str);
    		 
    		 
    	 }
    	 
    	  //3.Excel工作表对象
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
     
     	
     
     	Dailylog.logInfo("liushui_id_Liushui_Index is :" + liushui_id_Liushui_Index + "liushui_id_Liushui is :" + liushui_id_Liushui);

     	XSSFRow row_liushui = null;
     	
     	ArrayList<String> list_Liushui = null;
    	 
    	 for(int x = 1; x< rowLength1;x++){
    		 
    		 row_liushui = sheet1.getRow(x);
//    		 Dailylog.logInfo("x is null ?:" + (row1==null));
	
			String liushui_id_Liushui_Str="";
	 
    		 for(int y = 0; y<colLength1; y++){
    			 
//    			 Dailylog.logInfo("x is :：：：" + x +"   y is ：：：：：：" +y);
    			 
    			 XSSFCell xssfCell = row_liushui.getCell(y);
    			 
    			 if(y ==  liushui_id_Liushui_Index){
    				 liushui_id_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }
 	 
    		 }
    		 
    		 liuShui_ID_liushui.add(liushui_id_Liushui_Str);

    	 }
    	 
    	 Dailylog.logInfo("liuShui_ID_jiesuan before size is :" + liuShui_ID_jiesuan.size());
		 Dailylog.logInfo("liuShui_ID_liushui before size is :" + liuShui_ID_liushui.size());

    	 
		 Dailylog.logInfo("liuShui_ID_jiesuan size is :" + liuShui_ID_jiesuan.size());
		 Dailylog.logInfo("liuShui_ID_liushui size is :" + liuShui_ID_liushui.size());
    	 
    	 
    	 List<String> list_liushui_NO = new ArrayList<String>();
    	 List<String> list_jiesuan_N0 = new ArrayList<String>();
    	
  
    	for(String str : liuShui_ID_jiesuan){
    		
    		if(!liuShui_ID_liushui.contains(str)){
    			
    			list_liushui_NO.add(str);
    			
    		}
    		
    		
    	}
    	 
    	
    	for(String str : liuShui_ID_liushui){
    		
    		if(!liuShui_ID_jiesuan.contains(str)){
    			list_jiesuan_N0.add(str);
    		}
    		
    	}
    	
    	
    	Dailylog.logInfo("list_jiesuan_N0 size is :" + list_jiesuan_N0.size());
    	Dailylog.logInfo("list_liushui_NO size is :" + list_liushui_NO.size());
    	 
    	

    	 List<String> firstRowList = new ArrayList<String>();

    	 firstRowList.add("流水ID_流水（没有）");
    	 firstRowList.add("流水ID_结算流水没有）");

    	 writeContent2Excels_Contents(destinationFile,"CompareRecords",firstRowList,list_liushui_NO,list_jiesuan_N0);

	}
	
	
	
public void writeContent2Excels_Contents(String destinationTable,String sheetName,List<String> list,List<String> list_liushui_NO,List<String> list_jiesuan_N0){
		
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
			
			HSSFCell cell = null;
			for(int x = 0; x < list.size(); x++){
				
				cell = firstRow.createCell(x);
				
				cell.setCellValue(list.get(x));	
			}
			
			if(list_liushui_NO.size() >= list_jiesuan_N0.size()){
				
				for(int x = 0; x<(list_liushui_NO.size()-list_jiesuan_N0.size()); x++){
					
					list_jiesuan_N0.add("");
					
				}
	
			}else{
				
				for(int x = 0; x<(list_jiesuan_N0.size()-list_liushui_NO.size()); x++){
					
					list_liushui_NO.add("");
					
				}
	
			}
			
			
			HSSFRow Row = null;
			for(int x = 0; x <list_liushui_NO.size(); x++){
				
				Row = sheet.createRow(x+1);
				
				HSSFCell cell0 = Row.createCell(0);
				HSSFCell cell1 = Row.createCell(1);
				cell0.setCellValue(list_liushui_NO.get(x));
				cell1.setCellValue(list_jiesuan_N0.get(x));
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