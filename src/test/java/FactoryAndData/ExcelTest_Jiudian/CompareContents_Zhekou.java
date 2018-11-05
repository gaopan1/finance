package FactoryAndData.ExcelTest_Jiudian;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian.CompareContents_Zhekou_Test;

public class CompareContents_Zhekou {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	
	
	
	
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
				// 补贴
				{
					  "C:\\Users\\gaopan\\Desktop\\酒店账单\\数据准备\\"+testMonth+"_"+testDay+"\\酒店流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\酒店账单\\result\\contents"+testMonth+"_"+testDay+".xls",
					  "double_hotel",
					  "订单ID",
					  "支付订单ID",
					  "补贴：折扣",
					  "销售价",
					  "实际销售价"
				  },
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String account_sheetName,String payid,String zhifudingdanID,String zhekou,String sales_Price,String actual_Sales_Price) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Zhekou_Test(sourceFile,destinationFile,account_sheetName,payid,zhifudingdanID,zhekou,sales_Price,actual_Sales_Price);

		return tests;
	}

	
	
	
	
	

}
