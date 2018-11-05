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

public class CompareContents_JieSuanLiuShui_Field_Jiesuanshouru_Yongjin {
	
	String tag = "AAA";
	
	String sourceFile;
	String destinationFile;
	String ota_name;
	
	// 三张表名
	String jiesuan_bill_sheet;
	String jiesuan_ota_relation_sheet;
	String ota_bill_sheet;
	
	//已结算流水表中需要的字段
	String bill_name_jiesuan;
	String ota_jiesuan;
	String liushui_id_jiesuan;
	String dingdan_id_jiesuan;
	String ota_bill_id_jiesuan;
	String yewumoshi_jiesuan;
	String zhifushishoujine_jiesuan;
	String dingdanrihuilv_jiesuan;
	String jiesuanshouru_jiesuan;
	
	//关联表
	String trade_id_relation;
	String bill_id_relation;
	
	//ota账单表
	String id_ota;
	String sale_amount_ota;
	String due_amount_ota;
	String commission_ota;
	
	
	//已结算流水表中需要的字段的index
	int index_bill_name_jiesuan;
	int index_ota_jiesuan;
	int index_liushui_id_jiesuan;
	int index_dingdan_id_jiesuan;
	int index_ota_bill_id_jiesuan;
	int index_yewumoshi_jiesuan;
	int index_zhifushishoujine_jiesuan;
	int index_dingdanrihuilv_jiesuan;
	int index_jiesuanshouru_jiesuan;
	
	//关联表 中字段的 index
	int index_trade_id_relation;
	int index_bill_id_relation;
	
	// ota账单表 中的字段的index
	int index_id_ota;
	int index_sale_amount_ota;
	int index_due_amount_ota;
	int index_commission_ota;
	

	Map<String,List<List<String>>> jiesuan_bill_map = new HashMap<String, List<List<String>>>();
	
	Map<String,String> relation_map = new HashMap<String,String>();
	
	Map<String,List<String>> ota_map = new HashMap<String, List<String>>();
	
	Map<String,List<String>> result_map = new HashMap<String, List<String>>();
	
	
	
