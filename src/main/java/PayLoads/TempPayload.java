package PayLoads;

import pojo.SensorCommonPojo;
import pojo.TempPojo;

public class TempPayload {
	TempPojo temp = new TempPojo();

	public TempPojo houseTemp(String DeviceID, int temperature) {
		temp.setDeviceId(DeviceID);
		temp.setTemperature(temperature);
		temp.setPresenceDetected(false);
		temp.setLearning(false);
		temp.setEndTimestamp(0);
		temp.setEventId(null);
		temp.setLearning(false);
		temp.setSimulated(false);
		temp.setStatusUpdateTimestamp(0);
		temp.setType(null);
		temp.setTimestampStr(null);
		return temp;
	}

}
