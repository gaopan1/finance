package FactoryAndData.ExcelTest_Jieji_Qingsuanliushui;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Jieji_Qingsuanliushui.CompareRecords_GetRepeat;







public class CompareRecords_GetR {
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//数据准备\七月1_3	
			{ 	
				"C:\\Users\\gaopan\\Desktop\\接机清算流水\\数据准备\\清算流水对账全表.xlsx",
				"C:\\Users\\gaopan\\Desktop\\接机清算流水\\result\\Records.xls",
				"qingsuanliushui_positive",
				"jiejiliushui_positive",
				"_正向",
				//---------
				"订单号",
				"业务订单号",
				"商品名称",
				"目的地",
				"合作模式",
				"品类",
				"渠道来源",
				"购买人",
				"供应商",
				"供应商简称",
				"店铺名",
				"店铺ID",
				"销售金额",
				"支付金额",
				"补贴",
				"供应商补贴",
				"应结算金额",
				"结算金额",
				"结算金额（RMB)",
				"收入",
				"币种",
				"汇率",
				"账单名",
				"支付时间",
				"出行日期",
				"结算日期",
				"交易日期",
				"清算日期",
				//---------
				"订单号",
				"业务订单号",
				"商品名称",
				"目的地",
				"合作模式",
				"品类",
				"渠道来源",
				"购买人",
				"供应商",
				"供应商简称",
				"店铺名",
				"店铺ID",
				"销售金额",
				"支付金额",
				"补贴",
				"供应商补贴",
				"应结算金额",
				"结算金额",
				"结算金额（RMB)",
				"收入",
				"币种",
				"汇率",
				"账单名",
				"支付时间",
				"出行日期",
				"结算日期",
				"交易日期",
				"清算日期"
			},
			{ 	
				"C:\\Users\\gaopan\\Desktop\\接机清算流水\\数据准备\\清算流水对账全表.xlsx",
				"C:\\Users\\gaopan\\Desktop\\接机清算流水\\result\\Records.xls",
				"qingsuanliushui_negative",
				"jiejiliushui_negative",
				"_负向",
				//---------
				"订单号",
				"业务订单号",
				"商品名称",
				"目的地",
				"合作模式",
				"品类",
				"渠道来源",
				"购买人",
				"供应商",
				"供应商简称",
				"店铺名",
				"店铺ID",
				"销售金额",
				"支付金额",
				"补贴",
				"供应商补贴",
				"应结算金额",
				"结算金额",
				"结算金额（RMB)",
				"收入",
				"币种",
				"汇率",
				"账单名",
				"支付时间",
				"出行日期",
				"结算日期",
				"交易日期",
				"清算日期",
				//---------
				"订单号",
				"业务订单号",
				"商品名称",
				"目的地",
				"合作模式",
				"品类",
				"渠道来源",
				"购买人",
				"供应商",
				"供应商简称",
				"店铺名",
				"店铺ID",
				"销售金额",
				"支付金额",
				"补贴",
				"供应商补贴",
				"应结算金额",
				"结算金额",
				"结算金额（RMB)",
				"收入",
				"币种",
				"汇率",
				"账单名",
				"支付时间",
				"出行日期",
				"结算日期",
				"交易日期",
				"清算日期"
			}

		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String qingsuanliushui_sheet,
								String jiejiliushui_sheet,
								String result_SheetName,
								//-------
								String dingdanhao_qingsuan,
								String yewudingdanhao_qingsuan,
								String shangpingmingcheng_qingsuan,
								String mudidi_qingsuan,
								String hezuomoshi_qingsuan,
								String pinlei_qingsuan,
								String qudaolaiyuan_qingsuan,
								String goumairen_qingsuan,
								String gongyingshang_qingsuan,
								String gongyingshangjiancheng_qingsuan,
								String dianpuming_qingsuan,
								String dianpuID_qingsuan,
								String xiaoshoujine_qingsuan,
								String zhifujine_qingsuan,
								String butie_qingsuan,
								String gongyingshangbutie_qingsuan,
								String yingjiesuanjine_qingsuan,
								String jiesuanjine_qingsuan,
								String jiesuanjine_RMB_qingsuan,
								String shouru_qingsuan,
								String bizhong_qingsuan,
								String huilv_qingsuan,
								String zhangdanming_qingsuan,
								String zhifushijian_qingsuan,
								String chuxingriqi_qingsuan,
								String jiesuanriqi_qingsuan,
								String jiaoyiriqi_qingsuan,
								String qingsuanriqi_qingsuan,
								//-------------
								String dingdanhao_jiejiliushui,
								String yewudingdanhao_jiejiliushui,
								String shangpingmingcheng_jiejiliushui,
								String mudidi_jiejiliushui,
								String hezuomoshi_jiejiliushui,
								String pinlei_jiejiliushui,
								String qudaolaiyuan_jiejiliushui,
								String goumairen_jiejiliushui,
								String gongyingshang_jiejiliushui,
								String gongyingshangjiancheng_jiejiliushui,
								String dianpuming_jiejiliushui,
								String dianpuID_jiejiliushui,
								String xiaoshoujine_jiejiliushui,
								String zhifujine_jiejiliushui,
								String butie_jiejiliushui,
								String gongyingshangbutie_jiejiliushui,
								String yingjiesuanjine_jiejiliushui,
								String jiesuanjine_jiejiliushui,
								String jiesuanjine_RMB_jiejiliushui,
								String shouru_jiejiliushui,
								String bizhong_jiejiliushui,
								String huilv_jiejiliushui,
								String zhangdanming_jiejiliushui,
								String zhifushijian_jiejiliushui,
								String chuxingriqi_jiejiliushui,
								String jiesuanriqi_jiejiliushui,
								String jiaoyiriqi_jiejiliushui,
								String qingsuanriqi_jiejiliushui) {

		Object[] tests = new Object[1];

		tests[0] = new CompareRecords_GetRepeat(sourceFile,
									 destinationFile,
									 qingsuanliushui_sheet,
									 jiejiliushui_sheet,
									 result_SheetName,
									 //------
									 dingdanhao_qingsuan,
									 yewudingdanhao_qingsuan,
									 shangpingmingcheng_qingsuan,
									 mudidi_qingsuan,
									 hezuomoshi_qingsuan,
									 pinlei_qingsuan,
									 qudaolaiyuan_qingsuan,
									 goumairen_qingsuan,
									 gongyingshang_qingsuan,
									 gongyingshangjiancheng_qingsuan,
									 dianpuming_qingsuan,
									 dianpuID_qingsuan,
									 xiaoshoujine_qingsuan,
									 zhifujine_qingsuan,
									 butie_qingsuan,
									 gongyingshangbutie_qingsuan,
									 yingjiesuanjine_qingsuan,
									 jiesuanjine_qingsuan,
									 jiesuanjine_RMB_qingsuan,
									 shouru_qingsuan,
									 bizhong_qingsuan,
									 huilv_qingsuan,
									 zhangdanming_qingsuan,
									 zhifushijian_qingsuan,
									 chuxingriqi_qingsuan,
									 jiesuanriqi_qingsuan,
									 jiaoyiriqi_qingsuan,
									 qingsuanriqi_qingsuan,
									 //------
									 dingdanhao_jiejiliushui,
									 yewudingdanhao_jiejiliushui,
									 shangpingmingcheng_jiejiliushui,
									 mudidi_jiejiliushui,
									 hezuomoshi_jiejiliushui,
									 pinlei_jiejiliushui,
									 qudaolaiyuan_jiejiliushui,
									 goumairen_jiejiliushui,
									 gongyingshang_jiejiliushui,
									 gongyingshangjiancheng_jiejiliushui,
									 dianpuming_jiejiliushui,
									 dianpuID_jiejiliushui,
									 xiaoshoujine_jiejiliushui,
									 zhifujine_jiejiliushui,
									 butie_jiejiliushui,
									 gongyingshangbutie_jiejiliushui,
									 yingjiesuanjine_jiejiliushui,
									 jiesuanjine_jiejiliushui,
									 jiesuanjine_RMB_jiejiliushui,
									 shouru_jiejiliushui,
									 bizhong_jiejiliushui,
									 huilv_jiejiliushui,
									 zhangdanming_jiejiliushui,
									 zhifushijian_jiejiliushui,
									 chuxingriqi_jiejiliushui,
									 jiesuanriqi_jiejiliushui,
									 jiaoyiriqi_jiejiliushui,
									 qingsuanriqi_jiejiliushui);

		return tests;
	}

}

