package FactoryAndData.ExcelTest_Jiudian_EcouponSplitting.useScenery;


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
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_Detail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"使用场景",
				"促单转化券",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"使用场景",
				"促单转化券"
			},
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_Detail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"使用场景",
				"蜂蜜兑换优惠券",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"使用场景",
				"蜂蜜兑换优惠券"
			},
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_Detail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"使用场景",
				"客服赔偿",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"使用场景",
				"客服赔偿"
			},
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_Detail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"使用场景",
				"老客复购",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"使用场景",
				"老客复购"
			},
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_Detail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"使用场景",
				"内部员工福利",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"使用场景",
				"内部员工福利"
			},
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_Detail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"使用场景",
				"外部用户赠送",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"使用场景",
				"游戏/互动/任务奖品"
			},
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_Detail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"使用场景",
				"外部用户赠送",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"使用场景",
				"游戏/互动/任务奖品"
			},
			
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_Detail_"+testMonth+"_"+testDay+".xls",
				
				"butiechaifen",
				"MFW订单ID",
				"使用场景",
				"",
				
				"youhuiquanCenter",
				"MFW订单ID",
				"使用场景",
				"拉新"
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

