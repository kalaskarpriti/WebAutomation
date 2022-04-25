package APITestClasses;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PayLoads.MotionPayload;
import Tranquility.Utilities.ResourseType;
import Tranquility.Utilities.excelutility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MotionTest extends RequestData {
	MotionPayload data = new MotionPayload();
	RequestSpecification request;
	static Response response;
	excelutility file = new excelutility();
	ResourseType type = new ResourseType();

	@Test(dataProvider = "getMotionData", groups = { "Regression" })
	public void MotionTest(String motionvalue) throws IOException {

		ArrayList<String> input = file.getData("MotionDeviceID", "Apidata");
		request = given().spec(getRequestEM("baseURI")).body(data.motion(input.get(1), motionvalue));
		response = request.when().post(type.TranqulitysensorRes()).then().extract().response();
		assertEquals(response.getStatusCode(), 201);
	}

	@DataProvider
	public String[] getMotionData() {
		String[] motion = new String[2];
		motion[0] = "active";
		motion[1] = "inactive";
		return motion;
	}

}
