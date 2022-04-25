package APITestClasses;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PayLoads.FallDetectionPayload;
import PayLoads.SmokeCO2payload;
import PayLoads.SmokePayload;
import Tranquility.Utilities.ResourseType;
import Tranquility.Utilities.excelutility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Smoke extends RequestData {
	RequestSpecification request;
	static Response response;
	SmokePayload data = new SmokePayload();
	SmokeCO2payload data1 = new SmokeCO2payload();
	excelutility file = new excelutility();
	ResourseType type = new ResourseType();
	RequestData reqdata = new RequestData();

	@Test(dataProvider = "getsmokedata", groups = { "Regression" })
	public void smokeCO(boolean smokevalue) throws IOException {
		ArrayList<String> input = file.getData("SmokeDeviceID", "Apidata");
		request = given().spec(getRequestEM("baseURI")).body(data.smokeTest(input.get(1), smokevalue));
		response = request.when().post(type.TranqulitysensorRes()).then().extract().response();
		assertEquals(response.getStatusCode(), 201);
	}

	@Test(dataProvider = "getsmokedata", groups = { "Regression" })
	public void smokeCO2(boolean smokevalue) throws IOException {
		ArrayList<String> input = file.getData("SmokeDeviceID", "Apidata");
		request = given().spec(getRequestEM("baseURI")).body(data1.smokeCO2Test(input.get(1), smokevalue));
		response = request.when().post(type.TranqulitysensorRes()).then().extract().response();
		assertEquals(response.getStatusCode(), 201);
	}

	@DataProvider
	public Object[] getsmokedata() {
		Object[] smoke = new Object[2];
		smoke[0] = true;
		smoke[1] = false;
		return smoke;
	}

}
