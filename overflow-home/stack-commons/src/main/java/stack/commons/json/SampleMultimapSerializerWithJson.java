package stack.commons.json;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import stack.commons.samples.dataset.CollectionsUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.guava.deser.MultimapDeserializer;

public class SampleMultimapSerializerWithJson {
	
	public static String doSerialization() throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(CollectionsUtils.getMultiMapSampleDatas()); 
		
	}
	
	public static String doSerialization(MultiMap<String, String> map) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}
	
	
	public static MultiMap<String,String> doDeserialization(String serializedString) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Class<MultiValueMap> classz = MultiValueMap.class;
		MultiMap map = mapper.readValue(serializedString, classz);
		return (MultiMap<String, String>) map;
		
		
	}
	
public static MultiMap<String,String> doDeserializationII(String serializedString) throws JsonParseException, JsonMappingException, IOException {
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new GuavaModule());
		
		MultiMap <String, String> map = mapper.readValue(
				mapper.treeAsTokens(mapper.readTree(serializedString)),
				mapper.getTypeFactory().constructMapLikeType(MultiValueMap.class, String.class, ArrayList.class)
				);
		
		return  map;
		
		
	}


	public static MultiMap<String,String> doDeserializationIII(String serializedString) throws JsonParseException, JsonMappingException, IOException {
	
	
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new GuavaModule());
		
		MultiMap <String, String> map = mapper.readValue(
				mapper.treeAsTokens(mapper.readTree(serializedString)),
				mapper.getTypeFactory().constructMapLikeType(MultiValueMap.class, String.class, DatasHolder.class)
				);
		
		return  map;
	
	
	}
	
	public static MultiMap<String, String> doDeserializationAndFormat(String serializedString) throws JsonParseException, JsonMappingException, IOException {
		MultiMap<String, String> source = doDeserialization(serializedString);
		MultiMap<String, String> result  =  new MultiValueMap<String,String>();
		for (String key: source.keySet()) {
			
			
			List allValues = (List)source.get(key);
			Iterator iter = allValues.iterator();
			
			while (iter.hasNext()) {
				List<String> datas = (List<String>)iter.next();
				
				for (String s: datas) {
					result.put(key, s);
				}
			}
						
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		/*String serializedSampleMultiMap = doSerialization();
		System.out.println("Serizlized = " + serializedSampleMultiMap);
		
		MultiMap initial = CollectionsUtils.getMultiMapSampleDatas();
		System.out.println("Noms from initial =" + initial.get("noms"));
		
		MultiMap<String, String> unSerializedMap = doDeserialization(serializedSampleMultiMap);
		System.out.println("Noms = " + unSerializedMap.get("noms"));
		
		MultiValueMap<String,String> parsedMap = (MultiValueMap)doDeserializationAndFormat(serializedSampleMultiMap);
		System.out.println("Noms = " + parsedMap.get("noms") );
		
		List nomElems =(List) parsedMap.get("noms");
		System.out.println("Size of noms elemns =" + nomElems.size());
		
		
		MultiMap<String, String> unSerializedMapII = doDeserializationII(serializedSampleMultiMap);
		System.out.println("Noms = " + unSerializedMapII.get("noms"));*/
		
		String stackMapSerialized = doSerialization(CollectionsUtils.getUser1342006Sample());
		System.out.println("user map serialized = " + stackMapSerialized);
		
		MultiValueMap<String,String> userParsedMap = (MultiValueMap)doDeserializationAndFormat(stackMapSerialized);
		System.out.println("Key 1 = " + userParsedMap.get("Key 1") );
		System.out.println("Key 2 = " + userParsedMap.get("Key 2") );
		
		
		
		
		
		
	}
	
	

}

class DatasHolder {
	private List<String> noms;
	private List<String> prenoms;
	
	
	public List<String> getNoms() {
		return noms;
	}
	public void setNoms(List<String> noms) {
		this.noms = noms;
	}
	public List<String> getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(List<String> prenoms) {
		this.prenoms = prenoms;
	}
	
	
}
