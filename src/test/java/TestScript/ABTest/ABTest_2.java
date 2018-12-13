package TestScript.ABTest;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import CommonFunction.HttpCommon;
import CommonFunction.SQLHelper;
import Logger.Dailylog;

public class ABTest_2 {
	
	
	
	String udid = "";
	
	String sql = "select * from abtest_udid";
	
	
	//需要把udid从数据库中取出来存储到ArrayList中
	ArrayList<String> al = new ArrayList<String>();
	
	HttpCommon common = new HttpCommon();
	
	//需要经过第一个流量层过滤的url
	String requestUrl_1 = "http://www.zlhdev.ab";
	
	String result = "";
	
	String layerId="";
	String policyId="";
	String version = "";
	
	JSONObject object = null;
	
	String match= "";
	
	String uuid = "";
	
	String insertSQL = "insert into abtestresult_layer1(uuid,layerid,policyid,version,hit) values(?,?,?,?,?)";
	

	
	@Test
	public void test() {
		
		//首先读取元数据，udid
		
		SQLHelper helper = new SQLHelper();
		
		String[] parameters = {};
		
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
		
		//通过循环，进行接口请求，然后将数据写入到数据库中
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet httpGet = null;
		
		String udid_parameter = "";
		
		
		
		
		try{
			for(int x = 0; x<al.size();x++){
				
				String url = "";
				
				udid_parameter = al.get(x);
				
				url = requestUrl_1+"?open_udid="+udid_parameter;

				httpGet = new HttpGet(url);
				
				httpGet.setHeader("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G9350 Build/R16NW) mfwappcode/com.mfw.merchant.dailybuild mfwappver/2.0.0 mfwversioncode/28 mfwsdk/20140507 channel/MFWDefault mfwjssdk/1.1 mfwappjsapi/1.5");
				httpGet.setHeader("Cookie", "mfw_uid=abc");
				
				CloseableHttpResponse response = httpClient.execute(httpGet);
				
				HttpEntity entity = response.getEntity();
				
				result = EntityUtils.toString(entity);
				
				//对result进行解析 通过version 来区分，存进不同的数据表格中

				layerId = common.getJsonValue(result, "layerId");
				
				policyId = common.getJsonValue(result, "policyId");
				version = common.getJsonValue(result, "version");
				
				object = new JSONObject(result);
				match = object.getInt("match")+"";
				
				uuid = common.getJsonValue(result, "uuid");
				
				String[] paramaters = {uuid,layerId,policyId,version,match};
				
				helper.executeUpdate(insertSQL, paramaters);
				
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

}
