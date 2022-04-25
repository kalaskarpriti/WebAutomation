package APITestClasses;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import PayLoads.AddPlacePayload;
import Tranquility.Utilities.ResourseType;
import Tranquility.Utilities.excelutility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddPlaceAPI extends RequestData {
	RequestSpecification request;
	static Response response;
	static String placeid;
	ResourseType resourseValue;
	AddPlacePayload data = new AddPlacePayload();
	excelutility file = new excelutility();
	ResourseType type = new ResourseType();
	RequestData reqdata = new RequestData();

	@Test
	public void addPlace() throws IOException {
		ArrayList<String> data1 = file.getData("Location1", "Apidata");

		request = given().spec(getRequest("baseURL")).body(data.AddplacePL(data1.get(1), data1.get(2)));
		response = request.when().post(type.addAPI()).then().extract().response();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void addSecondPlace() throws IOException {
		ArrayList<String> data1 = file.getData("Location2", "Apidata");

		request = given().spec(getRequest("baseURL")).body(data.AddplacePL(data1.get(1), data1.get(2)));
		response = request.when().post(type.addAPI()).then().extract().response();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(RequestData.jsonPath(response, "status"), "OK");

	}

	@Test(priority = 3)
	public void getPlace() throws IOException {
		placeid = RequestData.jsonPath(response, "place_id");
		request = given().spec(getRequest("baseURL")).queryParam("place_id", placeid);
		response = request.when().get(type.getAPI()).then().extract().response();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void deletePlace() throws IOException {
		request = given().spec(getRequest("baseURL")).body(data.deleteplaeid(placeid));
		request.when().post(type.deleteAPI()).then().extract().response();
	}

}
