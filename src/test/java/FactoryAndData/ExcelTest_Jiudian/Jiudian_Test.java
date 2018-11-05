package FactoryAndData.ExcelTest_Jiudian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Jiudian_Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		
//		String filePath = "C:\\Users\\gaopan\\Desktop\\新建文件夹 (2)\\test.xls";
//		
//		
//		WriterExcelUtil.createNewExcelFile(filePath);
		
		
//		Object obj = null;
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void createNewExcelFile1(String filePath){
		
		File file = new File(filePath);
		
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	public static void createNewExcelFile(String filePath){
		
		HSSFWorkbook book = new HSSFWorkbook();
		
		File file = new File(filePath);
		
		FileOutputStream fos = null;
		
		
		try {
			fos = new FileOutputStream(file);
			book.write(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(fos != null){
					fos.close();
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static String getValueFromConf(String filePath,String key) throws Exception{
		
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		
		Properties props = new Properties();
		
		props.load(fis);
		
		String value = props.getProperty(key);
		
		
		return value;
	}
}
