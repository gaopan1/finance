package FactoryAndData.ExcelTest_Songji_YueLieBiao;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Jieji_YueLieBiao.CompareContents_Test_Weijiesuanyue;



public class CompareContents_Weijiesuanyue {
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//数据准备\七月1_3	
			{ 	
				"D:\\马蜂窝对账项目\\余额列表\\数据准备\\未结算余额\\余额列表对账全表.xlsx",
				"D:\\马蜂窝对账项目\\余额列表\\result\\未结算余额\\未结算余额result.xls",
				"shishou",
				"yijiesuan",
				"weijiesuan",
				"供应商",
				"订单数",
				"支付金额",
				"补贴金额",
				"供应商补贴",
				"应结算金额",
				"结算金额",
				"结算金额（RMB)",
				"收入"
			}
		};
			
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String shishou_sheetName,
								String yijiesuan_sheetName,
								String weijiesuan_sheetName,
								//-------
								String mark,
								String dingdanshu,
								String zhifujine,
								String butiejine,
								String gongyingshangbutie,
								String yingjiesuanjine,
								String jiesuanjine,
								String jiesuanjine_RMB,
								String shouru) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Test_Weijiesuanyue(sourceFile,
									 destinationFile,	
									 shishou_sheetName,
									 yijiesuan_sheetName,
									 weijiesuan_sheetName,
									 //------
									 mark,
									 dingdanshu,
									 zhifujine,
									 butiejine,
									 gongyingshangbutie,
									 yingjiesuanjine,
									 jiesuanjine,
									 jiesuanjine_RMB,
									 shouru);

		return tests;
	}

}

