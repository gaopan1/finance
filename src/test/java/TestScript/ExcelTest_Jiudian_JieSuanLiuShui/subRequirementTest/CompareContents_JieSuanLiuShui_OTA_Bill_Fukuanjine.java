package TestScript.ExcelTest_Jiudian_JieSuanLiuShui.subRequirementTest;

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

public class CompareContents_JieSuanLiuShui_OTA_Bill_Fukuanjine {
	
	String tag = "<>";
	
	String sourceFile;
	String destinationFile;
	String ota_name;
	
	// 三张表名
	String jiesuan_bill_sheet;
	String jiesuan_ota_relation_sheet;
	String ota_bill_sheet;
	
	//已结算流水表中需要的字段
	String liushui_id_jiesuan;
	String dingdan_id_jiesuan;
	String ota_bill_id_jiesuan;
	String fukuanjine_yuanbi_jiesuan;
	
	//关联表
	String trade_id_relation;
	String bill_id_relation;
	
	//ota账单表
	String id_ota;
	String fujuanjine_ota;
	
	
	//已结算流水表中需要的字段的index
	int index_liushui_id_jiesuan;
	int index_dingdan_id_jiesuan;
	int index_ota_bill_id_jiesuan;
	int index_fukuanjine_yuanbi_jiesuan;
	
	//关联表 中字段的 index
	int index_trade_id_relation;
	int index_bill_id_relation;
	
	// ota账单表 中的字段的index
	int index_id_ota;
	int index_fujuanjine_ota;
	

	//结算
	List<String> list_jiesuan = new ArrayList<String>();
	Map<String,List<String>> map_jiesuan = new HashMap<String, List<String>>();
	
	//relation 
	Map<String,String> relation_map = new HashMap<String, String>();
	
	// ota
	Map<String,String> ota_map = new HashMap<String, String>();
	
	//结果
	
	Map<String,List<String>> result_map = new HashMap<String, List<String>>();
	
	
	
