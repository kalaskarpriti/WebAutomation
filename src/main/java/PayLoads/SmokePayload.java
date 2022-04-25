package PayLoads;

import pojo.SensorCommonPojo;
import pojo.smokePojo;

public class SmokePayload {

	smokePojo smoke = new smokePojo();

	public smokePojo smokeTest(String deviceID, boolean carbonMonoxide) {
		smoke.setDeviceId(deviceID);
		smoke.setCarbonMonoxide(carbonMonoxide);
		return smoke;
	}
}
