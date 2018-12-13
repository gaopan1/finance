package FactoryAndData.ExcelTest_Jiudian_EcouponSplitting.department;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_EcouponSplitting.useScenery.CompareRecordS;






public class CompareRecordSData {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//数据准备\七月1_3	
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_departmentDetail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"部门",
				"酒店",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"部门",
				"酒店"
			},
			

		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								  String destinationFile,
								  
								  String sheet_butiechaifen,
								  String mfwid_butiechaifen,
								  String useScenery_butiechaifen,
								  String useScenery_Detail_butiechaifen,
								 
								  String sheet_youhuiquanCenter,
								  String mfwid_youhuiquanCenter,
								  String useScenery_youhuiquanCenter,
								  String useScenery_Detail_youhuiquanCenter) {

		Object[] tests = new Object[1];

		tests[0] = new CompareRecordS(sourceFile,
										destinationFile,
										
										sheet_butiechaifen,
										mfwid_butiechaifen,
										useScenery_butiechaifen,
										useScenery_Detail_butiechaifen,
										
										sheet_youhuiquanCenter,
										mfwid_youhuiquanCenter,
										useScenery_youhuiquanCenter,
										useScenery_Detail_youhuiquanCenter);

		return tests;
	}

}

