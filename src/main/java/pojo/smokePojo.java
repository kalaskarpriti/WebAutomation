package pojo;

public class smokePojo extends SensorCommonPojo {
	private String deviceId;
	private boolean carbonMonoxide;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public boolean isCarbonMonoxide() {
		return carbonMonoxide;
	}

	public void setCarbonMonoxide(boolean carbonMonoxide) {
		this.carbonMonoxide = carbonMonoxide;
	}

}
