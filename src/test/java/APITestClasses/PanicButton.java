package APITestClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PayLoads.PanicButtonPayload;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import Tranquility.Utilities.ResourseType;
import Tranquility.Utilities.excelutility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PanicButton extends RequestData {
	PanicButtonPayload data = new PanicButtonPayload();
	RequestSpecification request;
	static Response response;
	excelutility file = new excelutility();
	ResourseType type = new ResourseType();

	@Test(dataProvider = "getPanicData", groups = { "Regression" })
	public void panicButtonTest(int pushvalue) throws IOException {

		ArrayList<String> input = file.getData("PanicDeviceID", "Apidata");
		request = given().spec(getRequestEM("baseURI")).body(data.panicButton(input.get(1), pushvalue));
		response = request.when().post(type.TranqulitysensorRes()).then().extract().response();
		assertEquals(response.getStatusCode(), 201);
	}

	@DataProvider
	public Object[] getPanicData() {
		Object[] pushed = new Object[2];
		pushed[0] = 1;
		pushed[1] = 0;
		return pushed;
	}

}
