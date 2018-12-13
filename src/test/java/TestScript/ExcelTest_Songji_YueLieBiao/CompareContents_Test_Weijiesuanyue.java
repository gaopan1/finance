package TestScript.ExcelTest_Songji_YueLieBiao;

import static org.hamcrest.CoreMatchers.nullValue;

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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;

public class CompareContents_Test_Weijiesuanyue<V> {
	
	
	String sourceFile;
	String destinationFile;
	String shishou_sheetName;
	String yijiesuan_sheetName;
	String weijiesuan_sheetName;

	
	//需要从表中获取的字段
	
	String mark;
	String dingdanshu;
	String zhifujine;
	String butiejine;
	String gongyingshangbutie;
	String yingjiesuanjine;
	String jiesuanjine;
	String jiesuanjine_RMB;
	String shouru;

	
	
	//实收
	
	int index_mark;
	int index_dingdanshu;
	int index_zhifujine;
	int index_butiejine;
	int index_gongyingshangbutie;
	int index_yingjiesuanjine;
	int index_jiesuanjine;
	int index_jiesuanjine_RMB;
	int index_shouru;
	
	
	// index 已结算
	
	int index_mark_yijiesuan;
	int index_dingdanshu_yijiesuan;
	int index_zhifujine_yijiesuan;
	int index_butiejine_yijiesuan;
	int index_gongyingshangbutie_yijiesuan;
	int index_yingjiesuanjine_yijiesuan;
	int index_jiesuanjine_yijiesuan;
	int index_jiesuanjine_RMB_yijiesuan;
	int index_shouru_yijiesuan;
	
	// index 未结算
	
	int index_mark_weijiesuan;
	int index_dingdanshu_weijiesuan;
	int index_zhifujine_weijiesuan;
	int index_butiejine_weijiesuan;
	int index_gongyingshangbutie_weijiesuan;
	int index_yingjiesuanjine_weijiesuan;
	int index_jiesuanjine_weijiesuan;
	int index_jiesuanjine_RMB_weijiesuan;
	int index_shouru_weijiesuan;
	
	
	Map<String,List<String>> shishou_map =  new HashMap<String, List<String>>();
	Map<String,List<String>> yijiesuan_map =  new HashMap<String, List<String>>();
	Map<String,List<String>> weijiesuan_map =  new HashMap<String, List<String>>();
	
	

