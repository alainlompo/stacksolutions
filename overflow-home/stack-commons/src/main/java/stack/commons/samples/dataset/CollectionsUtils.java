package stack.commons.samples.dataset;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

public class CollectionsUtils {
	
	
	private CollectionsUtils() {
		
	}
	
	
	public static MultiMap<String, String> getUser1342006Sample() {
		MultiMap<String, String> map = new MultiValueMap<String, String>();
		map.put("Key 1", "Val 11");
		map.put("Key 1", "Val 12");
		map.put("Key 2", "Val 21");
		map.put("Key 2", "Val 22");
		return map;
	}
	public static MultiMap<String, String> getMultiMapSampleDatas() {
		
		MultiMap<String, String> myMultiMap = new MultiValueMap<String, String>();
		myMultiMap.put("noms", "Lompo");
		myMultiMap.put("noms", "Kone");
		myMultiMap.put("noms", "Kuate");
		myMultiMap.put("noms", "Ouedraogo");
		myMultiMap.put("prenoms", "Alain");
		myMultiMap.put("prenoms", "Jean Marc");
		myMultiMap.put("prenoms", "Franck");
		
		return myMultiMap;
		
	}
	
	public static List<String> getSampleList() {
		
		List<String> result = new ArrayList<String>();
		result.add("msg 1");
		result.add("Longer message 2");
		result.add("msg 3");
		return result;
		
		
	}

}
