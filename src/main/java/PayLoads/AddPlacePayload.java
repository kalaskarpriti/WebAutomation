package PayLoads;

import java.util.ArrayList;
import java.util.List;

import pojo.GooglePojo;
import pojo.location;

public class AddPlacePayload {

	public GooglePojo AddplacePL(String name, String Language) {
		GooglePojo pj = new GooglePojo();
		pj.setAccuracy(60);
		pj.setAddress("This is test address");
		pj.setLanguage(Language);
		pj.setName(name);
		pj.setPhone_number("9799867676");
		pj.setWebsite("https://google.com");

		List<String> tp = new ArrayList<String>();
		tp.add("Type1");
		tp.add("Type2");
		pj.setTypes(tp);

		location l = new location();
		l.setLat(-67.99);
		l.setLng(88.99);
		pj.setLocation(l);
		return pj;

	}

	public String deleteplaeid(String placeid) {
		return "{\r\n" + "    \"place_id\":\"" + placeid + "\"\r\n" + "}";
	}
}
