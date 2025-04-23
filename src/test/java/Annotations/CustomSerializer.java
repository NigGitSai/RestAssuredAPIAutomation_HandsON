package Annotations;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomSerializer extends StdSerializer<EmployeePojo> {

	protected CustomSerializer(Class<EmployeePojo> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	
	public CustomSerializer()
	{
		this(null); 
	}

	@Override
	public void serialize(EmployeePojo value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		
		gen.writeStartObject();
		gen.writeStringField("first_name", value.getFirstName());
		gen.writeStringField("last_name", value.getLastname());
		
	}
	
	

}
