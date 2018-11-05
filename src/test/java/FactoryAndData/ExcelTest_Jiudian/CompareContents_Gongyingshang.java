package FactoryAndData.ExcelTest_Jiudian;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian.CompareContents_Gongyingshang_Test;

public class CompareContents_Gongyingshang {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
				//供应商
				{
					  "C:\\Users\\gaopan\\Desktop\\酒店账单\\数据准备\\"+testMonth+"_"+testDay+"\\酒店流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\酒店账单\\result\\contents"+testMonth+"_"+testDay+".xls",
					  "pay",
					  "positive_hotel",
					  "店铺名",
					  "OTA",
					  "支付ID",
					  "订单ID"
				  },
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,String getPayColumnName,String getAccountColumnName) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Gongyingshang_Test(sourceFile,destinationFile,pay_sheetName,account_sheetName,pay_must_info,account_must_info,getPayColumnName,getAccountColumnName);

		return tests;
	}

	
	
	
	
	

}
