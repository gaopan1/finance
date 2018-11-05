package TestScript.ExcelTest_Jiudian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

public class CompareContents_Tuikuan_Zhifu_Rate_Test {

//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	
	String sourceFile;
	String destinationFile;
	
	String pay_sheetName;
	String account_sheetName;
	String liuShuiLeixing;
	String getPayColumnName;
	String getAccountColumnName;
	String chengBenJia_RMB;
	String salesPrice;
	String actual_SalesPrice;
	String zhifu_Shishou_Jine;
	String yuguyongjin;
	String butie_zhekou;
	String butie_fengmi;
	String butie_youhuiquan;
	String butie;
	String baobiaoshouru;
	String feiyong;
	String fanxian;
	
	int zhifu_id_col;
	int duizhang_id_col;
	int liuShuiLeixing_col;
	int chengBenJia_RMB_col;
	int salesPrice_col;
	int actual_SalesPrice_col;
	int zhifu_Shishou_Jine_col;
	int yuguyongjin_col;
	int butie_zhekou_col;
	int butie_fengmi_col;
	int butie_youhuiquan_col;
	int butie_col;
	int baobiaoshouru_col;
	int feiyong_col;
	int fanxian_col;
	
	
	
	public Map<String,List<String>> map_pay = new HashMap<String,List<String>>();
	
	public List<String> list_pay = new ArrayList<String>();
	
	public Map<String,List<List<String>>> map_account = new HashMap<String,List<List<String>>>();
	
	public List<String> list_account = new ArrayList<String>();
	
	public Map<String,List<List<String>>> result_map = new HashMap<String,List<List<String>>>();
	
	// 如果是pay 和positive account的比较
	// 　pay_must_info  account_must_info 每个数组里含有四个元素
	
	// 如果是 orders 和 double的比较
	// 那么每个数组里含有两个元素
	

	public CompareContents_Tuikuan_Zhifu_Rate_Test(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String liuShuiLeixing,String getPayColumnName,String getAccountColumnName,String chengBenJia_RMB,String salesPrice,String actual_SalesPrice,String zhifu_Shishou_Jine,String yuguyongjin,String butie_zhekou,String butie_fengmi,String butie_youhuiquan,String butie,String baobiaoshouru,String feiyong,String fanxian){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.pay_sheetName = pay_sheetName;
		this.account_sheetName = account_sheetName;
		this.liuShuiLeixing = liuShuiLeixing;
		this.getPayColumnName = getPayColumnName;
		this.getAccountColumnName = getAccountColumnName;
		this.chengBenJia_RMB = chengBenJia_RMB;
		this.salesPrice = salesPrice;
		this.actual_SalesPrice = actual_SalesPrice;
		this.zhifu_Shishou_Jine = zhifu_Shishou_Jine;
		this.yuguyongjin = yuguyongjin;
		this.butie_zhekou = butie_zhekou;
		this.butie_fengmi = butie_fengmi;
		this.butie_youhuiquan = butie_youhuiquan;
		this.butie = butie;
		this.baobiaoshouru = baobiaoshouru;
		this.feiyong = feiyong;
		this.fanxian = fanxian;
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
        	
        	if(cellvalue.equals(liuShuiLeixing)){
        		liuShuiLeixing_col = x;
        		System.out.println("liuShuiLeixing_col is :" + liuShuiLeixing_col);
        	}
        	
        	if(cellvalue.equals(getPayColumnName)){
        		zhifu_id_col = x;
        		System.out.println("zhifu_id_col is :" + zhifu_id_col);
        	}

        	if(cellvalue.equals(getAccountColumnName)){
        		duizhang_id_col = x;
        		System.out.println("duizhang_id_col is :" + duizhang_id_col);
        	}
        	if(cellvalue.equals(chengBenJia_RMB)){
        		chengBenJia_RMB_col = x;
        		System.out.println("chengBenJia_RMB_col is :" + chengBenJia_RMB_col);
        	}
        	if(cellvalue.equals(salesPrice)){
        		salesPrice_col = x;
        		System.out.println("salesPrice_col is :" + salesPrice_col);
        	}
        	if(cellvalue.equals(actual_SalesPrice)){
        		actual_SalesPrice_col = x;
        		System.out.println("actual_SalesPrice_col is :" + actual_SalesPrice_col);
        	}
        	if(cellvalue.equals(zhifu_Shishou_Jine)){
        		zhifu_Shishou_Jine_col = x;
        		System.out.println("zhifu_Shishou_Jine_col is :" + zhifu_Shishou_Jine_col);
        	}
        	if(cellvalue.equals(yuguyongjin)){
        		yuguyongjin_col = x;
        		System.out.println("yuguyongjin_col is :" + yuguyongjin_col);
        	}
        	if(cellvalue.equals(butie_zhekou)){
        		butie_zhekou_col = x;
        		System.out.println("butie_zhekou_col is :" + butie_zhekou_col);
        	}
        	if(cellvalue.equals(butie_fengmi)){
        		butie_fengmi_col = x;
        		System.out.println("butie_fengmi_col is :" + butie_fengmi_col);
        	}
        	if(cellvalue.equals(butie_youhuiquan)){
        		butie_youhuiquan_col = x;
        		System.out.println("butie_youhuiquan_col is :" + butie_youhuiquan_col);
        	}
        	if(cellvalue.equals(butie)){
        		butie_col = x;
        		System.out.println("butie_col is :" + butie_col);
        	}
        	if(cellvalue.equals(baobiaoshouru)){
        		baobiaoshouru_col = x;
        		System.out.println("baobiaoshouru_col is :" + baobiaoshouru_col);
        	}
        	if(cellvalue.equals(feiyong)){
        		feiyong_col = x;
        		System.out.println("feiyong_col is :" + feiyong_col);
        	}
        	if(cellvalue.equals(fanxian)){
        		fanxian_col = x;
        		System.out.println("fanxian_col is :" + fanxian_col);
        	}
        	
        }
        
    
        //获取支付id 以及 对对应想要获取的字段的取值
        
