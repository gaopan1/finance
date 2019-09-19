package TestScript.ABTest.ThreadPool;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import CommonFunction.HttpCommon;
import CommonFunction.SQLHelper;

public class NewFixedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> al = getUdid();
		
		HttpCommon common = new HttpCommon();
		
		String requestUrl_1 = "https://market.mafengwo.cn/api/starshop/citylist";

		String insertSQL = "insert into abtestresult_layer2(uuid,layerid,policyid,version,hit) values(?,?,?,?,?)";
		
		int len = al.size();
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		
		
		for(int i =0; i<len;i++){
			
			final int index = i;
			
			fixedThreadPool.execute(new Runnable(){
				
				public void run(){
					
					System.out.println("i is :" + index + "Thread name is :" + Thread.currentThread().getName());
					CloseableHttpClient httpClient = null;
					
					try {
						
						httpClient = HttpClients.createDefault();
						
						String url = "";
						
						String udid_parameter = al.get(index);
						
						url = requestUrl_1+"?open_udid="+udid_parameter;

//						System.out.println("url is :" +url);
						
						HttpGet httpGet = new HttpGet(url);
						
						httpGet.setHeader("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G9350 Build/R16NW) mfwappcode/com.mfw.merchant.dailybuild mfwappver/2.0.0 mfwversioncode/28 mfwsdk/20140507 channel/MFWDefault mfwjssdk/1.1 mfwappjsapi/1.5");
						//httpGet.setHeader("HOST", "market.mafengwo.cn");
						
						CloseableHttpResponse response = httpClient.execute(httpGet);
						
						HttpEntity entity = response.getEntity();
						
						String result = EntityUtils.toString(entity,"utf-8");
						
//						Dailylog.logInfo("result is :" + result);
						
//						System.out.println("result is :::::::::::::::::::::::::::::"+result);
						
						//对result进行解析 通过version 来区分，存进不同的数据表格中

						String layerId = common.getJsonValue(result, "layerId");
						
						String policyId = common.getJsonValue(result, "policyId");
						String version = common.getJsonValue(result, "version");
						
						JSONObject object = new JSONObject(result);
						String match = object.getInt("match")+"";
						
						String uuid = common.getJsonValue(result, "uuid");
						
						String[] paramaters = {uuid,layerId,policyId,version,match};
						
						SQLHelper helper = new SQLHelper();
						
						helper.executeUpdate(insertSQL, paramaters);
	
					} catch (Exception e) {
						// TODO Auto-generated catch block
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
				
				
			});
			
			
			
			
			
		}
		
		if(!fixedThreadPool.isShutdown()){
			fixedThreadPool.shutdown();
		}

	}
	
	
	public static  ArrayList<String> getUdid(){

		String[] parameters = {};
		
		String udid = "";
		
//		String sql = "select * from abtest_udid";
		
		String sql = "select * from abtestresult_layer1 where policyid = '43'";
		
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
