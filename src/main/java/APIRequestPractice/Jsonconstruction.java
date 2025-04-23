package APIRequestPractice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Jsonconstruction {
	
	@Test
	public void test1()
	{
		JSONObject latitude = new JSONObject();
		latitude.put("lat", 33.427362);
		latitude.put("lng", 32.427362);
		
		JSONObject location  = new JSONObject();
		location.put("location", latitude);
		
		JSONArray types = new JSONArray();
		types.add("shoe park");
		types.add("shop");
		
		location.put("types", types);
		location.put("accuracy", 50);
		
		String jsonString = location.toJSONString();
		System.out.println(jsonString);
		
		
		
	}

}
