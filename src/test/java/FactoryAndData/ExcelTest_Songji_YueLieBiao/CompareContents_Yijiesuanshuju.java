package FactoryAndData.ExcelTest_Songji_YueLieBiao;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Jieji_YueLieBiao.CompareContents_Test_Yijiesuanshuju;



public class CompareContents_Yijiesuanshuju {
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//数据准备\七月1_3	
			{ 	
				"D:\\马蜂窝对账项目\\余额列表\\数据准备\\已结算数据\\余额列表对账全表.xlsx",
				"D:\\马蜂窝对账项目\\余额列表\\result\\已结算数据\\已结算数据result.xls",
				"total",
				"total_value",
				"已结算数据——全部",
				"TotalResult",
				"支付金额",
				"补贴金额",
				"应结算金额",
				"结算金额（RMB)",
				"收入"
			},
			{ 	
				"D:\\马蜂窝对账项目\\余额列表\\数据准备\\已结算数据\\余额列表对账全表.xlsx",
				"D:\\马蜂窝对账项目\\余额列表\\result\\已结算数据\\已结算数据result.xls",
				"nanjing",
				"nanjing_value",
				"已结算数据——南京卓越国际旅行社有限责任公司",
				"南京卓越国际旅行社有限责任公司",
				"支付金额",
				"补贴金额",
				"应结算金额",
				"结算金额（RMB)",
				"收入"
			},
			{ 	
				"D:\\马蜂窝对账项目\\余额列表\\数据准备\\已结算数据\\余额列表对账全表.xlsx",
				"D:\\马蜂窝对账项目\\余额列表\\result\\已结算数据\\已结算数据result.xls",
				"hangzhou",
				"hangzhou_value",
				"已结算数据——杭州易途吧信息科技有限公司",
				"杭州易途吧信息科技有限公司",
				"支付金额",
				"补贴金额",
				"应结算金额",
				"结算金额（RMB)",
				"收入"
			},
			
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String total_sheetName,
								String total_value_sheetName,
								String biaotouming,
								String result_SheetName,
								String zhifujine,
								String butiejine,
								String yingjiesuanjine,
								String jiesuanjine_RMB,
								String shouru) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Test_Yijiesuanshuju(sourceFile,
									 destinationFile,	
									 total_sheetName,
									 total_value_sheetName,
									 biaotouming,
									 result_SheetName,
									 //------
									 zhifujine,
									 butiejine,
									 yingjiesuanjine,
									 jiesuanjine_RMB,
									 shouru);

		return tests;
	}

}