	public CompareContents_JieSuanLiuShui_OTA_Bill_Fukuanjine(String sourceFile,
																String destinationFile,
																String ota_name,
																String jiesuan_bill_sheet,
																String jiesuan_ota_relation_sheet,
																String ota_bill_sheet,
																//-------------------
																String liushui_id_jiesuan,
																String dingdan_id_jiesuan,
																String ota_bill_id_jiesuan,
																String fukuanjine_yuanbi_jiesuan,
																//-------------
																String trade_id_relation,
																String bill_id_relation,
																//-------------
																String id_ota,
																String fujuanjine_ota
															){
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.ota_name = ota_name;
		this.jiesuan_bill_sheet = jiesuan_bill_sheet;
		this.jiesuan_ota_relation_sheet = jiesuan_ota_relation_sheet;
		this.ota_bill_sheet = ota_bill_sheet;
		//-------------
		this.liushui_id_jiesuan = liushui_id_jiesuan;
		this.dingdan_id_jiesuan = dingdan_id_jiesuan;
		this.ota_bill_id_jiesuan = ota_bill_id_jiesuan;
		this.fukuanjine_yuanbi_jiesuan = fukuanjine_yuanbi_jiesuan;
		//---------------
		this.trade_id_relation = trade_id_relation;
		this.bill_id_relation = bill_id_relation;
		//---------------
		this.id_ota = id_ota;
		this.fujuanjine_ota = fujuanjine_ota;
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
        int index_jiesuan_bill_sheet = xssfWorkbook.getSheetIndex(jiesuan_bill_sheet);
        Dailylog.logInfo("index jiesuan bill sheet is :" + index_jiesuan_bill_sheet);
        XSSFSheet jiesuan_sheet = xssfWorkbook.getSheetAt(index_jiesuan_bill_sheet);
        //总行数
        int rowLength_jiesuan_bill = jiesuan_sheet.getLastRowNum()+1;
        System.out.println("row length of jiesuan bill is :" + rowLength_jiesuan_bill);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_jiesuan_bill = jiesuan_sheet.getRow(0);
        //总列数
        int colLength_jiesuan_bill = xssfRow_jiesuan_bill.getLastCellNum();
        System.out.println("colLength of jiesuan bill is :" + colLength_jiesuan_bill);
		
		
      
        index_liushui_id_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, liushui_id_jiesuan);
        index_dingdan_id_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, dingdan_id_jiesuan);
        index_ota_bill_id_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, ota_bill_id_jiesuan);
        index_fukuanjine_yuanbi_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, fukuanjine_yuanbi_jiesuan);
        
        Dailylog.logInfo("index_liushui_id_jiesuan is : " + index_liushui_id_jiesuan);
        
        List<List<String>> list = null;
        ArrayList<String> jiesuan_list = null;
        XSSFRow jiesuan_bill_row = null;
        
        
        for(int x = 1; x < rowLength_jiesuan_bill; x++){

        	jiesuan_bill_row = jiesuan_sheet.getRow(x);
        	
        	
        	jiesuan_list = new ArrayList<String>();
        	
        	
        	XSSFCell jiesuan_cell = null;
        	
        	
        	String liushui_id_jiesuan_Str="";
        	String dingdan_id_jiesuan_Str="";
        	String ota_bill_id_jiesuan_Str="";
        	String fukuanjine_yuanbi_jiesuan_Str = "";
        	
        	
        	
        	for(int y = 0; y<colLength_jiesuan_bill; y++){
        		
        		jiesuan_cell = jiesuan_bill_row.getCell(y);
        		
        		if(y == index_liushui_id_jiesuan){
        			liushui_id_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell,"0");
        		}else if(y == index_dingdan_id_jiesuan){
        			dingdan_id_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_ota_bill_id_jiesuan){
        			ota_bill_id_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_fukuanjine_yuanbi_jiesuan){
        			fukuanjine_yuanbi_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}
        	}
        	
        	//在测试过程中发现在已结算流水中， 流水ID 可能出现等于0的情况，这时候对于0 的情况不会进行存储进map  也就不会进行后续的处理 ，相当于忽略
        	
        	if(!liushui_id_jiesuan_Str.equals("0")){
        		
        		String combineStr = liushui_id_jiesuan_Str+tag+dingdan_id_jiesuan_Str+tag+ota_bill_id_jiesuan_Str+tag+fukuanjine_yuanbi_jiesuan_Str;
        		
        		boolean flag = true;
        		
        		for(String str : list_jiesuan){
        			String[] strs = str.split(tag);
        			
        			if(strs[0].equals(liushui_id_jiesuan_Str)){
        				//得到list中已经存在的元素的付款金额
        				String fukuanjine = strs[3];
        				double d = Double.parseDouble(fukuanjine);
        				double d1 = Double.parseDouble(fukuanjine_yuanbi_jiesuan_Str);
        				
        				double total = d+d1;
        				
        				combineStr = liushui_id_jiesuan_Str+tag+dingdan_id_jiesuan_Str+tag+ota_bill_id_jiesuan_Str+tag+total+"";
        				
        				list_jiesuan.remove(str);
        				list_jiesuan.add(combineStr); 
        				flag = false;
        				
        				break;
        			}
        		}  
        		
        		if(flag){
        			list_jiesuan.add(combineStr);
        		}
        		
        	}
        	
        	
        }
        
        
        //通过上面的逻辑判断， 现在list_jiesuan 中没有重复的liushui_id_jiesuan_Str， 将 list转成map
        
        List<String> list1 = null;
        
        for(String str : list_jiesuan){
        	
        	list1 = new ArrayList<String>();
        	String[] strs = str.split(tag);
        	
        	list1.add(strs[1]);
        	list1.add(strs[2]);
        	list1.add(strs[3]);
        	
        	map_jiesuan.put(strs[0], list1);

        }
        
        Dailylog.logInfo("map jiesuan size is :" + map_jiesuan.size());
  
        // 关联第二张表    关联关系表格
        
        //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook_relation = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_jiesuan_ota_relation_sheet = xssfWorkbook_relation.getSheetIndex(jiesuan_ota_relation_sheet);
        Dailylog.logInfo("index jiesuan ota relation sheet is :" + index_jiesuan_ota_relation_sheet);
        XSSFSheet relation_sheet = xssfWorkbook.getSheetAt(index_jiesuan_ota_relation_sheet);
        //总行数
        int rowLength_relation = relation_sheet.getLastRowNum()+1;
        System.out.println("row length of relation is :" + rowLength_relation);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_relation = relation_sheet.getRow(0);
        //总列数
        int colLength_relation = xssfRow_relation.getLastCellNum();
        System.out.println("colLength of relation is :" + colLength_relation);
        
        index_trade_id_relation = WriterExcelUtil.getIndexOfFields(xssfRow_relation, trade_id_relation);
        index_bill_id_relation = WriterExcelUtil.getIndexOfFields(xssfRow_relation, bill_id_relation);
        
        XSSFRow row_relation = null;
        
        Set<String> keySet = map_jiesuan.keySet();
        
        List<String> keyList = new ArrayList<String>();
        
        for(String str : keySet){
        	
//        	Dailylog.logInfo("==============str is：" + str);
        	
        	
        	keyList.add(str);

        }
        
        
        for(int x = 1; x <rowLength_relation; x++){
        	
        	row_relation = relation_sheet.getRow(x);
        	
        	String trade_id_relation_Str = "";
        	String bill_id_relation_Str = "";
        	
        	XSSFCell cell_relation = null;
        	
        	for(int y = 0; y<colLength_relation; y++){
        		
        		cell_relation = row_relation.getCell(y);
        		
        		if(y == index_trade_id_relation){
        			trade_id_relation_Str = WriterExcelUtil.getCellValue(cell_relation,"0");
        		}else if(y == index_bill_id_relation){
        			bill_id_relation_Str = WriterExcelUtil.getCellValue(cell_relation,"0");
        		}
        		
        	}
        	
//        	Dailylog.logInfo("trade_id_relation_Str is :::" + trade_id_relation_Str);
//        	Dailylog.logInfo("bill_id_relation_Str is :::" + bill_id_relation_Str);
//        	
        	
        	if(keyList.contains(trade_id_relation_Str)){
        		relation_map.put(trade_id_relation_Str, bill_id_relation_Str);
        	}
        	
        }
        
        Dailylog.logInfo("relation_map size is :" + relation_map.size());
        
       
        
        //关联第三张表  ota账单表
        
        //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook_ota = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_ota_bill_sheet = xssfWorkbook_ota.getSheetIndex(ota_bill_sheet);
        Dailylog.logInfo("index ota bill sheet is :" + index_ota_bill_sheet);
        XSSFSheet ota_sheet = xssfWorkbook.getSheetAt(index_ota_bill_sheet);
        //总行数
        int rowLength_ota = ota_sheet.getLastRowNum()+1;
        System.out.println("row length of ota is :" + rowLength_ota);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_ota = ota_sheet.getRow(0);
        //总列数
        int colLength_ota = xssfRow_ota.getLastCellNum();
        System.out.println("colLength of ota is :" + colLength_ota);
        
        index_id_ota = WriterExcelUtil.getIndexOfFields(xssfRow_ota, id_ota);
        index_fujuanjine_ota = WriterExcelUtil.getIndexOfFields(xssfRow_ota, fujuanjine_ota);
        
        