	public CompareContents_Test_Weijiesuanyue(String sourceFile,
										String destinationFile,
										String shishou_sheetName,
										String yijiesuan_sheetName,
										String weijiesuan_sheetName,
										//-------
										String mark,
										String dingdanshu,
										String zhifujine,
										String butiejine,
										String gongyingshangbutie,
										String yingjiesuanjine,
										String jiesuanjine,
										String jiesuanjine_RMB,
										String shouru){
		
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.shishou_sheetName = shishou_sheetName;
		this.yijiesuan_sheetName = yijiesuan_sheetName;
		this.weijiesuan_sheetName = weijiesuan_sheetName;

		
		this.mark = mark;
		this.dingdanshu = dingdanshu;
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
        int index_sheet_shishou = xssfWorkbook.getSheetIndex(shishou_sheetName);
        Dailylog.logInfo("index shishou is :" + index_sheet_shishou);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_sheet_shishou);
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
			int index_jiesuanjine_RMB;
			int index_shouru;
         * 
         * */
        
        
        index_mark = WriterExcelUtil.getIndexOfFields(xssfRow, mark);
        index_dingdanshu = WriterExcelUtil.getIndexOfFields(xssfRow, dingdanshu);
        index_zhifujine = WriterExcelUtil.getIndexOfFields(xssfRow, zhifujine);
        index_butiejine = WriterExcelUtil.getIndexOfFields(xssfRow, butiejine);
        index_gongyingshangbutie = WriterExcelUtil.getIndexOfFields(xssfRow, gongyingshangbutie);
        index_yingjiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, yingjiesuanjine);
        index_jiesuanjine = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanjine);
        index_jiesuanjine_RMB = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanjine_RMB);
        index_shouru = WriterExcelUtil.getIndexOfFields(xssfRow, shouru);
        
        Dailylog.logInfo("index_mark is ：" + index_mark);
        Dailylog.logInfo("index_dingdanshu is ：" + index_dingdanshu);
        Dailylog.logInfo("index_zhifujine is ：" + index_zhifujine);
        Dailylog.logInfo("index_butiejine is ：" + index_butiejine);
        Dailylog.logInfo("index_gongyingshangbutie is ：" + index_gongyingshangbutie);
        Dailylog.logInfo("index_yingjiesuanjine is ：" + index_yingjiesuanjine);
        Dailylog.logInfo("index_jiesuanjine is :" + index_jiesuanjine);
        Dailylog.logInfo("index_jiesuanjine_RMB is ：" + index_jiesuanjine_RMB);
        Dailylog.logInfo("index_shouru is ：" + index_shouru);
        
        
        XSSFRow row = null;
        
        List<String> list_shishou = null;
        
        for(int x =1; x<=rowLength-1; x++){
        	
        	row = sheet.getRow(x);
        	
        	XSSFCell cell = null;
        	
        	String mark_Str = "";
        	String dingdanshu_Str = "";
        	String zhifujine_Str = "";
        	String butiejine_Str = "";
        	String gongyingshangbutie_Str = "";
        	String yingjiesuanjine_Str = "";
        	String jiesuanjine_Str = "";
        	String jiesuanjine_RMB_Str = "";
        	String shouru_Str = "";
        	
        	list_shishou = new ArrayList<String>();
        	
        	for(int y =0; y<colLength; y++){
        		
        		
        		
        		cell = row.getCell(y);
        		
        		if(y == index_mark){
        			mark_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_dingdanshu){
        			dingdanshu_Str = WriterExcelUtil.getCellValue(cell, "0");
        		}else if(y == index_zhifujine){
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
        	
        	}
        	
        	list_shishou.add(dingdanshu_Str);
        	list_shishou.add(zhifujine_Str);
        	list_shishou.add(butiejine_Str);
        	list_shishou.add(gongyingshangbutie_Str);
        	list_shishou.add(yingjiesuanjine_Str);
        	list_shishou.add(jiesuanjine_Str);
        	list_shishou.add(jiesuanjine_RMB_Str);
        	list_shishou.add(shouru_Str);
        	
        	shishou_map.put(mark_Str, list_shishou);
        	
        }
        
        
        // 已结算
       
        int index_sheet_yijiesuan = xssfWorkbook.getSheetIndex(yijiesuan_sheetName);
        Dailylog.logInfo("yijiesuan_sheetName is :" + yijiesuan_sheetName);
        Dailylog.logInfo("index yijiesuan is :" + index_sheet_yijiesuan);
        XSSFSheet sheet_yijiesuan = xssfWorkbook.getSheetAt(index_sheet_yijiesuan);
        //总行数
        int rowLength_yijiesuan = sheet_yijiesuan.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength_yijiesuan);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_yijiesuan = sheet_yijiesuan.getRow(0);
        //总列数
        int colLength_yijiesuan = xssfRow_yijiesuan.getLastCellNum();
        System.out.println("colLength is :" + colLength_yijiesuan);
        
        
        index_mark_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, mark);
        index_dingdanshu_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, dingdanshu);
        index_zhifujine_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, zhifujine);
        index_butiejine_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, butiejine);
        index_gongyingshangbutie_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, gongyingshangbutie);
        index_yingjiesuanjine_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, yingjiesuanjine);
        index_jiesuanjine_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, jiesuanjine);
        index_jiesuanjine_RMB_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, jiesuanjine_RMB);
        index_shouru_yijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_yijiesuan, shouru);
        
        Dailylog.logInfo("index_mark_yijiesuan is ：" + index_mark_yijiesuan);
        Dailylog.logInfo("index_dingdanshu_yijiesuan is ：" + index_dingdanshu_yijiesuan);
        Dailylog.logInfo("index_zhifujine_yijiesuan is ：" + index_zhifujine_yijiesuan);
        Dailylog.logInfo("index_butiejine_yijiesuan is ：" + index_butiejine_yijiesuan);
        Dailylog.logInfo("index_gongyingshangbutie_yijiesuan is ：" + index_gongyingshangbutie_yijiesuan);
        Dailylog.logInfo("index_yingjiesuanjine_yijiesuan is ：" + index_yingjiesuanjine_yijiesuan);
        Dailylog.logInfo("index_jiesuanjine_yijiesuan is :" + index_jiesuanjine_yijiesuan);
        Dailylog.logInfo("index_jiesuanjine_RMB_yijiesuan is ：" + index_jiesuanjine_RMB_yijiesuan);
        Dailylog.logInfo("index_shouru_yijiesuan is ：" + index_shouru_yijiesuan);
        
        
        XSSFRow row_yijiesuan = null;
        
        List<String> list_yijiesuan = null;
        
        for(int x =1; x<=rowLength_yijiesuan-1; x++){
        	
        	row_yijiesuan = sheet_yijiesuan.getRow(x);
        	
        	XSSFCell cell = null;
        	
        	String mark_Str = "";
        	String dingdanshu_Str = "";
        	String zhifujine_Str = "";
        	String butiejine_Str = "";
        	String gongyingshangbutie_Str = "";
        	String yingjiesuanjine_Str = "";
        	String jiesuanjine_Str = "";
        	String jiesuanjine_RMB_Str = "";
        	String shouru_Str = "";
        	
        	Dailylog.logInfo("mark_Str>>>>>>>>>>>>>>>>>> is :" + mark_Str);
        	
        	list_yijiesuan = new ArrayList<String>();
        	
        	for(int y =0; y<colLength_yijiesuan; y++){
        		
        		
        		
        		cell = row_yijiesuan.getCell(y);
        		
        		if(y == index_mark_yijiesuan){
        			mark_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_dingdanshu_yijiesuan){
        			dingdanshu_Str = WriterExcelUtil.getCellValue(cell, "0");
        		}else if(y == index_zhifujine_yijiesuan){
        			zhifujine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_butiejine_yijiesuan){
        			butiejine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_gongyingshangbutie_yijiesuan){
        			gongyingshangbutie_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_yingjiesuanjine_yijiesuan){
        			yingjiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_jiesuanjine_yijiesuan){
        			jiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_jiesuanjine_RMB_yijiesuan){
        			jiesuanjine_RMB_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_shouru_yijiesuan){
        			shouru_Str = WriterExcelUtil.getCellValue(cell);
        		}   	
        	
        	}
        	
        	Dailylog.logInfo("mark_Str is :" +mark_Str);
        	
        	list_yijiesuan.add(dingdanshu_Str);
        	list_yijiesuan.add(zhifujine_Str);
        	list_yijiesuan.add(butiejine_Str);
        	list_yijiesuan.add(gongyingshangbutie_Str);
        	list_yijiesuan.add(yingjiesuanjine_Str);
        	list_yijiesuan.add(jiesuanjine_Str);
        	list_yijiesuan.add(jiesuanjine_RMB_Str);
        	list_yijiesuan.add(shouru_Str);
        	
        	yijiesuan_map.put(mark_Str, list_yijiesuan);
        	
        }
        
        
        // 未结算
        
        int index_sheet_weijiesuan = xssfWorkbook.getSheetIndex(weijiesuan_sheetName);
        Dailylog.logInfo("index weijiesuan is :" + index_sheet_weijiesuan);
        XSSFSheet sheet_weijiesuan = xssfWorkbook.getSheetAt(index_sheet_weijiesuan);
        //总行数
        int rowLength_weijiesuan = sheet_weijiesuan.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength_weijiesuan);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_weijiesuan = sheet_weijiesuan.getRow(0);
        //总列数
        int colLength_weijiesuan = xssfRow_weijiesuan.getLastCellNum();
        System.out.println("colLength is :" + colLength_weijiesuan);
        
        
        index_mark_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, mark);
        index_dingdanshu_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, dingdanshu);
        index_zhifujine_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, zhifujine);
        index_butiejine_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, butiejine);
        index_gongyingshangbutie_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, gongyingshangbutie);
        index_yingjiesuanjine_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, yingjiesuanjine);
        index_jiesuanjine_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, jiesuanjine);
        index_jiesuanjine_RMB_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, jiesuanjine_RMB);
        index_shouru_weijiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_weijiesuan, shouru);
        
        Dailylog.logInfo("index_mark_weijiesuan is ：" + index_mark_weijiesuan);
        Dailylog.logInfo("index_dingdanshu_weijiesuan is ：" + index_dingdanshu_weijiesuan);
        Dailylog.logInfo("index_zhifujine_weijiesuan is ：" + index_zhifujine_weijiesuan);
        Dailylog.logInfo("index_butiejine_weijiesuan is ：" + index_butiejine_weijiesuan);
        Dailylog.logInfo("index_gongyingshangbutie_weijiesuan is ：" + index_gongyingshangbutie_weijiesuan);
        Dailylog.logInfo("index_yingjiesuanjine_weijiesuan is ：" + index_yingjiesuanjine_weijiesuan);
        Dailylog.logInfo("index_jiesuanjine_weijiesuan is :" + index_jiesuanjine_weijiesuan);
        Dailylog.logInfo("index_jiesuanjine_RMB_weijiesuan is ：" + index_jiesuanjine_RMB_weijiesuan);
        Dailylog.logInfo("index_shouru_weijiesuan is ：" + index_shouru_weijiesuan);
        
        
        XSSFRow row_weijiesuan = null;
        
        List<String> list_weijiesuan = null;
        
        for(int x =1; x<=rowLength_weijiesuan-1; x++){
        	
        	row_weijiesuan = sheet_weijiesuan.getRow(x);
        	
        	XSSFCell cell = null;
        	
        	String mark_Str = "";
        	String dingdanshu_Str = "";
        	String zhifujine_Str = "";
        	String butiejine_Str = "";
        	String gongyingshangbutie_Str = "";
        	String yingjiesuanjine_Str = "";
        	String jiesuanjine_Str = "";
        	String jiesuanjine_RMB_Str = "";
        	String shouru_Str = "";
        	
        	list_weijiesuan = new ArrayList<String>();
        	
        	for(int y =0; y<colLength_weijiesuan; y++){
        		
        		
        		
        		cell = row_weijiesuan.getCell(y);
        		
        		if(y == index_mark_weijiesuan){
        			mark_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_dingdanshu_weijiesuan){
        			dingdanshu_Str = WriterExcelUtil.getCellValue(cell, "0");
        		}else if(y == index_zhifujine_weijiesuan){
        			zhifujine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_butiejine_weijiesuan){
        			butiejine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_gongyingshangbutie_weijiesuan){
        			gongyingshangbutie_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_yingjiesuanjine_weijiesuan){
        			yingjiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_jiesuanjine_weijiesuan){
        			jiesuanjine_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_jiesuanjine_RMB_weijiesuan){
        			jiesuanjine_RMB_Str = WriterExcelUtil.getCellValue(cell);
        		}else if(y == index_shouru_weijiesuan){
        			shouru_Str = WriterExcelUtil.getCellValue(cell);
        		}   	
        	
        	}
        	
        	Dailylog.logInfo("mark_Str is :" + mark_Str +"dingdanshu_Str is :"+ dingdanshu_Str);
        	list_weijiesuan.add(dingdanshu_Str);
        	list_weijiesuan.add(zhifujine_Str);
        	list_weijiesuan.add(butiejine_Str);
        	list_weijiesuan.add(gongyingshangbutie_Str);
        	list_weijiesuan.add(yingjiesuanjine_Str);
        	list_weijiesuan.add(jiesuanjine_Str);
        	list_weijiesuan.add(jiesuanjine_RMB_Str);
        	list_weijiesuan.add(shouru_Str);
        	
        	weijiesuan_map.put(mark_Str, list_weijiesuan);
        	
        }
        
        Dailylog.logInfo("shishou_map size is :" + shishou_map.size());
        Dailylog.logInfo("yijiesuan_map size is :" + yijiesuan_map.size());
        Dailylog.logInfo("weijiesuan_map size is :" + weijiesuan_map.size());
        Dailylog.logInfo("weijiesuan_map is :::::::::::::::::::::::::" + weijiesuan_map.toString());
        
        
        
        Set<String> shishou_Set = shishou_map.keySet();
        Set<String> yijiesuan_Set = yijiesuan_map.keySet();
        Set<String> weijiesuan_Set = weijiesuan_map.keySet();
        
        Iterator<String> it = shishou_Set.iterator();
        
        Map<String,List<List<String>>> result_map = new HashMap<String, List<List<String>>>();
        
        List<List<String>> result_list = null;
        
        while(it.hasNext()){
        	
        	List<String> list_shishou_temp = null;
            List<String> list_yijiesuan_temp = null;
            List<String> list_weijiesuan_temp = null;
            List<String> errorList = new ArrayList<String>();
            
        	
        	String value_shishou = it.next();
//        	Dailylog.logInfo("value_shishou is :" + value_shishou);
        	
        	list_shishou_temp = shishou_map.get(value_shishou);
//        	Dailylog.logInfo("list_shishou_temp is :" + list_shishou_temp);
        	
        	if(yijiesuan_Set.contains(value_shishou)){
        		list_yijiesuan_temp = yijiesuan_map.get(value_shishou);
        	}
//        	Dailylog.logInfo("list_yijiesuan_temp is :" + list_yijiesuan_temp);
        	
        	if(weijiesuan_Set.contains(value_shishou)){
        		list_weijiesuan_temp = weijiesuan_map.get(value_shishou);
        	}
        	
//        	Dailylog.logInfo("list_weijiesuan_temp is :" + list_weijiesuan_temp);
        	
        	if(list_yijiesuan_temp != null){
        		
        		Dailylog.logInfo("if ----------------------------------");
        		
        		for(int x =0; x<list_yijiesuan_temp.size(); x++){
        			String temp_shi = list_shishou_temp.get(x);
        			String temp_yijie = list_yijiesuan_temp.get(x);
        			String temp_weijie = list_weijiesuan_temp.get(x);
        			
        			if(x == 0){
        				int int_shi = Integer.parseInt(temp_shi);
        				int int_yijie = Integer.parseInt(temp_yijie);
        				int int_weijie = Integer.parseInt(temp_weijie);
//        				Dailylog.logInfo("----------------------------------int_weijie is :" + int_weijie);
        				int result = int_shi -int_yijie;
        				
        				if(result != int_weijie){
        					errorList.add(x+"");
        				}
        				
        			}else{
        				
        				double dou_shi =  Double.parseDouble(temp_shi);
        				dou_shi = WriterExcelUtil.getValidNumbersOfDouble(dou_shi, "2.11");
        				double dou_yijie =  Double.parseDouble(temp_yijie);
        				dou_yijie = WriterExcelUtil.getValidNumbersOfDouble(dou_yijie, "2.11");
        				double dou_weijie =  Double.parseDouble(temp_weijie);
        				dou_weijie = WriterExcelUtil.getValidNumbersOfDouble(dou_weijie, "2.11");
        				
        				double result = dou_shi-dou_yijie;
        				
        				if(result != dou_weijie){
        					errorList.add(x+"");
        				}
        				
        			}
        			
        		}
        		
        		if(errorList.size() != 0){
        			result_list = new ArrayList<List<String>>();
        			
        			Dailylog.logInfo("list_shishou_temp is<<<<<<<<<<<<<<<, :" + list_shishou_temp.toString() + "value_shishou is :" +value_shishou);
        			Dailylog.logInfo("list_yijiesuan_temp is<<<<<<<<<<<<<<<, :" + list_yijiesuan_temp.toString() + "value_shishou is :" +value_shishou);
        			Dailylog.logInfo("list_weijiesuan_temp is <<<<<<<<<<<<<<<<:" + list_weijiesuan_temp.toString() + "value_shishou is :" +value_shishou);
        			Dailylog.logInfo("errorList is <<<<<<<<<<<<<<<<<:" + errorList.toString() + "value_shishou is :" +value_shishou);
        			
            		result_list.add(list_shishou_temp);
            		result_list.add(list_yijiesuan_temp);
            		result_list.add(list_weijiesuan_temp);
            		result_list.add(errorList);
            		
            		result_map.put(value_shishou, result_list);
            	}
        		
        		
        		
        	}else{
        		
        		
        		Dailylog.logInfo("else ----------------------------------");
        		
        		for(int x = 0; x<list_shishou_temp.size(); x++){
        			
        			String temp_shi = list_shishou_temp.get(x);
        			String temp_weijie = list_weijiesuan_temp.get(x);
        			
        			if(!temp_shi.equals(temp_weijie)){
        				errorList.add(x+"");
        			}
        		}
        		
        		
        		if(errorList.size() != 0){
        			result_list = new ArrayList<List<String>>();
        			

        			
            		result_list.add(list_shishou_temp);
            		result_list.add(list_weijiesuan_temp);
            		result_list.add(errorList);
            		
            		result_map.put(value_shishou, result_list);
            	}    
        		
        		
        	}

        }
        
        
        Dailylog.logInfo("result_map size is :" + result_map.size());
        
        
        
       
		
		
		List<String> firstRowNames = new ArrayList<String>();
		firstRowNames.add("订单数");
		firstRowNames.add("支付金额");
		firstRowNames.add("补贴金额");
		firstRowNames.add("供应商补贴");
		firstRowNames.add("应结算金额");
		firstRowNames.add("结算金额");
		firstRowNames.add("结算金额（RMB)");
		firstRowNames.add("收入");

		writeContent2Excels_Records(destinationFile,firstRowNames,result_map);
		
	}
	

	
	
	public void writeContent2Excels_Records(String destinationTable,List<String> firstRowNames,Map<String,List<List<String>>> result_map) throws Exception{
		
		
		WriterExcelUtil.createNewExcelFile(destinationTable);
		
		
		HSSFWorkbook book = null;
		
		
//		createNewExcels(destinationTable);
		
		//自己手动创建没有问题  但是程序创建就会有问题
		
		try{
			//1，创建操作xlsx的对象
			
			File file = new File(destinationTable);
			
			FileInputStream fis = new FileInputStream(file);
			
			book = new HSSFWorkbook(fis);
			
			CellStyle style = WriterExcelUtil.getCellStyle(book, "red");
			
			
			if(result_map.size()!=0){
				
				Set<String> set = result_map.keySet();
				
				Iterator<String> it = set.iterator();
				
				while(it.hasNext()){
					
					String sheetName = it.next();
					
					Dailylog.logInfo("sheet name is ------------------------:" + sheetName);
					
					
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
					 
					 HSSFRow row1 = sheet.createRow(0);
						HSSFCell cell1 = null;
						
						for(int x =0; x<firstRowNames.size(); x++){
							
							cell1 = row1.createCell(x);
							
							cell1.setCellValue(firstRowNames.get(x));
						}
					 
					List<List<String>> list = result_map.get(sheetName);
					Dailylog.logInfo("length is :::::" + list.size());
					
					List<String> errorlist = list.get(list.size()-1);
					
					for(int x = 1; x<= list.size()-1; x++){
						
						HSSFRow row = sheet.createRow(x);
						
						HSSFCell cell = null;
						
						List<String> list_temp = list.get(x-1);
						
//						Dailylog.logInfo(list_temp.toString());
						
						for(int y = 0; y<list_temp.size(); y++){
							
							cell = row.createCell(y);
							
							cell.setCellValue(list_temp.get(y));
							
							if(errorlist.contains(y+"")){
								
								WriterExcelUtil.setCellColor(style, cell);
								
							}
						}

					}
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
