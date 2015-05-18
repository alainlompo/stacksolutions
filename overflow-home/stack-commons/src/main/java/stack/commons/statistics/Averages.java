package stack.commons.statistics;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Averages {

	public static double average(List<Double> datas) {
		double sum = 0.0D;
		for (double d:datas) {
			sum += d;
		}
		return sum/datas.size();
	}
	
	public static double min(List<Double> datas) {
		double min = datas.get(0);
		for (int i = 1; i < datas.size(); i++) {
			if (datas.get(i) < min) {
				min = datas.get(i);
			}
		}
		
		return min;
	}
	
	public static double max(List<Double> datas) {
		double max = datas.get(0);
		for (int i = 1; i < datas.size(); i++) {
			if (datas.get(i) > max) {
				max = datas.get(i);
			}
		}
		return max;
	}
		
	public static void main(String[] args) {
	    //initialize variables
	    double sum =0;
	    int count = 0;
	    double grade =0;
	    //initialize scanner and input
	    System.out.print("Enter Grades, enter -1 to end the set:");
	    Scanner in = new Scanner (System.in);
	    List<Double> datas = new ArrayList<Double>();
	    // Collect all the datas and use sentinel to mark the end
	    //Process data until sentinel is entered
	    while (grade != -1)
	    {
	        grade = in.nextDouble();
	        if (grade != -1)
	        {
	        	datas.add(grade);
	           // sum = sum + grade;
	           // count++;
	        }
	    }
	   // Finding the average
	    if(datas.size() > 0)
	    {
	        double average = sum/ datas.size();
	        double min = min(datas);
	        double max = max(datas);
	        average = average(datas);
	        System.out.println("Grade Average: "+average);
	        System.out.println("Min: " + min);
	        System.out.println("Max: " + max);
	    }
	    else
	    {
	        System.out.println("No Data");
	    }
	    
	    
	    
	}
}
