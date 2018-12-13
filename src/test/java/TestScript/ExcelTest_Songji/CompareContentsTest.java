package TestScript.ExcelTest_Songji;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;

public class CompareContentsTest {

//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	String sourceFile;
	String destinationFile;
	
	String pay_sheetName;
	String account_sheetName;
	String pay_must_info;
	String account_must_info;
	String getPayColumnName;
	String getAccountColumnName;
	
	int zhifu_id_col;
	int duizhang_id_col;
	
	
	
	public Map<String,String> map_pay = new HashMap();
	
	public List<String> list_pay = new ArrayList<String>();
	
	public Map<String,String> map_account = new HashMap();
	
	public List<String> list_account = new ArrayList<String>();
	
	public Map<String,List<String>> result_map = new HashMap<String,List<String>>();
	
	// 如果是pay 和positive account的比较
	// 　pay_must_info  account_must_info 每个数组里含有四个元素
	
	// 如果是 orders 和 double的比较
	// 那么每个数组里含有两个元素
	

	public CompareContentsTest(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,String getPayColumnName,String getAccountColumnName){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.pay_sheetName = pay_sheetName;
		this.account_sheetName = account_sheetName;
		this.account_must_info = account_must_info;
		this.pay_must_info = pay_must_info;
		this.getPayColumnName = getPayColumnName;
		this.getAccountColumnName = getAccountColumnName;
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
        int index_paysheet = xssfWorkbook.getSheetIndex(pay_sheetName);
        	System.out.println("sheet name is :" + pay_sheetName);
        Dailylog.logInfo("index paysheet is :" + index_paysheet);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_paysheet);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
        
        // 获取订单号 也就是支付id的column的号码zhifu_id_col
        
        for(int x = 0; x< colLength;x++){
        	XSSFCell xssfCell = xssfRow.getCell(x);
        	String cellvalue = xssfCell.getStringCellValue();
        	System.out.println("cellvalue is :" + cellvalue);
        	
        	if(cellvalue.equals(getPayColumnName)){
        		zhifu_id_col = x;
        		System.out.println("zhifu_id_col is :" + zhifu_id_col);
        		break;
        	}
        }
        
        System.out.println("zhifu_id_col out  is :" + zhifu_id_col);
        
        //获取想要获得字段的index  这里想要的字段是pay_must_info
        
        List<String> list = new ArrayList<String>();
        
        for(int x = 0; x <colLength;x++){
        	XSSFCell xssfCell = xssfRow.getCell(x);
        	String str = xssfCell.getStringCellValue();
        	
        	System.out.println("first row of the table is :" + str);
        	list.add(str);
        }
        
        int index = list.indexOf(pay_must_info);
        Dailylog.logInfo("index is :" + index);
        
        //获取支付id 以及 对对应想要获取的字段的取值
        
        for(int x = 1; x <= rowLength-1;x++){
        	xssfRow = sheet.getRow(x);
        	String value = "";
        	String pay_id = "";
        	for(int y =0 ;y<colLength;y++){
        		XSSFCell xssfCell = xssfRow.getCell(y);
//        		Dailylog.logInfo(" x is ::::::: " + x + " y is ::::::" + y + "row length is :" + rowLength);
        		
        		if(index == y){
        			
        			value = WriterExcelUtil.getCellValue(xssfCell).replace("'", "");
        			
//        			Dailylog.logInfo("pay  value >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>is :" + value);
        		}
        		
        		
        		
        		if(zhifu_id_col == y){
        			
        			if(getPayColumnName.equals("业务单号")){
        				pay_id = WriterExcelUtil.getCellValue(xssfCell).replace("'", "").trim();
            			
            			pay_id = pay_id.substring(0, 17);
            			
//            			Dailylog.logInfo("pay id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + pay_id +  "y is :" +y);
            			
        			}else{
        				pay_id = WriterExcelUtil.getCellValue(xssfCell).replace("'", "").trim();
        				
//        				Dailylog.logInfo("pay id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + pay_id +  "y is :" +y);
        			}
        		}
        		
        	}
        	
        	// 将得到的值放到map中
        	map_pay.put(pay_id, value);
        	
        	Set<String> set_pay = map_pay.keySet();
        	
        	Iterator<String> it = set_pay.iterator();
        	
        	while(it.hasNext()){
        		String temp_id = it.next();
        		if(temp_id.equals(pay_id)){
        			String value1 = map_pay.get(temp_id);
        			if(value1 != null && value1.contains("-")){
        				map_pay.put(pay_id, value1.replace("-", ""));
        			}
        		}
        	}
        	
        	
        }
        