	public CompareContents_JieSuanLiuShui_Field_Jiesuanshouru_Yongjin(String sourceFile,
																		String destinationFile,
																		String ota_name,
																		String jiesuan_bill_sheet,
																		String jiesuan_ota_relation_sheet,
																		String ota_bill_sheet,
																		String bill_name_jiesuan,
																		String ota_jiesuan,
																		String liushui_id_jiesuan,
																		String dingdan_id_jiesuan,
																		String ota_bill_id_jiesuan,
																		String yewumoshi_jiesuan,
																		String zhifushishoujine_jiesuan,
																		String dingdanrihuilv_jiesuan,
																		String jiesuanshouru_jiesuan,
																		String trade_id_relation,
																		String bill_id_relation,
																		String id_ota,
																		String sale_amount_ota,
																		String due_amount_ota,
																		String commission_ota
															){
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.ota_name = ota_name;
		this.jiesuan_bill_sheet = jiesuan_bill_sheet;
		this.jiesuan_ota_relation_sheet = jiesuan_ota_relation_sheet;
		this.ota_bill_sheet = ota_bill_sheet;
		this.bill_name_jiesuan = bill_name_jiesuan;
		this.ota_jiesuan = ota_jiesuan;
		this.liushui_id_jiesuan = liushui_id_jiesuan;
		this.dingdan_id_jiesuan = dingdan_id_jiesuan;
		this.ota_bill_id_jiesuan = ota_bill_id_jiesuan;
		this.yewumoshi_jiesuan = yewumoshi_jiesuan;
		this.zhifushishoujine_jiesuan = zhifushishoujine_jiesuan;
		this.dingdanrihuilv_jiesuan = dingdanrihuilv_jiesuan;
		this.jiesuanshouru_jiesuan = jiesuanshouru_jiesuan;
		this.trade_id_relation = trade_id_relation;
		this.bill_id_relation = bill_id_relation;
		this.id_ota = id_ota;
		this.sale_amount_ota = sale_amount_ota;
		this.due_amount_ota = due_amount_ota;
		this.commission_ota = commission_ota;
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
		
		
        index_bill_name_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, bill_name_jiesuan);
        index_ota_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, ota_jiesuan);
        index_liushui_id_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, liushui_id_jiesuan);
        index_dingdan_id_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, dingdan_id_jiesuan);
        index_ota_bill_id_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, ota_bill_id_jiesuan);
        index_yewumoshi_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, yewumoshi_jiesuan);
        index_zhifushishoujine_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, zhifushishoujine_jiesuan);
        index_dingdanrihuilv_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, dingdanrihuilv_jiesuan);
        index_jiesuanshouru_jiesuan = WriterExcelUtil.getIndexOfFields(xssfRow_jiesuan_bill, jiesuanshouru_jiesuan);
        
        Dailylog.logInfo("index_liushui_id_jiesuan is : " + index_liushui_id_jiesuan);
        
        List<List<String>> list = null;
        ArrayList<String> jiesuan_list = null;
        XSSFRow jiesuan_bill_row = null;
        
        
        for(int x = 1; x < rowLength_jiesuan_bill; x++){

        	jiesuan_bill_row = jiesuan_sheet.getRow(x);
        	
        	
        	jiesuan_list = new ArrayList<String>();
        	
        	
        	XSSFCell jiesuan_cell = null;
        	
        	String bill_name_jiesuan_Str="";
        	String ota_jiesuan_Str="";
        	String liushui_id_jiesuan_Str="";
        	String dingdan_id_jiesuan_Str="";
        	String ota_bill_id_jiesuan_Str="";
        	String yewumoshi_jiesuan_Str="";
        	String zhifushishoujine_jiesuan_Str = "";
        	String dingdanrihuilv_jiesuan_Str="";
        	String jiesuanshouru_jiesuan_Str="";
        	
        	for(int y = 0; y<colLength_jiesuan_bill; y++){
        		
        		jiesuan_cell = jiesuan_bill_row.getCell(y);
        		
        		if(y == index_bill_name_jiesuan){
        			bill_name_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_ota_jiesuan){
        			ota_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_liushui_id_jiesuan){
        			liushui_id_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell,"0");
        		}else if(y == index_dingdan_id_jiesuan){
        			dingdan_id_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_ota_bill_id_jiesuan){
        			ota_bill_id_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_yewumoshi_jiesuan){
        			yewumoshi_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_zhifushishoujine_jiesuan){
        			zhifushishoujine_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_dingdanrihuilv_jiesuan){
        			dingdanrihuilv_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}else if(y == index_jiesuanshouru_jiesuan){
        			jiesuanshouru_jiesuan_Str = WriterExcelUtil.getCellValue(jiesuan_cell);
        		}
        	}
        	
        	//在测试过程中发现在已结算流水中， 流水ID 可能出现等于0的情况，这时候对于0 的情况不会进行存储进map  也就不会进行后续的处理 ，相当于忽略
        	
        	if(!liushui_id_jiesuan_Str.equals("0")){
        		
        		jiesuan_list.add(bill_name_jiesuan_Str);
            	jiesuan_list.add(ota_jiesuan_Str);
            	jiesuan_list.add(dingdan_id_jiesuan_Str);
            	jiesuan_list.add(yewumoshi_jiesuan_Str);
            	jiesuan_list.add(zhifushishoujine_jiesuan_Str);
            	jiesuan_list.add(dingdanrihuilv_jiesuan_Str);
            	jiesuan_list.add(jiesuanshouru_jiesuan_Str);
            	jiesuan_list.add(liushui_id_jiesuan_Str);
            	
            	
            	String key = liushui_id_jiesuan_Str + tag + ota_bill_id_jiesuan_Str;
          
            	String str = judgeExistsOTABILL(ota_bill_id_jiesuan_Str,jiesuan_bill_map);
            	
            	if(str != ""){
//            		Dailylog.logInfo("if-------------------- str is :"+ str +" row is :" + x);
            	
            		List<List<String>> temp_list = jiesuan_bill_map.get(str);
            		
            		//如果已经包含流水ID 和 ota bill id ， 那么将流水ID 作为一个元素存到 jiesuan_list 中
            		
            		temp_list.add(jiesuan_list);
            		
            		jiesuan_bill_map.put(str, temp_list);
            		
            	}else{
//            		Dailylog.logInfo("else ----------------- str is :" + str + "   row is :" + x);
            		list = new ArrayList<List<String>>();
            		
            		list.add(jiesuan_list);	
            		jiesuan_bill_map.put(key, list);
            	}	
        	}
        	
        	
        }
        
        
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
        
        Set<String> keySet = jiesuan_bill_map.keySet();
        
        List<String> keyList = new ArrayList<String>();
        
        for(String str : keySet){
        	
//        	Dailylog.logInfo("==============str is：" + str);
        	
        	
        	keyList.add(str.split(tag)[0]);

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
        index_sale_amount_ota = WriterExcelUtil.getIndexOfFields(xssfRow_ota, sale_amount_ota);
        index_due_amount_ota = WriterExcelUtil.getIndexOfFields(xssfRow_ota, due_amount_ota);
        index_commission_ota = WriterExcelUtil.getIndexOfFields(xssfRow_ota, commission_ota);
        
//        Dailylog.logInfo("index_id_ota is :" + index_id_ota + "      id_ota is :" + id_ota);
//        Dailylog.logInfo("index_sale_amount_ota is :" + index_sale_amount_ota + "      sale_amount_ota is :" + sale_amount_ota);
        
        
        List<String> ota_list = null;
        XSSFRow row_ota = null;
        
        for(int x =1; x<rowLength_ota; x++){
        	
        	ota_list = new ArrayList<String>();
        	row_ota = ota_sheet.getRow(x);
        	
        	XSSFCell ota_cell = null;
        	
        	String id_ota_Str = "";
        	String sale_amount_ota_Str = "";
        	String due_amount_ota_Str = "";
        	String commission_ota_Str = "";
        	
        	for(int y=0; y<colLength_ota;y++){
        		ota_cell = row_ota.getCell(y);
        		
        		if(y == index_id_ota){
        			id_ota_Str = WriterExcelUtil.getCellValue(ota_cell,"0");
        		}else if(y == index_sale_amount_ota){
        			sale_amount_ota_Str = WriterExcelUtil.getCellValue(ota_cell);
        		}else if(y == index_due_amount_ota){
        			due_amount_ota_Str = WriterExcelUtil.getCellValue(ota_cell);
        		}else if(y == index_commission_ota){
        			commission_ota_Str = WriterExcelUtil.getCellValue(ota_cell);
        		}
        	}
        	
//        	Dailylog.logInfo("id_ota_Str is :" + id_ota_Str);
//        	Dailylog.logInfo("sale_amount_ota_Str is :" + sale_amount_ota_Str);
//        	Dailylog.logInfo("due_amount_ota_Str is :" + due_amount_ota_Str);
//        	Dailylog.logInfo("commission_ota_Str is :" + commission_ota_Str);
        	
        	
        	
        	ota_list.add(sale_amount_ota_Str);
        	ota_list.add(due_amount_ota_Str);
        	ota_list.add(commission_ota_Str);
        	
        	ota_map.put(id_ota_Str, ota_list);
        	
//        	Dailylog.logInfo("id_ota_Str is :" + id_ota_Str);
        	
        }
        
//        Dailylog.logInfo("ota map size is :" + ota_map.size());
        
        //开始进行计算
        
        /*
         * 
         * jiesuan_list.add(bill_name_jiesuan_Str);
        	jiesuan_list.add(ota_jiesuan_Str);
        	jiesuan_list.add(dingdan_id_jiesuan_Str);
        	jiesuan_list.add(yewumoshi_jiesuan_Str);
        	jiesuan_list.add(zhifushishoujine_jiesuan_Str);
        	jiesuan_list.add(dingdanrihuilv_jiesuan_Str);
        	jiesuan_list.add(jiesuanshouru_jiesuan_Str);
         * 
         * 
         * */
        
        Set<String> jiesuan_bill_set = jiesuan_bill_map.keySet();
        
        Iterator<String> jiesuan_bill_iterator = jiesuan_bill_set.iterator();
        
        int rowNum = 1;
        
        while(jiesuan_bill_iterator.hasNext()){
        	
        	String liushuiID = jiesuan_bill_iterator.next();
        	Dailylog.logInfo("liushuiID is :" + liushuiID);
        	
        	List<List<String>> jiesuan_List = jiesuan_bill_map.get(liushuiID);

        	//通过liushuiID  获取响应的账单ID  

        	String zhangdanID = relation_map.get(liushuiID.split(tag)[0].trim());
        	
        	Dailylog.logInfo("zhangdanID is :" + zhangdanID);
        	
        	//通过zhangdanID 获取  ota账单表中的需要的字段
        	
        	List<String> zhangdan_list = ota_map.get(zhangdanID);
        	Dailylog.logInfo("zhangdanID is :" + zhangdanID + "zhangdan_list is :" + zhangdan_list + "rowNum is :" + rowNum);
        	
        	double result_f = 0;
        	
        	List<String> report_list = null;
        	
        	if(ota_name.equals("tcc") || ota_name.equals("jalan") || ota_name.equals("jtb")){
        		
        		if(jiesuan_List.size() == 1){
        			
        			Dailylog.logInfo("----------------------1");
        			
        			List<String> first_list = jiesuan_List.get(0);
                	
                	
                	String dingdanrihuilv_1 = first_list.get(5);
                	String jiesuanshouru_1 = first_list.get(6);
                	
//                	Dailylog.logInfo("rowNum is :" + rowNum + "流水ID is：:::" + liushuiID + "结算收入 is :::::" + jiesuanshouru_1);
                	
                	double jiesuanshouru_f = Double.parseDouble(jiesuanshouru_1);
        			
        			
        			String yongjin = zhangdan_list.get(2);
            		
            		double dingdanrihuilv_f = Double.parseDouble(dingdanrihuilv_1);
            		
            		double yongjin_f = Double.parseDouble(yongjin);
            		
            		result_f = yongjin_f*dingdanrihuilv_f;	
            		
            		result_f = WriterExcelUtil.getValidNumbersOfDouble(result_f, "2.11");
            	 	
            	 	
            	 	
                	if(result_f != jiesuanshouru_f){
                		Dailylog.logInfo("result_f is :" + result_f + "   jiesuanshouru_f is:" + jiesuanshouru_f);
                    	
                		report_list = new ArrayList<String>();
                		/*流水ID
                		report_list.add(liushuiID);*/
                		//账单ID 
                		report_list.add(zhangdanID);
                		//账单名
                		report_list.add(first_list.get(0));
                		//ota_name
                		report_list.add(ota_name);
                		//订单id
                		report_list.add(first_list.get(2));
                		//业务模式
                		report_list.add(first_list.get(3));
                		//支付实收金额
                		report_list.add(first_list.get(4));
                		//订单日汇率
                		report_list.add(first_list.get(5));
                		//卖价
                		report_list.add("NA");
                		//结算价
                		report_list.add("NA");
                		//佣金价
                		report_list.add(zhangdan_list.get(2));
                		//结算收入
                		report_list.add(first_list.get(6));
                		//结算收入计算
                		report_list.add(result_f+"");
                		
                		result_map.put(liushuiID, report_list);
          
                	}
        		}else if(jiesuan_List.size() >=2){
        			
//        			Dailylog.logInfo("----------------------2");
        			
//        			Dailylog.logInfo(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ jiesuan_List.get(0).get(2));
        			
        			String yongjin = zhangdan_list.get(2);
        			double yongjin_f = Double.parseDouble(yongjin);
        			String digndanrihuilv_2 = "";
        			
        			
        			List<String> first_list = jiesuan_List.get(0);
                	
                	
                	String dingdanrihuilv_1 = first_list.get(5);
                	String jiesuanshouru_1 = first_list.get(6);
                	
//                	Dailylog.logInfo("rowNum is :" + rowNum + "流水ID is：:::" + liushuiID + "结算收入 is :::::" + jiesuanshouru_1);
                	
                	double jiesuanshouru_f = Double.parseDouble(jiesuanshouru_1);
        			
            		
            		double dingdanrihuilv_f = Double.parseDouble(dingdanrihuilv_1);
            		
            		
            		result_f = yongjin_f*dingdanrihuilv_f;	
            		
            		result_f = WriterExcelUtil.getValidNumbersOfDouble(result_f, "2.11");
        			
        			List<String> zhifushishoujine_list = new ArrayList<String>();
        			
        			for(int x = 0; x <jiesuan_List.size(); x++){
        				
        				List<String> list_2 = jiesuan_List.get(x);
        				
        				digndanrihuilv_2 = list_2.get(5);
        				
        				zhifushishoujine_list.add(list_2.get(4));
        			}
        			
        			double total = 0;
        			
        			for(int x = 0; x <zhifushishoujine_list.size(); x++){
        	
        				String zhifushishou = zhifushishoujine_list.get(x);
        				
        				double zhifushishou_f = Double.parseDouble(zhifushishou);
        				
        				total = total + zhifushishou_f;
        				
        			}
        			
        			if(total == 0){
        				
        				Dailylog.logInfo("---------------2----------------total is >>>>>>>>>>>>> : 0");
        				
        				for(int x = 0; x<jiesuan_List.size();x++){
        					
        					List<String> templist = jiesuan_List.get(x);
        					
        					String jiesuanshouru2 = templist.get(6);
        					
        					Dailylog.logInfo("jiesuanshouru2 >>>>>>>>>>>>>>>>>>>>>:" + jiesuanshouru2);
        					
        					if(!jiesuanshouru2.equals("0.0")){
        						
//        						Dailylog.logInfo("000000000000000000");
        						
        						report_list = new ArrayList<String>();
                        		/*流水ID
                        		report_list.add(liushuiID);*/
                        		//账单ID 
                        		report_list.add(zhangdanID);
                        		//账单名
                        		report_list.add(templist.get(0));
                        		//ota_name
                        		report_list.add(ota_name);
                        		//订单id
                        		report_list.add(templist.get(2));
                        		//业务模式
                        		report_list.add(templist.get(3));
                        		//支付实收金额
                        		report_list.add(templist.get(4));
                        		//订单日汇率
                        		report_list.add(templist.get(5));
                        		//卖价
                        		report_list.add("NA");
                        		//结算价
                        		report_list.add("NA");
                        		//佣金价
                        		report_list.add(zhangdan_list.get(2));
                        		//结算收入
                        		report_list.add(templist.get(6));
                        		//结算收入计算
                        		report_list.add(jiesuanshouru2);
                        		
                        		Dailylog.logInfo("结算收入：" + templist.get(6) + "计算结果：" + jiesuanshouru2);
                        		
                        		result_map.put(templist.get(7)+tag+liushuiID.split(tag)[1], report_list);
        					}
        					
        				}
        				
        				
        				
        			}else{
        				
        				Dailylog.logInfo("--------------------2------------total 不等于 0  >>>");
        				
        				for(int x = 0; x<zhifushishoujine_list.size();x++){
        					
        					String temp_zhifushishou_value = zhifushishoujine_list.get(x);
        					
        					double f = Double.parseDouble(temp_zhifushishou_value);
        				
        					double result = (f/total)*result_f;
        					
        					result = WriterExcelUtil.getValidNumbersOfDouble(result, "2.11");
        					
        					List<String> templist = jiesuan_List.get(x);
        					
        					String jiesuanshouru_2 = templist.get(6);
        					
        					double jiesuanshouru_2_f = Double.parseDouble(jiesuanshouru_2);
        				
        				
        					if(result != jiesuanshouru_2_f){
        						
        						Dailylog.logInfo("result is :" + result +"jiesuanshouru_2_f is :" + jiesuanshouru_2_f);
        						
        						report_list = new ArrayList<String>();
                        		/*流水ID
                        		report_list.add(liushuiID);*/
                        		//账单ID 
                        		report_list.add(zhangdanID);
                        		//账单名
                        		report_list.add(templist.get(0));
                        		//ota_name
                        		report_list.add(ota_name);
                        		//订单id
                        		report_list.add(templist.get(2));
                        		//业务模式
                        		report_list.add(templist.get(3));
                        		//支付实收金额
                        		report_list.add(templist.get(4));
                        		//订单日汇率
                        		report_list.add(templist.get(5));
                        		//卖价
                        		report_list.add("NA");
                        		//结算价
                        		report_list.add("NA");
                        		//佣金价
                        		report_list.add(zhangdan_list.get(2));
                        		//结算收入
                        		report_list.add(templist.get(6));
                        		//结算收入计算
                        		report_list.add(result+"");
                        		
                        		result_map.put(templist.get(7)+tag+liushuiID.split(tag)[1], report_list);	
        					}
        				}
        				
        			}
        			
        			
        			
        		}   	
        	}else if(ota_name.equals("agoda") || ota_name.equals("ctrip_in") || ota_name.equals("elong") || ota_name.equals("ctrip_out")){
        		
        		
        		
        		
        		if(jiesuan_List.size() == 1){
        			
        			
        			List<String> first_list = jiesuan_List.get(0);
                	
                	
                	String dingdanrihuilv_1 = first_list.get(5);
                	String jiesuanshouru_1 = first_list.get(6);
                	
//                	Dailylog.logInfo("rowNum is :" + rowNum + "流水ID is：:::" + liushuiID + "结算收入 is :::::" + jiesuanshouru_1);
                	
                	/*
                	 * ota_list.add(sale_amount_ota_Str);
			        	ota_list.add(due_amount_ota_Str);
			        	ota_list.add(commission_ota_Str);
			        	
			        	ota_map.put(id_ota_Str, ota_list);
                	 * 
                	 * */
                	
                	double jiesuanshouru_f = Double.parseDouble(jiesuanshouru_1);
        			
        			
        			String yongjin = zhangdan_list.get(2);
        			String sellingAmount = zhangdan_list.get(0);
        			String dueAmount = zhangdan_list.get(1);
            		
            		double dingdanrihuilv_f = Double.parseDouble(dingdanrihuilv_1);
            		
            		double sellingAmount_f = Double.parseDouble(sellingAmount);
            		double dueAmount_f = Double.parseDouble(dueAmount);
            		
            		result_f = (sellingAmount_f-dueAmount_f)*dingdanrihuilv_f;	
            		
            		result_f = WriterExcelUtil.getValidNumbersOfDouble(result_f, "2.11");
            	 	
            	 	
//            	 	Dailylog.logInfo("result_f is :" + result_f + "   jiesuanshouru_f is:" + jiesuanshouru_f);
                	
                	if(result_f != jiesuanshouru_f){
                		
                		report_list = new ArrayList<String>();
                		/*流水ID
                		report_list.add(liushuiID);*/
                		//账单ID 
                		report_list.add(zhangdanID);
                		//账单名
                		report_list.add(first_list.get(0));
                		//ota_name
                		report_list.add(ota_name);
                		//订单id
                		report_list.add(first_list.get(2));
                		//业务模式
                		report_list.add(first_list.get(3));
                		//支付实收金额
                		report_list.add(first_list.get(4));
                		//订单日汇率
                		report_list.add(first_list.get(5));
                		//卖价
                		report_list.add(zhangdan_list.get(0));
                		//结算价
                		report_list.add(zhangdan_list.get(1));
                		//佣金价
                		report_list.add("NA");
                		//结算收入
                		report_list.add(first_list.get(6));
                		//结算收入计算
                		report_list.add(result_f+"");
                		
                		result_map.put(liushuiID, report_list);
          
                	}
        		}else if(jiesuan_List.size() >=2){
        			
//        			Dailylog.logInfo(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ jiesuan_List.get(0).get(2));
        			
        			String yongjin = zhangdan_list.get(2);
        			double yongjin_f = Double.parseDouble(yongjin);
        			String digndanrihuilv_2 = "";
        			
        			List<String> zhifushishoujine_list = new ArrayList<String>();
        			
        			for(int x = 0; x <jiesuan_List.size(); x++){
        				
        				List<String> list_2 = jiesuan_List.get(x);
        				
        				digndanrihuilv_2 = list_2.get(5);
        				
        				zhifushishoujine_list.add(list_2.get(4));
        			}
        			
        			double total = 0;
        			
        			for(int x = 0; x <zhifushishoujine_list.size(); x++){
        	
        				String zhifushishou = zhifushishoujine_list.get(x);
        				
        				double zhifushishou_f = Double.parseDouble(zhifushishou);
        				
        				total = total + zhifushishou_f;
        				
        			}
        			
        			if(total == 0){
        				
//        				Dailylog.logInfo("total is >>>>>>>>>>>>> : 0");
        				
        				for(int x = 0; x<jiesuan_List.size();x++){
        					
        					List<String> templist = jiesuan_List.get(x);
        					
        					String jiesuanshouru2 = templist.get(6);
        					
        					
        					
        					if(!jiesuanshouru2.equals("0.0")){
        						report_list = new ArrayList<String>();
                        		/*流水ID
                        		report_list.add(liushuiID);*/
                        		//账单ID 
                        		report_list.add(zhangdanID);
                        		//账单名
                        		report_list.add(templist.get(0));
                        		//ota_name
                        		report_list.add(ota_name);
                        		//订单id
                        		report_list.add(templist.get(2));
                        		//业务模式
                        		report_list.add(templist.get(3));
                        		//支付实收金额
                        		report_list.add(templist.get(4));
                        		//订单日汇率
                        		report_list.add(templist.get(5));
                        		//卖价
                        		report_list.add(zhangdan_list.get(0));
                        		//结算价
                        		report_list.add(zhangdan_list.get(1));
                        		//佣金价
                        		report_list.add("NA");
                        		//结算收入
                        		report_list.add(templist.get(6));
                        		//结算收入计算
                        		report_list.add("0.0");
                        		
                        		result_map.put(templist.get(7)+tag+liushuiID.split(tag)[1], report_list);
        					}
        					
        				}
        				
        				
        				
        			}else{
        				
        				List<String> first_list = jiesuan_List.get(0);
                    	
                    	
                    	String dingdanrihuilv_1 = first_list.get(5);
                    	String jiesuanshouru_1 = first_list.get(6);
                    	
//                    	Dailylog.logInfo("rowNum is :" + rowNum + "流水ID is：:::" + liushuiID + "结算收入 is :::::" + jiesuanshouru_1);
                    	
                    	/*
                    	 * ota_list.add(sale_amount_ota_Str);
    			        	ota_list.add(due_amount_ota_Str);
    			        	ota_list.add(commission_ota_Str);
    			        	
    			        	ota_map.put(id_ota_Str, ota_list);
                    	 * 
                    	 * */
                    	
                    	double jiesuanshouru_f = Double.parseDouble(jiesuanshouru_1);
            			
            			
            			
            			String sellingAmount = zhangdan_list.get(0);
            			String dueAmount = zhangdan_list.get(1);
                		
                		double dingdanrihuilv_f = Double.parseDouble(dingdanrihuilv_1);
                		
                		double sellingAmount_f = Double.parseDouble(sellingAmount);
                		double dueAmount_f = Double.parseDouble(dueAmount);
                		
                		result_f = (sellingAmount_f-dueAmount_f)*dingdanrihuilv_f;	
                		
                		result_f = WriterExcelUtil.getValidNumbersOfDouble(result_f, "2.11");
        				
        				for(int x = 0; x<zhifushishoujine_list.size();x++){
        					
        					Dailylog.logInfo("#######################################################");
        					
        					String temp_zhifushishou_value = zhifushishoujine_list.get(x);
        					
        					double f = Double.parseDouble(temp_zhifushishou_value);
        				
        					double result = (f/total)*result_f;
        					
        					
        					Dailylog.logInfo("x is ：" + x + "   f is :" + f + "   total is :" + total + "   result is :" +  result + "   result_f is :" + result_f);
        					
        					
        					result = WriterExcelUtil.getValidNumbersOfDouble(result, "2.11");
        					
        					
        					
        					List<String> templist = jiesuan_List.get(x);
        					
        					String jiesuanshouru_2 = templist.get(6);
        					
        					double jiesuanshouru_2_f = Double.parseDouble(jiesuanshouru_2);
        				
        					Dailylog.logInfo("2 result is : >>>>>>>>>>>>>>>>>>>>>>>>" + result + "      jiesuanshouru_2_f is :" + jiesuanshouru_2_f);
        					
        				
        					if(result != jiesuanshouru_2_f){
        						
        						report_list = new ArrayList<String>();
                        		/*流水ID
                        		report_list.add(liushuiID);*/
                        		//账单ID 
                        		report_list.add(zhangdanID);
                        		//账单名
                        		report_list.add(templist.get(0));
                        		//ota_name
                        		report_list.add(ota_name);
                        		//订单id
                        		report_list.add(templist.get(2));
                        		//业务模式
                        		report_list.add(templist.get(3));
                        		//支付实收金额
                        		report_list.add(templist.get(4));
                        		//订单日汇率
                        		report_list.add(templist.get(5));
                        		//卖价
                        		report_list.add(zhangdan_list.get(0));
                        		//结算价
                        		report_list.add(zhangdan_list.get(1));
                        		//佣金价
                        		report_list.add("NA");
                        		//结算收入
                        		report_list.add(templist.get(6));
                        		//结算收入计算
                        		report_list.add(result+"");
                        		
                        		result_map.put(templist.get(7)+tag+liushuiID.split(tag)[1], report_list);	
        					}
        				}
        				
        			}
        			
        			
        			
        		}   	
        		
        		
        		
        		
        		
        	}
        	rowNum++;
        }
        
        
        Dailylog.logInfo("result_map size is :" + result_map.size());
        
        List<String> report_First_RowName = new ArrayList<String>();
        
        
        report_First_RowName.add("流水ID");
        report_First_RowName.add("ota 订单ID");
        
        report_First_RowName.add("账单ID");
        report_First_RowName.add("账单名");
        report_First_RowName.add("ota_name");
        
        report_First_RowName.add("订单id");
       
        report_First_RowName.add("业务模式");
        report_First_RowName.add("支付实收金额");
        report_First_RowName.add("订单日汇率");
        
        //涉及到卖价  结算价 用金价   不是每个ota中都有这三个 字段的， 缺少这三个当中的某些字段的， 会认为的加上，但是得到的值是空的，这就需要根据不同的ota
        //在生成report的时候进行筛选
        report_First_RowName.add("卖价");
        report_First_RowName.add("结算价");
        report_First_RowName.add("佣金价");
        report_First_RowName.add("结算收入");
        report_First_RowName.add("结算收入计算");
        
        
        
        writeContent2Excels_Contents(destinationFile,"结算收入",ota_name,report_First_RowName,result_map);
        
	
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
					HSSFCell cell_1 = row.createCell(1);
					
					cell_0.setCellValue(str.split(tag)[0]);
					cell_1.setCellValue(str.split(tag)[1]);
					
					HSSFCell cells = null;
					
					for(int y = 2; y<=list_result.size()+1;y++){
						cells = row.createCell(y);
						
						cells.setCellValue(list_result.get(y-2));
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