        for(int x = 1; x <= rowLength-1;x++){
        	
        	xssfRow = sheet.getRow(x);
        	
        	String pay_id = "";
        	
        	String liuShuiLeixing_value = "";
        	String chengBenJia_RMB_value = "";;
        	String salesPrice_value = "";
        	String actual_SalesPrice_value = "";
        	String zhifu_Shishou_Jine_value = "";
        	String yuguyongjin_value = "";
        	String butie_zhekou_value = "";
        	String butie_fengmi_value = "";
        	String butie_youhuiquan_value = "";
        	String butie_value = "";
        	String baobiaoshouru_value = "";
        	String feiyong_value = "";
        	String fanxian_value = "";
        	

        	List<String> list_price = null;

        	for(int y =0 ;y<colLength;y++){
        		XSSFCell xssfCell = xssfRow.getCell(y);
//        		Dailylog.logInfo(" x is ::::::: " + x + " y is ::::::" + y + "row length is :" + rowLength);
        		
        		if(liuShuiLeixing_col == y){
        			liuShuiLeixing_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(chengBenJia_RMB_col == y){
        			chengBenJia_RMB_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(salesPrice_col == y){
        			salesPrice_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(actual_SalesPrice_col == y){
        			actual_SalesPrice_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(zhifu_Shishou_Jine_col == y){
        			zhifu_Shishou_Jine_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(yuguyongjin_col == y){
        			yuguyongjin_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(butie_zhekou_col == y){
        			butie_zhekou_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(butie_fengmi_col == y){
        			butie_fengmi_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(butie_youhuiquan_col == y){
        			butie_youhuiquan_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(butie_col == y){
        			butie_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(baobiaoshouru_col == y){
        			baobiaoshouru_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(feiyong_col == y){
        			feiyong_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(fanxian_col == y){
        			fanxian_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		
        		if(zhifu_id_col == y){
        			pay_id = WriterExcelUtil.getCellValue(xssfCell).replace("'", "");
        			
//        			Dailylog.logInfo("pay id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + pay_id +  "y is :" +y);
        		}
        	
        		
        	}

            	if(liuShuiLeixing_value.equals("初始流水")){
            		
            		list_price = new ArrayList<String>();
                	
            		list_price.add(liuShuiLeixing_value);
                	list_price.add(chengBenJia_RMB_value);
                	list_price.add(salesPrice_value);
                	list_price.add(actual_SalesPrice_value);
                	list_price.add(zhifu_Shishou_Jine_value);
                	list_price.add(yuguyongjin_value);
                	list_price.add(butie_zhekou_value);
                	list_price.add(butie_fengmi_value);
                	list_price.add(butie_youhuiquan_value);
                	list_price.add(butie_value);
                	list_price.add(baobiaoshouru_value);
                	list_price.add(feiyong_value);
                	list_price.add(fanxian_value);
                	
                	
            	   	// 将得到的值放到map中
            		map_pay.put(pay_id, list_price);
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
        
      
        
        // 得到想要获得字段  也就是支付id  以及 想要获得的内容
        
        for(int x = 1; x <=rowLength_zhengxiang-1;x++){
        	xssfRow_zhengxiang= sheet_zhengxiang.getRow(x);
   
        	String account_id = "";
        	
        	String liuShuiLeixing_value = "";
        	String chengBenJia_RMB_value = "";;
        	String salesPrice_value = "";
        	String actual_SalesPrice_value = "";
        	String zhifu_Shishou_Jine_value = "";
        	String yuguyongjin_value = "";
        	String butie_zhekou_value = "";
        	String butie_fengmi_value = "";
        	String butie_youhuiquan_value = "";
        	String butie_value = "";
        	String baobiaoshouru_value = "";
        	String feiyong_value = "";
        	String fanxian_value = "";
        	
        	List<List<String>> list_detail = null;
        	List<String> list_price = null;
        	
        	for(int y = 0; y < colLength_zhengxiang; y++){
        		
        		XSSFCell xssfCell = xssfRow_zhengxiang.getCell(y);
//        		Dailylog.logInfo(" x is ::::::: " + x + " y is ::::::" + y + "row length is :" + rowLength_zhengxiang);
        		
        		if(liuShuiLeixing_col == y){
        			liuShuiLeixing_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(chengBenJia_RMB_col == y){
        			chengBenJia_RMB_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(salesPrice_col == y){
        			salesPrice_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(actual_SalesPrice_col == y){
        			actual_SalesPrice_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(zhifu_Shishou_Jine_col == y){
        			zhifu_Shishou_Jine_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(yuguyongjin_col == y){
        			yuguyongjin_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(butie_zhekou_col == y){
        			butie_zhekou_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(butie_fengmi_col == y){
        			butie_fengmi_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(butie_youhuiquan_col == y){
        			butie_youhuiquan_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(butie_col == y){
        			butie_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(baobiaoshouru_col == y){
        			baobiaoshouru_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(feiyong_col == y){
        			feiyong_value = WriterExcelUtil.getCellValue(xssfCell);
        		}
        		
        		if(fanxian_col == y){
        			fanxian_value = WriterExcelUtil.getCellValue(xssfCell);
        		}

        		
        		if(duizhang_id_col == y){
        			
        			account_id = WriterExcelUtil.getCellValue(xssfCell);
        			
//        			Dailylog.logInfo("account_id >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> is :" + account_id +"zhifu_id_col is :" + duizhang_id_col + "y is :" + y + "     colLength_zhengxiang is ：" + colLength_zhengxiang);
        		}
          		       		
        	}
        	
        	list_price = new ArrayList<String>();
        	
        	list_price.add(liuShuiLeixing_value);
        	list_price.add(chengBenJia_RMB_value);
        	list_price.add(salesPrice_value);
        	list_price.add(actual_SalesPrice_value);
        	list_price.add(zhifu_Shishou_Jine_value);
        	list_price.add(yuguyongjin_value);
        	list_price.add(butie_zhekou_value);
        	list_price.add(butie_fengmi_value);
        	list_price.add(butie_youhuiquan_value);
        	list_price.add(butie_value);
        	list_price.add(baobiaoshouru_value);
        	list_price.add(feiyong_value);
        	list_price.add(fanxian_value);
        	
        	
        	if(!map_account.containsKey(account_id)){
        		list_detail = new ArrayList<List<String>>();
        		list_detail.add(list_price);
        	}else{
        		list_detail = map_account.get(account_id);
        		list_detail.add(list_price);
        	}

        	map_account.put(account_id, list_detail);
    	
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
//        		System.out.println("str is ::::::::::::::::::::::::::::::::" +str);
        		if(set_account.contains(str)){
//        			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
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
        	
        	// 一对多的关系   支付是一条  但是退款可能是多条  分多条退款
        	
        	// pay  对应的是  positive_hotel
        	// account  对应的是  negative_hotel
        	
        	List<String> value_pay_list = map_pay.get(id);
        	List<List<String>> value_account_list = map_account.get(id);
        	
        	
        	
        	if(value_account_list.size() == 1){
        		
        		List<String> temp_list = value_account_list.get(0);
        		
        		String temp_pay_value = "";
        		String temp_account_value = "";
        		
        		// x = 0  是流水类型
        		// x = 1 是成本价RMB
        		
        		String chengben_pay_value = value_pay_list.get(1);
        		String chengben_account_value = temp_list.get(1);
        		
        		double dou_chengben_pay = WriterExcelUtil.getFloatPrice(chengben_pay_value);
        		double dou_chengben_account = WriterExcelUtil.getFloatPrice(chengben_account_value);
        		
        		double rate_initital = dou_chengben_account/dou_chengben_pay;
        		
        		
        		for(int x = 2; x <value_pay_list.size(); x++){
        			temp_pay_value = value_pay_list.get(x);
        			temp_account_value = temp_list.get(x);
        			
        			double dou_pay_value = WriterExcelUtil.getFloatPrice(temp_pay_value);
        			double dou_account_value = WriterExcelUtil.getFloatPrice(temp_account_value);
        			
        			double rate_other = 0;
        					
        			if(dou_pay_value == 0){
        				rate_other = rate_initital;
        			}else{
        				rate_other = dou_account_value/dou_pay_value;
        			}
        			 
        			
        			if(rate_other != rate_initital){
        				List<String> errorNumber = new ArrayList<String>();
        				errorNumber.add((x+1)+ "");
        				
        				List<List<String>> list_temp = new ArrayList();
        				list_temp.add(value_pay_list);
        				list_temp.add(temp_list);
        				list_temp.add(errorNumber);
        				
        				result_map.put(id, list_temp);
        				break;
        			}
     	
        		}
        		
        	}else{
        		
        		List<String> list_account = null;
        		
        		for(int m =0; m<value_account_list.size(); m++){
        			
        			list_account = value_account_list.get(m);
        		
        			String chengben_pay_value = value_pay_list.get(1);
        			String chengben_account_value = list_account.get(1);
        			
        			double dou_chengben_pay = WriterExcelUtil.getFloatPrice(chengben_pay_value);
        			double dou_chengben_account = WriterExcelUtil.getFloatPrice(chengben_account_value);
        			
        			double initialRate = dou_chengben_account/dou_chengben_pay;
        			
        			for(int x = 2; x <value_pay_list.size(); x++){
        				
        				String temp_pay_value = value_pay_list.get(x);
        				String temp_account_value = list_account.get(x);
        		
        				double dou_pay_value = WriterExcelUtil.getFloatPrice(temp_pay_value);
        				double dou_account_value = WriterExcelUtil.getFloatPrice(temp_account_value);
        				
        				double rate_other = 0;
        				
        				if(dou_account_value == 0){
        					rate_other = initialRate;
        				}else{
        					rate_other = dou_account_value/dou_pay_value;
        				}
        				
        				
        				if(initialRate != rate_other){
        					List<String> errorNumber = new ArrayList<String>();
        					errorNumber.add((x+1)+"");
        					
        					List<List<String>> list_temp = new ArrayList<>();
        					
        					list_temp.add(value_pay_list);
        					list_temp.add(list_account);
        					list_temp.add(errorNumber);
        					
        					result_map.put(id, list_temp);
        					break;
        				}
        				
        			}
			
        		}
 	
        	}
	
 
        }  
        
        Dailylog.logInfo("result map size is ：：：：：：：：：：：：：：：：：：：:" + result_map.size());
        
    	
    	/*String getPayColumnName;
    	String getAccountColumnName;
    	String chengBenJia_RMB;
    	String salesPrice;
    	String actual_SalesPrice;
    	String zhifu_Shishou_Jine;
    	String yuguyongjin;
    	String butie_zhekou;
    	String butie_fengmi;
    	String butie_youhuiquan;
    	String butie;
    	String baobiaoshouru;
    	String feiyong;
    	String fanxian;
    	
    	int zhifu_id_col;
    	int duizhang_id_col;
    	int chengBenJia_RMB_col;
    	int salesPrice_col;
    	int actual_SalesPrice_col;
    	int zhifu_Shishou_Jine_col;
    	int yuguyongjin_col;
    	int butie_zhekou_col;
    	int butie_fengmi_col;
    	int butie_youhuiquan_col;
    	int butie_col;
    	int baobiaoshouru_col;
    	int feiyong_col;
    	int fanxian_col;*/
    	
       
        
        
        List<String> firstRowList = new ArrayList<String>();
        
        firstRowList.add("订单ID");
        firstRowList.add("流水类型");
        firstRowList.add("成本价-RMB");
        firstRowList.add("销售价");
        firstRowList.add("实际销售价");
        firstRowList.add("支付(实收)金额");
        firstRowList.add("预估佣金");
        firstRowList.add("补贴：折扣");
        firstRowList.add("补贴：蜂蜜");
        firstRowList.add("补贴：优惠券");
        firstRowList.add("补贴");
        firstRowList.add("报表收入");
        firstRowList.add("费用");
        firstRowList.add("返现");
        
        
        
        writeContent2Excels_Contents(destinationFile, "比例_double_hotel",pay_sheetName,account_sheetName, firstRowList,result_map);
        
        
        
        
	}
	
public static void writeContent2Excels_Contents(String destinationTable,String sheetName,String pay_sheetName,String account_sheetName,List<String> list,Map<String,List<List<String>>> map){
		
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
				Dailylog.logInfo("m is :" + m + "temp_sheetName is :" + temp_sheetName+ "temp_sheetName length is :" + temp_sheetName.length());
				Dailylog.logInfo("m is :" + m + "sheet name is :" + sheetName);
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
			
			
			if(map.size() != 0){
				
				Set<String> set1 = map.keySet();
				
				 Iterator<String> itt = set1.iterator();
				
				 int num = 1;
				 while(itt.hasNext()){
//					 Dailylog.logInfo("num is :" + num);
					 String str = itt.next();
//					 Dailylog.logInfo("str is :" + str);
					 
					 List<List<String>> list_temp = map.get(str);
					 
					 Dailylog.logInfo("list_temp size is ::::::::" + list_temp.size());
					 
					 List<String> list_pay = list_temp.get(0);
					 Dailylog.logInfo("list_pay is :" + list_pay.size());
					 
					 List<String> list_account = list_temp.get(1);
					 Dailylog.logInfo("list_account is :" + list_account.size());
					 
					 HSSFRow row = null;
					 HSSFCell cell_1 = null;
					 
					 for(int y = 0; y< list_temp.size()-1; y++){
						 
						 List<String> list_list = list_temp.get(y);
						 
						 List<String> errorNumber = list_temp.get(list_temp.size()-1);
						 
						 String errorNum = errorNumber.get(0);
						 int error = Integer.parseInt(errorNum);
						 
						 row = sheet.createRow(num);
						 
						 cell_1 = row.createCell(0);
						 
						 cell_1.setCellValue(str);
						 
						 for(int n = 1; n <= list_list.size(); n++){
							 
							 cell_1 = row.createCell(n);
							 
							 if(n == error){
								 WriterExcelUtil.setCellColor(book, cell_1, "red");
							 }
							 
							 cell_1.setCellValue(list_list.get(n-1));
							 
						 }	
						 num++; 
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
