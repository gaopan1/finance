package FactoryAndData.ExcelTest_Jiudian_JieSuanLiuShui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_JieSuanLiuShui.CompareContents_JieSuanLiuShui_Field_Jiesuanshouru_Yongjin;

public class CompareContents_Field_Jiesuanshouru_Yongjin {

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
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\jalan\\Contents_"+jalan_testDate+".xls",
				  "jalan",
				  "jiesuan_bill",
				  "ota_jiesuan",
				  "ota_bill",
				  //结算bill
				  "对账账单名",
				  "OTA",
				  "流水ID",
				  "订单ID",
				  "OTA订单ID",
				  "业务模式",
				  "支付(实收)金额",
				  "订单日汇率",
				  "结算收入",
				  //relation 
				  "trade_id",
				  "bill_id",
				  // ota bill 
				  "id",
				  "settle_fee",
				  "settle_fee_no_tax",
				  "commission"
			  },
			
			
			/*// ctrip in
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_in\\"+ctrip_in_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_in\\Contents_"+ctrip_in_testDate+".xls",
				  "ctrip_in",
				  "jiesuan_bill",
				  "ota_jiesuan",
				  "ota_bill",
				  //结算bill
				  "对账账单名",
				  "OTA",
				  "流水ID",
				  "订单ID",
				  "OTA订单ID",
				  "业务模式",
				  "支付(实收)金额",
				  "订单日汇率",
				  "结算收入",
				  //relation 
				  "trade_id",
				  "bill_id",
				  // ota bill 
				  "id",
				  "trip_fee",
				  "clear_fee",
				  "commission_fee"
			  },*/
			
			
				/*// ctrip out
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_out\\"+ctrip_out_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_out\\Contents_"+ctrip_out_testDate+".xls",
					  "ctrip_out",
					  "jiesuan_bill",
					  "ota_jiesuan",
					  "ota_bill",
					  //结算bill
					  "对账账单名",
					  "OTA",
					  "流水ID",
					  "订单ID",
					  "OTA订单ID",
					  "业务模式",
					  "支付(实收)金额",
					  "订单日汇率",
					  "结算收入",
					  //relation 
					  "trade_id",
					  "bill_id",
					  // ota bill 
					  "id",
					  "trip_fee",
					  "clear_fee",
					  "commission_fee"
				  },
				*/
				/*// tcc
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\tcc\\"+tcc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\tcc\\Contents_"+tcc_testDate+".xls",
					  "tcc",
					  "jiesuan_bill",
					  "ota_jiesuan",
					  "ota_bill",
					  //结算bill
					  "对账账单名",
					  "OTA",
					  "流水ID",
					  "订单ID",
					  "OTA订单ID",
					  "业务模式",
					  "支付(实收)金额",
					  "订单日汇率",
					  "结算收入",
					  //relation 
					  "trade_id",
					  "bill_id",
					  // ota bill 
					  "id",
					  "卖价",
					  "结算价",
					  "commission"
				  },*/
				
				/*// elong
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\elong\\"+elong_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\elong\\Contents_"+elong_testDate+".xls",
					  "elong",
					  "jiesuan_bill",
					  "ota_jiesuan",
					  "ota_bill",
					  //结算bill
					  "对账账单名",
					  "OTA",
					  "流水ID",
					  "订单ID",
					  "OTA订单ID",
					  "业务模式",
					  "支付(实收)金额",
					  "订单日汇率",
					  "结算收入",
					  //relation 
					  "trade_id",
					  "bill_id",
					  // ota bill 
					  "id",
					  "distributors_fee",
					  "calculated_fee",
					  "commission_fee"
				  },*/
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String ota_name,
								String jiesuan_bill_sheet,
								String jiesuan_ota_relation_sheet,
								String ota_bill_sheet,
								String bill_name_jiesuan,
								String ota_jiesuan,
								String liushui_id_jiesuan,
								String dingdan_id_jiesuan,
								String ota_bill_id_jiesuan,
								String yewumoshi_jiesuan,
								String zhifushishoujine_jiesuan,
								String dingdanrihuilv_jiesuan,
								String jiesuanshouru_jiesuan,
								String trade_id_relation,
								String bill_id_relation,
								String id_ota,
								String sale_amount_ota,
								String due_amount_ota,
								String commission_ota) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_JieSuanLiuShui_Field_Jiesuanshouru_Yongjin(sourceFile,
															  destinationFile,
															  ota_name,
															  jiesuan_bill_sheet,
															  jiesuan_ota_relation_sheet,
															  ota_bill_sheet,
															  bill_name_jiesuan,
															  ota_jiesuan,
															  liushui_id_jiesuan,
															  dingdan_id_jiesuan,
															  ota_bill_id_jiesuan,
															  yewumoshi_jiesuan,
															  zhifushishoujine_jiesuan,
															  dingdanrihuilv_jiesuan,
															  jiesuanshouru_jiesuan,
															  trade_id_relation,
															  bill_id_relation,
															  id_ota,
															  sale_amount_ota,
															  due_amount_ota,
															  commission_ota);

		return tests;
	}
	
}
