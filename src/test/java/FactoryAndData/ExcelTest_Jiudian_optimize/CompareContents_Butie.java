package FactoryAndData.ExcelTest_Jiudian_optimize;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Jiudian_optimize.CompareContents_Butie_Test;
import CommonFunction.WriterExcelUtil;


public class CompareContents_Butie {
	
	
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
					  "补贴：蜂蜜",
					  "补贴：折扣",
					  "补贴：优惠券",
					  "补贴"
				  },
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String account_sheetName,String payid,String zhifudingdan_id,String fengmi,String zhekou,String youhuiquan,String butie) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Butie_Test(sourceFile,destinationFile,account_sheetName,payid,zhifudingdan_id,fengmi,zhekou,youhuiquan,butie);

		return tests;
	}

	
	
	
	
	

}
