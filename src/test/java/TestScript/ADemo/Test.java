package TestScript.ADemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Logger.Dailylog;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		String[] strs = {"zhangsan","lisi","wangwu"};
		
		
		for(String str : strs){
			Dailylog.logInfo("str is :" + str);
		}
		
		
		
		
		
		
		
		
		

	}

	public static void listForEach() {
		List<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		
		
		list.forEach((element)->{
			
			System.out.println("element is :" + element);
			
			
		});
	}

	public static void forEachMap() {
		Map<String,String> map = new HashMap<String,String>();
		

		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		
		
		map.forEach((k,v)->{
			
			System.out.println("k is :" + k + "    v is :" + v);
			
		});
	}

}
