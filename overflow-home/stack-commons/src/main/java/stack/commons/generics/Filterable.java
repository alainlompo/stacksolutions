package stack.commons.generics;

public class Filterable implements Filter {

	public boolean accept(Object obj) {
		
		if (null == obj) {
			return false;
		}
		if (! (obj instanceof String)) {
			return false;
		}
		
		String str = (String)obj;
		return (str.length() < 5);
								
	}

}
