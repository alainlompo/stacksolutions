package stack.commons.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NullPointerHandler {
	
	private static Map<Character, Integer> letterValueMap;
	static {
		letterValueMap = new HashMap<Character, Integer>();
		for (int i = 'a'; i<= 'a'+25; i++) {
			letterValueMap.put((char)i, i);
		}
		
		for (int i = 'A'; i<= 'A'+25; i++) {
			letterValueMap.put((char)i, i);
		}
		
		letterValueMap.put(' ', 32);
		
		
	}
	public static void main(String[] args){

	    List<String> testList = new ArrayList<String>();
	    testList.add("apple");
	    testList.add("hello");
	    testList.add("ROME");
	    testList.add("rome");
	    testList.add("Julius Cesar");
	    printStringsWithValues(testList);}


	public static void printStringsWithValues(List<String> strings)
	{
	    for (String string : strings) {

	        System.out.println(string + ",    " + calculateStringValue(string));
	    }
	}

	public static int calculateStringValue(String word)
	{
	    int value = 0;

	    for(int j=0; j < word.length(); j++)
	    {
	        if(letterValueMap.containsKey(word.charAt(j)))
	        {
	            value += letterValueMap.get(word.charAt(j));
	        }    
	        else{
	            return -1;
	        }
	    }
	    return value; 
	}

}