        // 关联第二张sheet
        
        int index_accountsheet = xssfWorkbook.getSheetIndex(account_sheetName);
        Dailylog.logInfo("index account is :" + index_accountsheet);
        XSSFSheet sheet_zhengxiang = xssfWorkbook.getSheetAt(index_accountsheet);
        //总行数
        int rowLength_zhengxiang = sheet_zhengxiang.getLastRowNum()+1;
        System.out.println("row length of rowLength_zhengxiang is :" + rowLength_zhengxiang);
        //4.得到Excel工作表的行
        XSSFRow xssfRow_zhengxiang = sheet_zhengxiang.getRow(0);
        //总列数
        int colLength_zhengxiang = xssfRow_zhengxiang.getLastCellNum();
        System.out.println("colLength_zhengxiang is :" + colLength_zhengxiang);
        
        // 获取支付id的列号码 duizhang_id_col
        
        for(int x = 0; x< colLength_zhengxiang;x++){
        	XSSFCell xssfCell = xssfRow_zhengxiang.getCell(x);
        	String cellvalue = xssfCell.getStringCellValue();
        	System.out.println("cellvalue of zhengxiang is :" + cellvalue);
        	
        	if(cellvalue.equals(getAccountColumnName)){
        		duizhang_id_col = x;
        		System.out.println("duizhang_id_col is :" + duizhang_id_col);
        		break;
        	}
        }
        
        // 获取想要获得字段的index  也就是对应的列号
        
        List<String> list1 = new ArrayList<String>();
        
        for(int x = 0; x <colLength_zhengxiang;x++){
        	XSSFCell xssfCell = xssfRow_zhengxiang.getCell(x);
        	String str = xssfCell.getStringCellValue();
        	
        	System.out.println("first row of the table is :" + str);
        	list1.add(str);
        }
        
        int index1 = list1.indexOf(account_must_info);
        
        Dailylog.logInfo("account table >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>is :" + account_sheetName);
        Dailylog.logInfo("account index >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>is :" + index1);
        
        // 得到想要获得字段  也就是支付id  以及 想要获得的内容
        
