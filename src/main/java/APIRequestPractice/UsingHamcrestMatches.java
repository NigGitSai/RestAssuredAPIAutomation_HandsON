package APIRequestPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class UsingHamcrestMatches {

	@Test
	public void usingHamcrestMatchers() throws IOException
	{

		// TODO Auto-generated method stub
		
		File responseJson = new File("./src/test/resources/PetStore.json");
		
		String ipJson = FileUtils.readFileToString(responseJson,"UTF-8");
		
		File jsonSchema = new File("./src/test/resources/PetStoreJSONSchema.json");
		
		MatcherAssert.assertThat(ipJson, JsonSchemaValidator.matchesJsonSchema(jsonSchema));
	}

}
