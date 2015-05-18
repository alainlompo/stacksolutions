package stack.commons.json;

import java.io.IOException;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.collect.Multimap;

public class JsonToGuavaDemo {
	
	
	String jsonString = "{\n \"123455\":[\n {\n \"key\":\"Java Exercises\",\n \"url\":\"www.leveluplunch.com/java/exercises/\"\n },\n {\n \"key\":\"Java Examples\",\n \"url\":\"www.leveluplunch.com/java/examples/\"\n }\n ],\n \"999999\":[\n {\n \"key\":\"Java Tutorials\",\n \"url\":\"www.leveluplunch.com/java/tutorials/\"\n },\n {\n \"key\":\"Java Examples\",\n \"url\":\"www.leveluplunch.com/java/examples/\"\n }\n ]\n}";

	static class NavItem {

		public NavItem() {
		}

		private String key;
		private String url;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return com.google.common.base.Objects.toStringHelper(this)
					.add("key", key).add("url", url).toString();
		}
	}

	
	public void convert() throws JsonParseException, JsonMappingException,
			JsonProcessingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new GuavaModule());

		Multimap<String, NavItem> navs = objectMapper.readValue(
				objectMapper.treeAsTokens(objectMapper.readTree(jsonString)),
				objectMapper.getTypeFactory().constructMapLikeType(
						Multimap.class, String.class, NavItem.class));

		
		assert navs.keys().contains("123455");
		assert navs.keys().contains("999999");
		
		System.out.println("Datas for key 123455 =" + navs.get("123455") );
		
	}
	
	public static void main(String[] args) throws Exception {
		(new JsonToGuavaDemo()).convert();
	}

}