        for(int x = 1; x <=rowLength_zhengxiang-1;x++){
        	xssfRow_zhengxiang= sheet_zhengxiang.getRow(x);
        	String value = "";
        	String account_id = "";
        	for(int y = 0; y < colLength_zhengxiang; y++){
        		XSSFCell xssfCell = xssfRow_zhengxiang.getCell(y);
//        		Dailylog.logInfo(" x is ::::::: " + x + " y is ::::::" + y + "row length is :" + rowLength_zhengxiang);
        		
        		if(index1 == y){
        			
        			value = WriterExcelUtil.getCellValue(xssfCell);
        					

            		Dailylog.logInfo("account value >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + value + "    x is :" + x);
        		}
        		
        		
        		if(duizhang_id_col == y){
        			
        			account_id = WriterExcelUtil.getCellValue(xssfCell);
        			
//        			Dailylog.logInfo("account_id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + account_id +"zhifu_id_col is :" + duizhang_id_col + "y is :" + y + "     colLength_zhengxiang is ：" + colLength_zhengxiang);
        		}
          		
        		map_account.put(account_id, value);
        		
        		Set<String> set_account = map_account.keySet();
            	
            	Iterator<String> it = set_account.iterator();
            	
            	while(it.hasNext()){
            		String temp_id = it.next();
            		if(temp_id.equals(account_id)){
            			String value1 = map_account.get(temp_id);
            			if(value1 != null && value1.contains("-")){
            				map_account.put(account_id, value1.replace("-", ""));
            			}
            		}
            	}
        		
        	}	
        }
        
        System.out.println("row length pay is :" + rowLength);
        System.out.println("row length account is :" + rowLength_zhengxiang);
        
        System.out.println(map_pay.size());
        System.out.println(map_account.size());
      
        Set<String> set_pay = map_pay.keySet();
        Dailylog.logInfo("set_pay size is :" + set_pay.size());
        Set<String> set_account = map_account.keySet();
        Dailylog.logInfo("set_account size is :" + set_account.size());
        
        
        Set<String> common = new HashSet<>();
        
        if(set_pay.size() >= set_account.size()){
        	for(String str : set_pay){
        		if(set_account.contains(str)){
        			common.add(str);
        		}
        	}
        }else{
        	for(String str : set_account){
//        		Dailylog.logInfo("str is :" + str);
        		if(set_pay.contains(str)){
        			common.add(str);
        			
        		}
        	}	
        }
      
        
        
        
        Dailylog.logInfo("common size is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: "+ common.size());
        
        Iterator<String> it = common.iterator();
        
        List<String> list_detail = null;
        while(it.hasNext()){
        	
        	String id = it.next();
        	
        	String value_pay =null;
        	String value_account = null;
        	
        	if(!pay_must_info.contains("时间")){
        		value_pay =  map_pay.get(id).replace(" ", "");
        		value_account = map_account.get(id).replace(" ", "");
        		
        		boolean b_pay = WriterExcelUtil.isNumberic(value_pay);
        		Dailylog.logInfo("value pay :" + value_pay + "    b_pay is :" + b_pay);
        		boolean b_account = WriterExcelUtil.isNumberic(value_account);
        		Dailylog.logInfo("value account :" + value_account + "    b_account is :" + b_account);
        		
        		if(b_pay && b_account){
        			double d_pay = WriterExcelUtil.getFloatPrice(value_pay);
        			double d_account = WriterExcelUtil.getFloatPrice(value_account);
        			Dailylog.logInfo("d_pay is <<<<<<<<<<<<<<<<:" + d_pay + "d_account is <<<<<<<<<<<<<<:" + d_account);
        			if(d_pay != d_account){
        				
        				Dailylog.logInfo("d_pay is >>>>>>>>>>>>:" + d_pay + "d_account is >>>>>>>>>>>>:" + d_account);
        				list_detail = new ArrayList<String>();
        				list_detail.add(value_pay);
        				list_detail.add(value_account);
        				
        				result_map.put(id, list_detail);
        			}
        		}else{
        			if(!value_pay.equals(value_account)){
                		list_detail = new ArrayList<String>();
                		list_detail.add(value_pay);
                		list_detail.add(value_account);
//                		Dailylog.logInfo("id is :" + id);
//                		Dailylog.logInfo("pay value is :" + value_pay);
//                		Dailylog.logInfo("account value is :" + value_account);
                		
                		result_map.put(id, list_detail);
                	}	
        		}

        	}else{
        		value_pay =  map_pay.get(id);
        		value_account = map_account.get(id);
        		
        		String format = "yyyy-MM-dd";
        		
        		Dailylog.logInfo("id is :" + id);
        	
        		String pay_time = "";
        		
        		System.out.println("value pay is :&&&&&&&&&&&&&&&&&&&&&&&&" + value_pay);
        		
        		try{
        			pay_time = WriterExcelUtil.getFormattedDate(value_pay, format);
        		}catch(Exception e){
        			e.printStackTrace();
        			pay_time = "NA"; 
        		}
        		Dailylog.logInfo("pay time >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is：" + pay_time);
        		
        		String account_time = "";
        		try{
        			account_time = WriterExcelUtil.getFormattedDate(value_account, format);
        		}catch(Exception e){
        			e.printStackTrace();
        			account_time = "NA";
        		}
        		Dailylog.logInfo("account time >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is：" + account_time);
        		
        		
        		if(!pay_time.equals(account_time)){
        			list_detail = new ArrayList<String>();
        			list_detail.add(pay_time);
        			list_detail.add(account_time);
        			
        			result_map.put(id, list_detail);
        		}		
        	}
        }  
        
        Dailylog.logInfo("result map size is :" + result_map.size());
        
        Dailylog.logInfo("pay_must_info is :" + pay_must_info);
        
        WriterExcelUtil.writeContent2Excels_Contents(destinationFile, pay_sheetName+pay_must_info+"_"+account_must_info+account_sheetName,pay_sheetName,account_sheetName,pay_must_info,account_must_info, result_map);
        
        
        
        
	}

}
