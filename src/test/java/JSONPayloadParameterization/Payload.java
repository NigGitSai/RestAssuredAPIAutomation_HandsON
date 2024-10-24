package JSONPayloadParameterization;

public class Payload {

	
	public static String reqJSON(String name,String isbn,String aisle,String author)
	{
		String reqPayload = "{\r\n"
				+ "\"name\":\""+name+"\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\""+author+"\"\r\n"
				+ "}\r\n"
				+ "";
		return reqPayload;
		
	}
	
	
}
