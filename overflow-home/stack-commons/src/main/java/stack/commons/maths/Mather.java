package stack.commons.maths;

public class Mather {
	
	// For Addition and Substraction
	static int evalAS(String e) {
	    int p1 = e.lastIndexOf("+");
	    int p2 = e.lastIndexOf("-");
	    int p = Math.max(p1, p2);
	    if (p == -1)
	        return Integer.parseInt(e);
	    if (e.charAt(p) == '+')
	        return evalAS(e.substring(0, p))
	                + Integer.parseInt(e.substring(p + 1));
	    return evalAS(e.substring(0, p)) - Integer.parseInt(e.substring(p + 1));
	}

	// For Multiplication and Division
	static int evalMD(String e) {
	    int p1 = e.lastIndexOf("*");
	    int p2 = e.lastIndexOf("/");
	    int p = Math.max(p1, p2);
	    if (p == -1)
	        return Integer.parseInt(e);
	    if (e.charAt(p) == '*')
	        return evalMD(e.substring(0, p))
	                * Integer.parseInt(e.substring(p + 1));
	    return evalMD(e.substring(0, p)) / Integer.parseInt(e.substring(p + 1));
	}

	// Evaluation whole expression
	static int evalE(String e) {

	    int s1 = e.indexOf("(");
	    int s2 = e.lastIndexOf(")");

	    if(s1 != -1 && s2!= -1)
	    {
	        // ?????
	    }

	    int p1 = e.lastIndexOf("+");
	    int p2 = e.lastIndexOf("-");
	    int p = Math.max(p1, p2);
	    if (p == -1)
	        return evalMD(e);
	    if (e.charAt(p) == '+')
	        return evalE(e.substring(0, p)) + evalMD(e.substring(p + 1));
	    return evalE(e.substring(0, p)) - evalMD(e.substring(p + 1));
	}

}
