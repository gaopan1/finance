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

public class ABTest {
	
	
	
	String udid;

	//需要把udid从数据库中取出来存储到ArrayList中
	
	
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
	
	
	
	
	public ABTest(String udid){
		
		this.udid = udid;
		
	}
	
	
	
	
	@Test
	public void test() {
		
		
		requestUrl_1 = requestUrl_1+"?open_udid="+udid;
		
		//通过循环，进行接口请求，然后将数据写入到数据库中
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet httpGet = null;
		
		SQLHelper helper = new SQLHelper();
		
		
		try{

				httpGet = new HttpGet(requestUrl_1);
				
				CloseableHttpResponse response = httpClient.execute(httpGet);
				
				HttpEntity entity = response.getEntity();
				
				result = EntityUtils.toString(entity);
				
				Dailylog.logInfo("result is ：" + result);
				
				//对result进行解析 通过version 来区分，存进不同的数据表格中
				
				
				object = new JSONObject(result);
				
				layerId = object.getInt("layerId")+"";
				
				Dailylog.logInfo("layerId is :" + layerId);
				
				policyId = object.getInt("policyId")+"";
						
				version = object.getString("version");

				match = object.getInt("match")+"";
				
				uuid = object.getString("uuid");
				
				String[] paramaters = {uuid,layerId,policyId,version,match};
				
				helper.executeUpdate(insertSQL, paramaters);
				
			
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
