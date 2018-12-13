package CommonFunction;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SQLHelper {
	
	 String driver= Common.getValueFromConf("db.properties", "driver");
	 String url = Common.getValueFromConf("db.properties", "url");
	 String username = Common.getValueFromConf("db.properties", "username");
	 String pwd = Common.getValueFromConf("db.properties", "pwd");
	
	 InputStream ins = null;
	 Properties props = null;
	
	 Connection conn;
	 PreparedStatement ps;
	 ResultSet rs;
	public  ResultSet getRs(){
		return rs;
	}
	
	public  PreparedStatement getPs(){
		return ps;
	}
	
	public  Connection getConn(){
		
		return conn;
	}
	
	public  Connection getConnection(){
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, username, pwd);
			
			if(!conn.isClosed()){
				System.out.println("���ݿ����ӳɹ�");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	
	public  ResultSet executeQuery(String sql,String[] parameters){
		
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			
			for(int x =1; x<=parameters.length;x++){
				
				ps.setObject(x, parameters[x-1]);
			}
			
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;

	}
	
	
	
	public  boolean executeUpdate(String sql,Object[] parameters){
		
		boolean flag = false;
		
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			
			
			for(int x =1; x<=parameters.length; x++){
				
				ps.setObject(x, parameters[x-1]);
			}
			
			int t = ps.executeUpdate();
			
			if(t >0){
				flag = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			closeResource(getConn(), getPs(), getRs());

		}

		return flag;
	}
	public  void closeResource(Connection conn,PreparedStatement ps,ResultSet rs){
		
		try {
			if(conn != null){
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(ps != null){
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			if(rs != null){
				rs.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
