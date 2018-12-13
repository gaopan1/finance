package FactoryAndData.ExcelTest_Jiudian_EcouponSplitting.department;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_EcouponSplitting.useScenery.CompareContentS;






public class CompareContentSData {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//数据准备\七月1_3	
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\contents_departmentDetail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"部门",
				"酒店",
				"渠道",
				"金额",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"部门",
				"酒店",
				"渠道",
				"金额",
			},
			
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
							  String destinationFile,
							  
							  String sheet_butiechaifen,
							  String mfwid_butiechaifen,
							  String useScenery_butiechaifen,
							  String useScenery_detail_butiechaifen,
							  String qudao_butiechaifen,
							  String jine_butiechaifen,
							  
							  String sheet_youhuiquanCenter,
							  String mfwid_youhuiquanCenter,
							  String useScenery_youhuiquanCenter,
							  String useScenery_detail_youhuiquanCenter,
							  String qudao_youhuiquanCenter,
							  String jine_youhuiquanCenter) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContentS(sourceFile,
										destinationFile,
										
										sheet_butiechaifen,
										mfwid_butiechaifen,
										useScenery_butiechaifen,
										useScenery_detail_butiechaifen,
										qudao_butiechaifen,
										jine_butiechaifen,
										
										sheet_youhuiquanCenter,
										mfwid_youhuiquanCenter,
										useScenery_youhuiquanCenter,
										useScenery_detail_youhuiquanCenter,
										qudao_youhuiquanCenter,
										jine_youhuiquanCenter);

		return tests;
	}

}

