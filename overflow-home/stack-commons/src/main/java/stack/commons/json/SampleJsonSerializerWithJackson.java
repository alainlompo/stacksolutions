package stack.commons.json;

import java.io.File;
import java.io.IOException;

import stack.commons.samples.dataset.JasonSet;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SampleJsonSerializerWithJackson {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		JasonSet set = new JasonSet();
		
		mapper.writeValue(new File("C:\\Hypernovae\\Test1\\jasonset.json"), set);
		
		
	}

}
