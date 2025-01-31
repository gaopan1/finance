package FactoryAndData.B2C;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.Common;
import TestData.PropsUtils;
import TestScript.B2C.NA17667Test;


public class NA17667 {
	@DataProvider(name = "17667")
	public static Object[][] Data17667() {
		return Common.getFactoryData(new Object[][] {				
				{ "AU"},				
				{ "US"},
				{ "USEPP"},				
				{ "CA_AFFINITY"},
				{ "US_BPCTO"},			
				{ "HK"},			
				{ "JP"}						
		},PropsUtils.getTargetStore("NA-17667"));
	}

	@Factory(dataProvider = "17667")
	public Object[] createTest(String store) {

		Object[] tests = new Object[1];

		tests[0] = new NA17667Test(store);

		return tests;
	}

}
