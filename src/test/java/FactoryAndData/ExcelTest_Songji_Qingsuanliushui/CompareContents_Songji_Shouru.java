package FactoryAndData.ExcelTest_Songji_Qingsuanliushui;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Songji_Qingsuanliushui.CompareContents_Songji_Calclate_Shouru;







public class CompareContents_Songji_Shouru {
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//数据准备\七月1_3	
			{ 	
				"D:\\马蜂窝对账项目\\送机清算流水\\数据准备\\清算流水对账全表.xlsx",
				"D:\\马蜂窝对账项目\\送机清算流水\\result\\calculate.xls",
				"qingsuanliushui_double",
				"calculate_收入",
				"订单号",
				"合作模式",
				"应结算金额",
				"结算金额",
				"支付金额",
				"补贴",
				"收入",
				"清算日期",
				"确认服务时间"	
			}
			

		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
							String destinationFile,
							String sheetName,
							String resultSheetName,
							String dingdanhao,
							String hezuomoshi,
							String yingjiesuanjine,
							String jiesuanjine,
							String zhifujine,
							String butie,
							String shouru,
							String qingsuanshijian,
							String chuxingshijian) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Songji_Calclate_Shouru(sourceFile,
									 destinationFile,
									 sheetName,
									 resultSheetName,
									 dingdanhao,
									 hezuomoshi,
									 yingjiesuanjine,
									 jiesuanjine,
									 zhifujine,
									 butie,
									 shouru,
									 qingsuanshijian,
									 chuxingshijian);

		return tests;
	}

}

