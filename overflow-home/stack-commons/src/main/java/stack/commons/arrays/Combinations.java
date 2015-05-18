package stack.commons.arrays;

public class Combinations {
	
	static String[] datas = new String[] {"A", "B","C","D"};
	
	
	public static void printLines(int size) {
		int index1 = 0;
		int index2 = 1;
		
		bigger1:
		do {
				System.out.print(datas[index1] +" ");
				bigger2:
				do {
					for (int i = index2; i < index2 + size-1 ; i++) {
						System.out.print(datas[index1+i]+ " ");
					}
					
					System.out.println();
					index2++;
					
					if (index2 + size -2 >= datas.length) {
						index2 = 1;
						index1++;
						break;
					} else {
						break;
					}
					
				} while (true);
				
			} while (true);
	}
	public static void printTwo(int size) {
		
		int index = 0;
		int index2 = 1;
		
		do {
			
			String current = datas[index];
			
			System.out.print(current + " ");
			
			for (int i = index +index2; i <= index +index2 + size -1 && index + index2 + size -1  <= datas.length; i++ ) {
				System.out.print(datas[i] +  " ");
				
			}
			
			System.out.println();
			
			index2++;
			if (index + index2 >= datas.length) {
				index++;
				index2 = 1;
				if (index + size -1 > datas.length) {
					break;
				}
			}
		
			
			
			
		} while (true);
	}
	
	public static void recursivePrintCombinations(String[] datas, int combinationSize) {
		
		if (null == datas || datas.length == 0) {
			
			return;
			
		} else if (datas.length == 1) {
			
			System.out.print(datas[0]);
			System.out.println();
			return;
		} else {
			
			
			
		}
		
	}
	
	public static void printCombinations(int combinationSize) {
		for (int i = 0; i <= datas.length - combinationSize; i++) {
			
			System.out.print(datas[i] + " ");
			
			for (int j = i+1; j < i + combinationSize; j++) {
				
				System.out.print(datas[j] + " ");
				
			}
			System.out.println();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		printLines(3);
		
	}

}
