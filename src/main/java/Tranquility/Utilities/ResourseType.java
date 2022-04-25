package Tranquility.Utilities;

public class ResourseType {

	private String AddPlaceAPI = "/maps/api/place/add/json";
	private String getPlaceAPI = "/maps/api/place/get/json";
	private String deletePlaceAPI = "/maps/api/place/delete/json";
	private String EmbraceAPI = "vayyar-events/messages";
	private String SensorAPI = "sensor-events/messages";

	public String addAPI() {
		return AddPlaceAPI;
	}

	public String getAPI() {
		return getPlaceAPI;
	}

	public String deleteAPI() {
		return deletePlaceAPI;
	}

	public String TranquilityResourse() {
		return EmbraceAPI;
	}

	public String TranqulitysensorRes() {
		return SensorAPI;
	}

}
