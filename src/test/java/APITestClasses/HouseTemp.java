package APITestClasses;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PayLoads.TempPayload;
import Tranquility.Utilities.ResourseType;
import Tranquility.Utilities.excelutility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HouseTemp extends RequestData {

	TempPayload data = new TempPayload();
	RequestSpecification request;
	static Response response;
	excelutility file = new excelutility();
	ResourseType type = new ResourseType();
	RequestData reqdata = new RequestData();

	@Test(priority = 1, dataProvider = "getTempData", groups = { "Smoke", "Regression" })
	public void houseTempTest(int temperaturevalue) throws IOException {
		ArrayList<String> input = file.getData("TempDeviceID", "Apidata");
		request = given().spec(getRequestEM("baseURI")).body(data.houseTemp(input.get(1), temperaturevalue));
		response = request.when().post(type.TranqulitysensorRes()).then().extract().response();
		assertEquals(response.getStatusCode(), 201);
	}

	@DataProvider
	public Object[] getTempData() throws InterruptedException {
		Object[] temperature = new Object[4];
		temperature[0] = 75;
		temperature[1] = 65;
		temperature[2] = 40;
		temperature[3] = 65;
		return temperature;
	}

}
