package FactoryAndData.B2B;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.Common;
import TestData.PropsUtils;
import TestScript.B2B.NA25662Test;

public class NA25662{

	@DataProvider(name = "NA25662")
	public static Object[][] Data25661() {
		return Common.getFactoryData(new Object[][] {
			{ "US" }
		}, PropsUtils.getTargetStore("NA-25662"));
	}
	@Factory(dataProvider = "NA25662")
	public Object[] createTest(String store) {

		Object[] tests = new Object[1];

		tests[0] = new NA25662Test(store);

		return tests;
	}
}
