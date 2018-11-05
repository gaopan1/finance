package FactoryAndData.ExcelTest_Jiudian_MFWBill_OTABill;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_MFWBill_OTABill.CompareContents_JieSuanLiuShui_Field_Fukuanjine_YUANBI;


public class CompareContents {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	
	
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {

		return new Object[][] { 
				
			
				
				/*{
					  "D:\\马蜂窝对账项目\\mfw账单\\数据准备\\ctrip_in\\"+testMonth+"_"+testDay+"\\mfw账单对账全表.xlsx",
					  "D:\\马蜂窝对账项目\\mfw账单\\result\\ctrip_in\\contents"+testMonth+"_"+testDay+".xls",
					  "ctrip_in",
					  "mfw账单",
					  "ota账单",
					  "OTA订单ID",
					  "付款金额-原币",
					  "订单号",
					  "结算价"
				  },*/
				{
					  "D:\\马蜂窝对账项目\\mfw账单\\数据准备\\ctrip_out\\"+testMonth+"_"+testDay+"\\mfw账单对账全表.xlsx",
					  "D:\\马蜂窝对账项目\\mfw账单\\result\\ctrip_out\\contents"+testMonth+"_"+testDay+".xls",
					  "ctrip_in",
					  "mfw账单",
					  "ota账单",
					  "OTA订单ID",
					  "付款金额-原币",
					  "订单号",
					  "结算价"
				  },
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String otaName,
								String mfwBill_sheet,
								String otaBill_sheet,
								String ota_dingdanID_mfwBill,
								String fukuanjine_YUANBI_mfwBill,
								String ota_dingdanID_OTABill,
								String jiesuanjia_OTABill) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_JieSuanLiuShui_Field_Fukuanjine_YUANBI(sourceFile,
												destinationFile,
												otaName,
												mfwBill_sheet,
												otaBill_sheet,
												ota_dingdanID_mfwBill,
												fukuanjine_YUANBI_mfwBill,
												ota_dingdanID_OTABill,
												jiesuanjia_OTABill);

		return tests;
	}

	
	
	
	
	

}
