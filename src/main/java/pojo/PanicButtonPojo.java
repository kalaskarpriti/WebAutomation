package pojo;

public class PanicButtonPojo extends SensorCommonPojo {

	private String deviceId;
	private int pushed;
	private int battery;

	public int getPushed() {
		return pushed;
	}

	public void setPushed(int pushed2) {
		this.pushed = pushed2;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
