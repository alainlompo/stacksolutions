package stack.commons.arrays;

import java.util.ArrayList;

public class ArrayListToArray {
	
	private static ArrayList<String> tempArray = new ArrayList<String>();
	static {
		tempArray.add("WUBDLAIUWBD");
		tempArray.add("LUBELUFBSLI");
		tempArray.add("SLUEFLISUEB");
	}
	
	private static int columnCount = 11;
	private static int rowCount = 3;
	private static int[][] epidemicArray = new int[rowCount][columnCount];
	
	public static void updateArray(){
	    //extract string from temp
	    for (int i = 0; i < tempArray.size(); i++){
	        String temp = tempArray.get(i);
	        char[] charz = temp.toCharArray();
	        for (int j = 0; j < charz.length; j++){

	           // for (int l = 0; l < columnCount; l++){
	                epidemicArray[i][j] = charz[j];
	           // }

	        }
	    }
	}
	
	public static void printRow(int rowNumber) {
		for (int i = 0; i < 11; i++) {
			System.out.print( epidemicArray[rowNumber][i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	
		updateArray();
		for (int i = 0; i < 3; i++) {
			printRow(i);
		}
	}

}
