package PayLoads;

import pojo.SmokeCO2Pojo;
import pojo.smokePojo;

public class SmokeCO2payload {

	SmokeCO2Pojo smoke = new SmokeCO2Pojo();

	public SmokeCO2Pojo smokeCO2Test(String deviceID, boolean carbonDioxide) {
		smoke.setDeviceId(deviceID);
		smoke.setCarbonDioxide(carbonDioxide);
		return smoke;
	}

}
