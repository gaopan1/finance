package FactoryAndData.ExcelTest_Jieji;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Jieji.CompareContents_Shouru_Test;

public class CompareContents_Shouru {
	
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 

				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","double_account", "订单号","合作模式","支付金额","补贴","应结算金额","收入"},
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String account_sheetName,String payid,String co_model,String pay_money,String allowance,String ying_jie_suan_money,String shouru) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Shouru_Test(sourceFile,destinationFile,account_sheetName,payid,co_model,pay_money,allowance,ying_jie_suan_money,shouru);

		return tests;
	}

	
	
	
	
	

}
