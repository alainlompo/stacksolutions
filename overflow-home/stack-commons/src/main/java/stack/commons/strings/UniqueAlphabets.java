package stack.commons.strings;

import java.util.LinkedHashSet;

public class UniqueAlphabets {

	
	
	String s1 = "I am living in India";
	String s2 = "India is a beautiful country";
	char[] s1Array = s1.toCharArray();
	char[] s2Array = s2.toCharArray();
	LinkedHashSet<Character> s1CharSet = new LinkedHashSet<Character>();
	LinkedHashSet<Character> s2CharSet = new LinkedHashSet<Character>();
	
	public void doDemo() {
		for (char kc: s1Array) {
			s1CharSet.add(kc);
		}
		
		for (char kc: s2Array) {
			
			s2CharSet.add(kc);
		}
		
		s1CharSet.retainAll(s2CharSet);
		
		if (s1CharSet.size() == 0) {
			System.out.println("There are no common characters between the two strings");
			
		} else {
			System.out.println(s1CharSet);
		}
	}
	
	public static void main(String[] args) {
		(new UniqueAlphabets()).doDemo();
	}
	

}
