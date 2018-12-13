package TestScript.ABTest;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import CommonFunction.HttpCommon;
import CommonFunction.SQLHelper;

public class ABTestThread implements Runnable{
	
	ArrayList<String> al = getUdid();
	
	public static Object obj = new Object();

	HttpCommon common = new HttpCommon();

	//需要经过第一个流量层过滤的url
//	String requestUrl_1 = "http://www.zlhdev.ab/zlh/test";
	
	String requestUrl_1 = "http://www.zlhdev.ab/zlh/layer";
	
	
	String result = "";
	
	String layerId="";
	String policyId="";
	String version = "";
	
	JSONObject object = null;
	
	String match= "";
	
	String uuid = "";
	
	String insertSQL = "insert into abtestresult_layer2(uuid,layerid,policyid,version,hit) values(?,?,?,?,?)";
	
	
	int len = al.size();
	
	public  void run(){
		
		//通过循环，进行接口请求，然后将数据写入到数据库中
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet httpGet = null;
		
		String udid_parameter = "";

		try{
			
			while(true){
				
				synchronized(this){
				
				if(len >=1){
					String url = "";
					
					udid_parameter = al.get(len-1);
					
					url = requestUrl_1+"?open_udid="+udid_parameter;

//					Dailylog.logInfo("url is :" + url);
					
					httpGet = new HttpGet(url);
					
					httpGet.setHeader("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G9350 Build/R16NW) mfwappcode/com.mfw.merchant.dailybuild mfwappver/2.0.0 mfwversioncode/28 mfwsdk/20140507 channel/MFWDefault mfwjssdk/1.1 mfwappjsapi/1.5");
					httpGet.setHeader("Cookie", "mfw_uid=abc");
					
					CloseableHttpResponse response = httpClient.execute(httpGet);
					
					HttpEntity entity = response.getEntity();
					
					result = EntityUtils.toString(entity,"utf-8");
					
//					Dailylog.logInfo("result is :" + result);
					
//					System.out.println("result is :::::::::::::::::::::::::::::"+result);
					
					//对result进行解析 通过version 来区分，存进不同的数据表格中

					layerId = common.getJsonValue(result, "layerId");
					
					policyId = common.getJsonValue(result, "policyId");
					version = common.getJsonValue(result, "version");
					
					object = new JSONObject(result);
					match = object.getInt("match")+"";
					
					uuid = common.getJsonValue(result, "uuid");
					
					String[] paramaters = {uuid,layerId,policyId,version,match};
					
					SQLHelper helper = new SQLHelper();
					
					helper.executeUpdate(insertSQL, paramaters);
					
//					System.out.println("len is :::::::" + len + "Thread is：" + Thread.currentThread().getName());
				
					len--;
					
				}else{
					break;
				}
			}
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(httpClient != null){
				try {
					httpClient.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	
	}
	
	public ArrayList<String> getUdid(){

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