//        Dailylog.logInfo("index_id_ota is :" + index_id_ota + "      id_ota is :" + id_ota);
//        Dailylog.logInfo("index_sale_amount_ota is :" + index_sale_amount_ota + "      sale_amount_ota is :" + sale_amount_ota);
        
        
        List<String> ota_list = null;
        XSSFRow row_ota = null;
        
        for(int x =1; x<rowLength_ota; x++){
        	
        	ota_list = new ArrayList<String>();
        	row_ota = ota_sheet.getRow(x);
        	
        	XSSFCell ota_cell = null;
        	
        	String id_ota_Str = "";
        	String fujuanjine_ota_Str = "";
        	
        	for(int y=0; y<colLength_ota;y++){
        		ota_cell = row_ota.getCell(y);
        		
        		if(y == index_id_ota){
        			id_ota_Str = WriterExcelUtil.getCellValue(ota_cell,"0");
        		}else if(y == index_fujuanjine_ota){
        			fujuanjine_ota_Str = WriterExcelUtil.getCellValue(ota_cell);
        		}
        	}
        	
        	Dailylog.logInfo("id_ota_Str is :" + id_ota_Str + "     fujuanjine_ota_Str is :" + fujuanjine_ota_Str);
        	
        	if(ota_map.containsKey(id_ota_Str)){
        		String fukuanjine_ota = ota_map.get(id_ota_Str);
        		double d = Double.parseDouble(fukuanjine_ota);
        		
        		double d1 = Double.parseDouble(fujuanjine_ota_Str);
        		double total = d+d1;
        		
        		ota_map.put(id_ota_Str, total+"");
        	}else{
        		ota_map.put(id_ota_Str, fujuanjine_ota_Str);
        	}
        	

        	
        }
        
        
        //进行计算，
        
       Set<String> set_jiesuan =  map_jiesuan.keySet();
        
       Iterator<String> it = set_jiesuan.iterator();
       
       List<String> list_result = null;
       
       while(it.hasNext()){
    	   
    	  String jiesuan_key =  it.next();
    	   
    	  // jieusan_value 中的元素 1，订单ID 2， ota订单ID 3， 付款金额-原币
    	   List<String> jieusan_value = map_jiesuan.get(jiesuan_key);
    	   
    	   //根据流水ID 得到账单ID
    	   String relation_value = relation_map.get(jiesuan_key);
    	   
    	   // 根据账单ID, 得到ota账单中的付款金额
    	   String fukuanjine_ota = ota_map.get(relation_value);
    	   
    	   if(!jieusan_value.get(2).equals(fukuanjine_ota)){
/*    		   //流水ID
    		   list_result.add(jiesuan_key);*/
    		   list_result = new ArrayList<String>();
    		   
    		   //订单ID
    		   list_result.add(jieusan_value.get(0));
    		   // OTA订单ID
    		   list_result.add(jieusan_value.get(1));
    		   //账单ID
    		   list_result.add(relation_value);
    		   //已结算流水中的付款金额-原币
    		   list_result.add(jieusan_value.get(2));
    		   //ota账单中的付款金额
    		   list_result.add(fukuanjine_ota);
    		   
    		   result_map.put(jiesuan_key, list_result);
    		   
    	   }  
       }
        
        
        
        
        
        

        
        List<String> report_First_RowName = new ArrayList<String>();
        
        
        report_First_RowName.add("流水ID");
        report_First_RowName.add("订单ID");
        report_First_RowName.add("ota 订单ID");
        report_First_RowName.add("账单ID");
        report_First_RowName.add("已结算流水中的付款金额-原币");
        report_First_RowName.add("ota账单中的付款金额");
        
        
        
        
        writeContent2Excels_Contents(destinationFile,"付款金额比对结果",ota_name,report_First_RowName,result_map);
        
	
	}
	
	
	public String judgeExistsOTABILL(String otaBILL,Map<String,List<List<String>>> map){
		
		String target = "";
		
		Set<String> set = map.keySet();
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){
			
			String value = it.next();
			
			if(value.contains(otaBILL)){
				target = value;
				break;
			}
			
		}

		return target;
	}
	
	
	
	public void writeContent2Excels_Contents(String destinationTable,String sheetName,String otaName,List<String> firstRowNames,Map<String,List<String>> map){
		
		
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
