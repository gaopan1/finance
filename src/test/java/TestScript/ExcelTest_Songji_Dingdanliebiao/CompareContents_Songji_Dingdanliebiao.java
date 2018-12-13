package TestScript.ExcelTest_Songji_Dingdanliebiao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Logger.Dailylog;

public class CompareContents_Songji_Dingdanliebiao {
	
	
	String sourceFile;
	String destinationFile;
	String dingdan_sheetName;
	String liushui_sheetName;
	String result_sheetName;
	
	//订单列表
	String dingdanhao_orders;
	String yewudingdanhao_orders;
	String shangpinmingcheng_orders;
	String goumairen_orders;
	String dianpuming_orders;
	String dianpuID_orders;
	String pinlei_orders;
	String gongyingshang_orders;
	String gongyingshang_JC_orders;
	String xiaoshoujine_orders;
	String zhifujine_orders;
	String gongyingshangbutie_orders;
	
	//流水列表
	
	String dingdanhao_liushui;
	String yewudingdanhao_liushui;
	String shangpingmingcheng_liushui;
	String goumairen_liushui;
	String dianpuming_liushui;
	String dianpuID_liushui;
	String pinlie_liushui;
	String gongyingshang_liushui;
	String gongyingshang_JC_liushui;
	String xiaoshoujine_liushui;
	String zhifujine_lihshui;
	String gongyingshangbutie_liushui;
	
	
	
	
	
	/**
	 * 订单号   业务订单号  商品名称  购买人  店铺名 店铺id  品类  供应商   供应商简称  销售金额     支付金额  （退款金额）  供应商补贴
	 * 
	 * 	 */
	
	
	public CompareContents_Songji_Dingdanliebiao(String sourceFile,
												String destinationFile,
												String liushui_sheetName,
												String dingdan_sheetName,
												String result_sheetName,
												
												//订单列表
												String dingdanhao_orders,
												String yewudingdanhao_orders,
												String shangpinmingcheng_orders,
												String goumairen_orders,
												String dianpuming_orders,
												String dianpuID_orders,
												String pinlei_orders,
												String gongyingshang_orders,
												String gongyingshang_JC_orders,
												String xiaoshoujine_orders,
												String zhifujine_orders,
												String gongyingshangbutie_orders,
												
												//流水列表
												
												String dingdanhao_liushui,
												String yewudingdanhao_liushui,
												String shangpingmingcheng_liushui,
												String goumairen_liushui,
												String dianpuming_liushui,
												String dianpuID_liushui,
												String pinlie_liushui,
												String gongyingshang_liushui,
												String gongyingshang_JC_liushui,
												String xiaoshoujine_liushui,
												String zhifujine_lihshui,
												String gongyingshangbutie_liushui){
		
		
				this.sourceFile=sourceFile;
				this.destinationFile=destinationFile;
				this.liushui_sheetName=liushui_sheetName;
				this.dingdan_sheetName=dingdan_sheetName;
				this.result_sheetName=result_sheetName;
				
				//订单列表
				this.dingdanhao_orders=dingdanhao_orders;
				this.yewudingdanhao_orders=yewudingdanhao_orders;
				this.shangpinmingcheng_orders=shangpinmingcheng_orders;
				this.goumairen_orders=goumairen_orders;
				this.dianpuming_orders=dianpuming_orders;
				this.dianpuID_orders=dianpuID_orders;
				this.pinlei_orders=pinlei_orders;
				this.gongyingshang_orders=gongyingshang_orders;
				this.gongyingshang_JC_orders=gongyingshang_JC_orders;
				this.xiaoshoujine_orders=xiaoshoujine_orders;
				this.zhifujine_orders=xiaoshoujine_orders;
				this.gongyingshangbutie_orders=gongyingshangbutie_orders;
				
				//流水列表
				
				this.dingdanhao_liushui=dingdanhao_liushui;
				this.yewudingdanhao_liushui=yewudingdanhao_liushui;
				this.shangpingmingcheng_liushui=shangpingmingcheng_liushui;
				this.goumairen_liushui=goumairen_liushui;
				this.dianpuming_liushui=dianpuming_liushui;
				this.dianpuID_liushui=dianpuID_liushui;
				this.pinlie_liushui=pinlie_liushui;
				this.gongyingshang_liushui=gongyingshang_liushui;
				this.gongyingshang_JC_liushui=gongyingshang_JC_liushui;
				this.xiaoshoujine_liushui=xiaoshoujine_liushui;
				this.zhifujine_lihshui=zhifujine_lihshui;
				this.gongyingshangbutie_liushui=gongyingshangbutie_liushui;
		
	}
	
	
	
	@Test
	public void test() throws Exception{
		
		
		File file = new File(sourceFile);
		
		if(file.exists()){
			System.out.println("exists");
		}
		
	
        //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_paysheet = xssfWorkbook.getSheetIndex(dingdan_sheetName);
        Dailylog.logInfo("index paysheet is :" + index_paysheet);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_paysheet);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
		
		
        
        
        
        
        
        
        
        
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
