package APITestClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class RequestData {
	public static RequestSpecification response;

	public RequestSpecification getRequest(String url) throws IOException {

		if (response == null) {

			PrintStream log = new PrintStream(new FileOutputStream("logtext.txt"));

			response = new RequestSpecBuilder().setBaseUri(getBaseValue(url)).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return response;
		}
		return response;
	}

	public RequestSpecification getRequestEM(String url) throws IOException {

		if (response == null) {

			PrintStream log = new PrintStream(new FileOutputStream("Sensordata.txt"));

			response = new RequestSpecBuilder().setBaseUri(getBaseValue(url)).addQueryParam("timeout", "60")
					.addQueryParam("api-version", "2014-01")
					.addHeader("Authorization",
							"SharedAccessSignature sr=liberate-staging.servicebus.windows.net&sig=ZpcQn1DG8ruQXcVP0fgqa5kP6j6XR9czXSCBkLlYuic%3d&se=1761807990&skn=Hubitat")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return response;
		}
		return response;
	}

	public static String getBaseValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\PRITI\\eclipse-workspace\\Embrace\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String baseURL = prop.getProperty(key);
		return baseURL;

	}

	public static String jsonPath(Response response, String value) {

		JsonPath js = new JsonPath(response.asString());
		return js.get(value).toString();
	}

}
