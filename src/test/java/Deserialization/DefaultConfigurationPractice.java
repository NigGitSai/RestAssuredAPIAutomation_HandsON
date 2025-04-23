package Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class DefaultConfigurationPractice {

	
	@Test
	public void defaultConfigPractice() throws IOException
	{
		File storeJson = new File("./src/test/resources/BookStore.json");
		
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.ALWAYS_RETURN_LIST,Option.REQUIRE_PROPERTIES,Option.SUPPRESS_EXCEPTIONS,Option.DEFAULT_PATH_LEAF_TO_NULL);
		
		List<Double> price = JsonPath.using(config).parse(storeJson).read("$.store.bicycle.price");
		
		System.out.println("bicycyle price is "+price);
		
		List<String> brand = JsonPath.using(config).parse(storeJson).read("$.store.bicycle.brand");
		
		System.out.println("bicycyle brand is "+brand);
		
		List<String> colorPrice = JsonPath.using(config).parse(storeJson).read("$.store.bicycle[color,price]");
		System.out.println("bicycyle brand is "+colorPrice);
	}
}
