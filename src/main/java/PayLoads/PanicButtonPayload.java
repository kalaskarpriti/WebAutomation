package PayLoads;

import pojo.PanicButtonPojo;

public class PanicButtonPayload {
	PanicButtonPojo pb = new PanicButtonPojo();

	public PanicButtonPojo panicButton(String DeviceID, int pushed) {
		pb.setDeviceId(DeviceID);
		pb.setPushed(pushed);
		pb.setBattery(82);
		return pb;

	}

}
