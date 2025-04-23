package APIRequestPractice;

import java.io.File;
import java.io.FileNotFoundException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.internal.support.FileReader;

public class ReadJsonUsingJsonParser {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		JsonParser jsonParser = new JsonParser();
		File file = new File("");
		java.io.FileReader reader = new java.io.FileReader(file);
		
			Object parsedJson = jsonParser.parse(reader);
				JsonObject jsonObject = (JsonObject)parsedJson;
				JsonElement name =  jsonObject.get("Name");
				name.toString();
	}

}
