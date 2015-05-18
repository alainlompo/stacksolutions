package stack.commons.collections;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

public class MultiMapSample {
	
	public static void main(String[] args) {
		MultiMap<String, String> myMultiMap = new MultiValueMap<String, String>();
		myMultiMap.put("Noms", "Lompo");
		myMultiMap.put("Noms", "Kone");
		myMultiMap.put("Noms", "Kuate");
		myMultiMap.put("Noms", "Ouedraogo");
		myMultiMap.put("Prenoms", "Alain");
		myMultiMap.put("Prenoms", "Jean Marc");
		myMultiMap.put("Prenoms", "Franck");
		
		System.out.print("Les noms usuels = " + (List)myMultiMap.get("Noms")); 
		
	}

}
