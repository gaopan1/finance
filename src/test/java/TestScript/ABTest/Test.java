package TestScript.ABTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CommonFunction.SQLHelper;
import Logger.Dailylog;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> al = getUdid();
		
		
		Dailylog.logInfo("al size is :"+ al.size()+"first is :"+al.get(0));
		
		

	}
	
	
	public static ArrayList<String> getUdid(){

		String[] parameters = {};
		
		String udid = "";
		
//		String sql = "select * from abtest_udid";
		
		String sql = "select * from abtestresult_layer1 where policyid = '17'";
		
		ArrayList<String> al = new ArrayList<String>();
		
		SQLHelper helper = new SQLHelper();
		
		ResultSet rs = helper.executeQuery(sql, parameters);
		
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
		
		return al;
		
	}

}
