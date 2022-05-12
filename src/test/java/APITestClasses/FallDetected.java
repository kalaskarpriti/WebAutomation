package APITestClasses;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import PayLoads.FallDetectionPayload;
import Tranquility.Utilities.ResourseType;
import Tranquility.Utilities.excelutility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FallDetected extends RequestData {

	RequestSpecification request;
	static Response response;
	FallDetectionPayload data = new FallDetectionPayload();
	excelutility file = new excelutility();
	ResourseType type = new ResourseType();
	RequestData reqdata = new RequestData();

	@Test(groups = { "Smoke", "Regression" })
	public void fall() throws IOException {
		ArrayList<String> input = file.getData("FallDeviceID", "Apidata");
		request = given().spec(getRequestEM("baseURI")).body(data.FallDetection(input.get(1), input.get(2)));
		response = request.when().post(type.TranquilityResourse()).then().extract().response();
		assertEquals(response.getStatusCode(), 201);
	}
}
