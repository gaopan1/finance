package FactoryAndData.ABTestData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.SQLHelper;
import Logger.Dailylog;
import TestScript.ABTest.ABTest;

public class ABTestData {

	
	
	
	
	
		@DataProvider(name = "NA28114")
		public static Object[][] Data28114() {
			
			ArrayList<String> al = new ArrayList<String>();
			
			SQLHelper helper = new SQLHelper();
			
			String[] parameters = {};
			
			String sql = "select * from abtest_udid";
			
			ResultSet rs = helper.executeQuery(sql, parameters);
			
		    String udid= "";
			
			try {
				while(rs.next()){
					
					udid = rs.getString(2);
					
					al.add(udid);
		
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				helper.closeResource(helper.getConn(), helper.getPs(), helper.getRs());
			}
			
			//将al 中的数据封装到一个二维度数组中
			
			
			Object[][] obj = new Object[20000][1];
			
			String temp = "";
			
			for(int x = 0; x<20000; x++){
				
				temp = al.get(x);
				
				Dailylog.logInfo("temp is :" + temp + "x is :" + x);
				
				obj[x][0] = temp;	
			}
			
			
			Dailylog.logInfo("obj size is ：" + obj.length);
			
			
			Dailylog.logInfo("obj is ：" + obj);
			
			/*Object[][] obj1 = new Object[1][1];
			
			obj1[0][0]="33F49115-7201-4B68-A80C-E9553E2418AC";*/
								
			return obj;
			
			
		}

		@Factory(dataProvider = "NA28114")
		public Object[] createTest(String udid) {

			Object[] tests = new Object[1];

			tests[0] = new ABTest(udid);

			return tests;
		}

	
}
