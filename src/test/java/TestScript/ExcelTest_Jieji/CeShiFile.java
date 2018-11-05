package TestScript.ExcelTest_Jieji;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class CeShiFile {


	
	@Test
	public void test1(){
		System.out.println("test1");
	}
	
	@Test
	public void test2(){
		
		System.out.println("test2");

	}
	
	
	
	
	
	
	public static double getValidNumbersOfDouble(double dou,int num){
		
		
		BigDecimal   b   =   new   BigDecimal(dou);  
		
		double   f1   =   b.setScale(num,   BigDecimal.ROUND_HALF_DOWN).doubleValue();  
		
		return f1;
		
	}
	
	public static double getFloatPrice(String price){
		
		double ff = Double.parseDouble(price);
		

		double tt = (double)Math.round(ff*100)/100;
				
		return tt;	
		
	}
	
	
	public static  String getCorrespondingSupplier(String supplier){
		
		//根据支付中心的供应商 来返回 账单流水供应商
		// 支付中心  店铺名    流水表 OTA
		 String str = "";
		
		switch(supplier){
			case "agoda":
				str = "agoda";
				break;
			case "cnbooking":
				str = "cnbooking";
				break;
			case "dotw":
				str = "dotw";
				break;
			case "eanpkg":
				str = "ean_pkg";
				break;
			case "elongppcn":
				str = "elongpp_cn";
				break;
			case "expedia":
				str = "expedia";
				break;
			case "GTA":
				str = "GTA";
				break;
			case "host":
				str = "host";
				break;
			case "hotelbeds":
				str = "hotelbeds";
				break;
			case "htbpkg":
				str = "htb_pkg";
				break;
			case "Jalan":
				str = "Jalan";
				break;
			case "Jtb":
				str = "Jtb";
				break;
			case "ppctrip":
				str = "ppctrip";
				break;
			case "ppctripintl":
				str = "ppctrip_intl";
				break;
			case "tcc":
				str = "tcc";
				break;
			case "toptown":
				str = "toptown";
				break;
			case "tourico":
				str = "tourico";
				break;
			case "WebBeds":
				str = "WebBeds";
				break;
			case "zyx":
				str = "zyx";
				break;
			case "其他":
				str = "host";
				break;
			default:
				str = "NA";
				break;	
		}
		
		return str;
	
	}
	
	
public static void createExcels(String filePath){
		
		File file = new File(filePath);
		
		HSSFWorkbook  book = new HSSFWorkbook();
		
		FileOutputStream fos = null;
		
		try{
			fos = new FileOutputStream(file);
			book.write(fos);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fos.close();
				book.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}	
	}

}
