package stack.commons.strings;

import java.util.Scanner;

public class StoryChoice {
	
	public static void main(String[] args) {
		
		Scanner keybd = new Scanner(System.in);
		
		String storyChoice = ""; 
		

	    //This loop checks the scanner to see if the user has inputted an 
	    //appropriate answer, as soon as the user inputs an appropriate answer
	    //The while loop terminates. 
	    while(!storyChoice.equals("1")  && !storyChoice.equals( "2") && !storyChoice.equals( "3")) 
	    {
	    	storyChoice = keybd.next();
	        if(storyChoice.equals( "1"))
	        {
	            Sword story = new Sword();
	            //story.intro();
	            break; 
	        }
	        else if (storyChoice.equals( "2"))
	        {
	            System.out.println("Not coded yet, so stay tuned!"); 
	            break;
	        }
	        else if(storyChoice.equals( "3"))
	        {
	            System.out.println("Not coded yet, so stay tuned!"); 
	            break;
	        }
	        else
	        {
	            System.out.println("Please choose an appropriate answer"); 
	            //storyChoice = keybd.next(); 
	        }
	    }
	}

}
