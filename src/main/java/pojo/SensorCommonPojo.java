package pojo;

public class SensorCommonPojo {

	private long endTimestamp;
	private boolean isLearning;
	private boolean isSimulated;
	private boolean presenceDetected;
	private long statusUpdateTimestamp;
	private String type;
	private String timestampStr;
	private String eventId;
	private long timestamp;

	public boolean isPresenceDetected() {
		return presenceDetected;
	}

	public void setPresenceDetected(boolean presenceDetected) {
		this.presenceDetected = presenceDetected;
	}

	public long getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(long endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public boolean isLearning() {
		return isLearning;
	}

	public void setLearning(boolean isLearning) {
		this.isLearning = isLearning;
	}

	public boolean isSimulated() {
		return isSimulated;
	}

	public void setSimulated(boolean isSimulated) {
		this.isSimulated = isSimulated;
	}

	public long getStatusUpdateTimestamp() {
		return statusUpdateTimestamp;
	}

	public void setStatusUpdateTimestamp(long statusUpdateTimestamp) {
		this.statusUpdateTimestamp = statusUpdateTimestamp;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimestampStr() {
		return timestampStr;
	}

	public void setTimestampStr(String timestampStr) {
		this.timestampStr = timestampStr;
	}

}
