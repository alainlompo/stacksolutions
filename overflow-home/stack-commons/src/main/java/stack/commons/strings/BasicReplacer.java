package stack.commons.strings;

import java.util.Scanner;

public class BasicReplacer {
	
	StringBuilder builder = new StringBuilder();
	public String replaceAll(String source, String toReplace, String replaceValue) {
		
		if (source.contains(toReplace)) {
			int index = source.indexOf(toReplace);
			System.out.println("Found at index " + index);
			
			String preceedingPart = "";
			if (index > 0) {
				preceedingPart = source.substring(0, index); 
			}
			
			builder.append(preceedingPart);
			
			builder.append(replaceValue);
			
			return replaceAll(source.substring(index + toReplace.length()), toReplace, replaceValue);
			
		}  else {
			
			String result = builder.toString();
			builder = new StringBuilder();
			return result;
		}
	}
	
	
	public static void main(String[] args) {
		
		String userInput = "";
		Scanner scanner = new Scanner(System.in);
		BasicReplacer replacer = new BasicReplacer();
		
		while (true) {

			System.out.println("Enter the user's input: ");
			userInput = scanner.next();
			
			if (userInput.trim().toUpperCase().equals("EXIT")) {
				break;
			}
			
			String result = replacer.replaceAll(userInput, "w", "%20");
			
			System.out.println("The result is : " + result);
			
		}
	}
	

}
