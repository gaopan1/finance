package FactoryAndData.ExcelTest_Jiudian_JieSuanLiuShui.subRequirements;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_JieSuanLiuShui.subRequirementTest.CompareContents_JieSuanLiuShui_OTA_Bill_Fukuanjine;

public class CompareContents_JieSuanLiuShui_OTA_Bill_Fukuanjine_Data {

public static String elong_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "elong_date");
public static String tcc_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "tcc_date");
public static String ctrip_out_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "ctrip_out_date");
public static String ctrip_in_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "ctrip_in_date");
public static String jalan_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "jalan_date");


	@DataProvider(name = "results")
	public static Object[][] Data16389() {

		return new Object[][] { 
			
			// jalan
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\jalan\\"+jalan_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\jalan\\Contents_fukuanjineCompare"+jalan_testDate+".xls",
				  "jalan",
				  "jiesuan_bill",
				  "ota_jiesuan",
				  "ota_bill",
				  //结算bill
				  "流水ID",
				  "订单ID",
				  "OTA订单ID",
				  "付款金额-原币",
				  //relation 
				  "trade_id",
				  "bill_id",
				  // ota bill 
				  "id",
				  "settle_rate"
			  },
			
			
			
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String ota_name,
								String jiesuan_bill_sheet,
								String jiesuan_ota_relation_sheet,
								String ota_bill_sheet,
								//-------------------
								String liushui_id_jiesuan,
								String dingdan_id_jiesuan,
								String ota_bill_id_jiesuan,
								String fukuanjine_yuanbi_jiesuan,
								//-------------
								String trade_id_relation,
								String bill_id_relation,
								//-------------
								String id_ota,
								String fujuanjine_ota) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_JieSuanLiuShui_OTA_Bill_Fukuanjine(sourceFile,
															  destinationFile,
															  ota_name,
															  jiesuan_bill_sheet,
															  jiesuan_ota_relation_sheet,
															  ota_bill_sheet,
															  //-----------
															  liushui_id_jiesuan,
															  dingdan_id_jiesuan,
															  ota_bill_id_jiesuan,
															  fukuanjine_yuanbi_jiesuan,
															  //-----------
															  trade_id_relation,
															  bill_id_relation,
															  //-----------
															  id_ota,
															  fujuanjine_ota);

		return tests;
	}
	
}
