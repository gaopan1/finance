package FactoryAndData.B2C;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.Common;
import TestData.PropsUtils;
import TestScript.B2C.ACCT29Test;

public class ACCT29 {

	@DataProvider(name = "ACCT29")
	public static Object[][] DataACCT29() {
		return Common.getFactoryData(new Object[][] { 
			{ "AU" }
		},PropsUtils.getTargetStore("ACCT29"));
	}

	@Factory(dataProvider = "ACCT29")
	public Object[] createTest(String store) {

		Object[] tests = new Object[1];

		tests[0] = new ACCT29Test(store);

		return tests;
	}

}
