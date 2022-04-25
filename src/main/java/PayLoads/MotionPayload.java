package PayLoads;

import pojo.MotionPojo;

public class MotionPayload {

	MotionPojo mp = new MotionPojo();

	public MotionPojo motion(String deviceID, String motion) {
		mp.setDeviceID(deviceID);
		mp.setMotion(motion);
		return mp;
	}

}
