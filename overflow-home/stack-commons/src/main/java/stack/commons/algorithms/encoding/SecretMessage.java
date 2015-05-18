package stack.commons.algorithms.encoding;

import java.util.Scanner;

public class SecretMessage {
	
	public static void main(String[] args) {
		
		int A = "A".charAt(0);
		int Z = "Z".charAt(0);
		int a = "a".charAt(0);
		int z = "z".charAt(0);
		
		
		Scanner io = new Scanner(System.in);
		System.out.println("Enter Message");
		String mssg=io.next();
		
		StringBuilder decodedBuilder = new StringBuilder();
		{
			
			for (int i = 0; i < mssg.length(); i++) {
			
				char current = mssg.charAt(i);
				
				System.out.println("Analyzing " + current);
				
				if (Character.isAlphabetic(current) | Character.isDigit(current)) {
					
					System.out.println("==> Alphabetic or digit");
					
					if (current == A || current == a) {
						System.out.println("==> ==> Alphabet frontier...");
						decodedBuilder.append((char)(current+ (z-a)));
						
					} else if (Character.isDigit(current)) {
						System.out.println("==> Digit...");
						
						if (current == '0') {
							System.out.println("==> ==> Digit frontier...");
							decodedBuilder.append('9');
						} else {
							int currentValue = Integer.parseInt(current+"");							
							decodedBuilder.append((char)(currentValue-1));
						}
					} else {
						String toAdd =String.valueOf((char)(current-1));
						decodedBuilder.append(toAdd);
					}
				} else {
					decodedBuilder.append((char)(current));
				}
				
			}
		}
		
		System.out.println("Decoded = " + decodedBuilder.toString());
			
			
		}
	
	}


