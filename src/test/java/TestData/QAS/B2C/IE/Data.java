package TestData.QAS.B2C.IE;

import java.util.ArrayList;
import java.util.List;

import Dao.impl.AutoReportImpl;
import Dao.inter.AutoReportDao;
import TestData.B2CData;
import TestData.PropsUtils;

public class Data extends B2CData {
	private List<String> CTO;
	private List<String> MTM;
	private List<String> ACC;
	public static AutoReportDao daoService = null;
	@Override
	public String getHomePageUrl() {
		return TestData.QAS.EnvData.HttpsDomain + "/ie/en/ieweb";
	}

	@Override
	public String getGateKeeperPassCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGateKeeperSerialNmuber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGateKeeperSerialLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGateKeeperRegistrationLenovoID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGateKeeperRegistrationPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultMTMPN() {
		if (MTM != null) {
			if (MTM.get(0) != null) {
				return MTM.get(0);
			} else {
				// if DB is empty return a hardcoded value
		return "80Q000A9UK";
			}
		} else {

			if (daoService == null) {
				daoService = AutoReportImpl.creatInstance(PropsUtils.getParameter("PreC"));
			}
			MTM = new ArrayList<String>();
			MTM = daoService.getProductNB("IE", "MTM","PreC");

			if (MTM.get(0) != null) {
				return MTM.get(0);
			} else {
				// if DB is empty return a hardcoded value
				return "80Q000A9UK";
			}
		}
	
	}
	@Override
	public String getDefaultMTMPN2() {
		if (MTM != null) {
			if (MTM.get(0) != null) {
				return MTM.get(0);
			} else {
				// if DB is empty return a hardcoded value
				return "80Q000A9UK";
			}
		} else {

			if (daoService == null) {
				daoService = AutoReportImpl.creatInstance(PropsUtils.getParameter("PreC"));
			}
			MTM = new ArrayList<String>();
			MTM = daoService.getProductNB2("IE", "MTM","PreC");

			if (MTM.get(0) != null) {
				return MTM.get(0);
			} else {
				// if DB is empty return a hardcoded value
				return "80Q000A9UK";
			}
		}
	}
	@Override
	public String getDefaultAddressLine1() {
		// TODO Auto-generated method stub
		return "377 Frankton Road";
	}

	@Override
	public String getDefaultAddressCity() {
		// TODO Auto-generated method stub
		return "New Zealand";
	}

	@Override
	public String getDefaultAddressPostCode() {
		// TODO Auto-generated method stub
		return "2067";
	}

	@Override
	public String getDefaultAddressState() {
		// TODO Auto-generated method stub
		return "Clare";
	}

	@Override
	public String getDefaultAddressPhone() {
		// TODO Auto-generated method stub
		return "1234567890";
	}

	@Override
	public String getOverwritePN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnit() {
		return "ieweb";
	}

	@Override
	public String getBatchAssignPN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoginID() {
		return "lisong2@lenovo.com";
	}

	@Override
	public String getRepID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultCTOPN() {
		if (CTO != null) {
			if (CTO.get(0) != null) {
				return CTO.get(0);
			} else {
				// if DB is empty return a hardcoded value
				return null;
			}
		} else {
		if (daoService == null) {
			daoService = AutoReportImpl.creatInstance(PropsUtils.getParameter("PreC"));
		}
		CTO = new ArrayList<String>();
		CTO = daoService.getProductNB("IE", "CTO" ,"PreC");
		if (CTO.get(0) != null) {
			return CTO.get(0);
		} else {
			return null;
		}}
		
	}

	@Override
	public String getLoginPassword() {
		return "1q2w3e4r";
	}

	@Override
	public String getStore() {
		return "ieweb";
	}

	@Override
	public String getTelesalesAccount() {
		return "youngmeng_n";
	}

	@Override
	public String getTelesalesPassword() {
		return "Lenovo-1";
	}

	@Override
	public String getConsumerTaxNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTeleSalesUrl() {
		// TODO Auto-generated method stub
		return TestData.QAS.EnvData.TeleSalesDomain + "/ie/en/ieweb";
	}

	@Override
	public String getPartSalesUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebsites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultAccessoryPN() {
		if (ACC != null) {
			if (ACC.get(0) != null) {
				return ACC.get(0);
			} else {
				// if DB is empty return a hardcoded value
				return "80NV008GAU";
			}
		} else {

			if (daoService == null) {
				daoService = AutoReportImpl.creatInstance(PropsUtils.getParameter("PreC"));
			}
			ACC = new ArrayList<String>();
			ACC = daoService.getProductNB("IE", "Accessory","PreC");

			if (ACC.get(0) != null) {
				return ACC.get(0);
			} else {
				// if DB is empty return a hardcoded value
				return "80RV003NAU";
			}
		}
	}
	
	@Override
	public String getResetPasswordId(){
		return "iepassword_b2c@sharklasers.com";
	}

	@Override
	public ArrayList<String> getContentMigrationURLs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValueAlertPositive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInvalidQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNewPartNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCartName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
