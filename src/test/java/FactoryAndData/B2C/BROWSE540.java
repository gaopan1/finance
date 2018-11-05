package FactoryAndData.B2C;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.Common;
import TestData.PropsUtils;
import TestScript.B2C.BROWSE18Test;
import TestScript.B2C.BROWSE540Test;

public class BROWSE540 {
	@DataProvider(name = "540")
	public static Object[][] Data540() {
		return Common.getFactoryData(new Object[][] { 
				{"JP"},
			},PropsUtils.getTargetStore("BROWSE-540"));
		
	}

	@Factory(dataProvider = "540")
	public Object[] createTest(String store) {

		Object[] tests = new Object[1];

		tests[0] = new BROWSE540Test( store);

		return tests;
	}
  
}
