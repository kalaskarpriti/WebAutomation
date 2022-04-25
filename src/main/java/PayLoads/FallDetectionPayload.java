package PayLoads;

import pojo.FallDetectionPojo;

public class FallDetectionPayload extends FallDetectionPojo {
	FallDetectionPojo fl = new FallDetectionPojo();

	public FallDetectionPojo FallDetection(String DeviceID, String Status) {
		fl.setPresenceDetected(false);
		fl.setLearning(false);
		fl.setEndTimestamp(0);
		fl.setEventId(null);
		fl.setLearning(false);
		fl.setSimulated(false);
		fl.setStatusUpdateTimestamp(0);
		fl.setType(null);
		fl.setTimestampStr(null);
		fl.setDeviceId(DeviceID);
		fl.setStatus(Status);
		return fl;

	}
}
