package stack.commons.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Faculty implements Comparable<Faculty> {

	private String lastName;
	private String firstName;
	private int age;
		
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int compareTo(Faculty f2) {
	
		return this.getLastName().compareToIgnoreCase(f2.getLastName());
		
	}
	
	
	
	public Faculty(String lastName, String firstName, int age) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}

	public String toString() {
		return getLastName() + " : " + getAge();
	}
	
	
	public static void main(String[] args) {
		List<Faculty> faculties = new ArrayList<Faculty>();
		Faculty f1 =  new Faculty("Lompo", "Alain", 35);
		Faculty f2 =  new Faculty("Amane", "Moustakbal", 52);
		Faculty f3 =  new Faculty("Obadiah", "Bumbliberg", 75);
		Faculty f4 =  new Faculty("Jared", "Smith", 15);
		Faculty f5 =  new Faculty("Abraham", "Kaynes", 85);
		
		
		faculties.add(f1);
		faculties.add(f2);
		faculties.add(f3);
		faculties.add(f4);
		faculties.add(f5);
		
		System.out.println("Initial stated after inserted: " + faculties);
		
		Collections.sort(faculties, new FacultyComparator());
		
		System.out.println("State after sorting ...: " + faculties);
		
		System.out.println("Using a TreeSet...");
		
		
		Faculty f12 =  new Faculty("Lompo", "Alain", 35);
		Faculty f22 =  new Faculty("Amane", "Moustakbal", 52);
		Faculty f32 =  new Faculty("Obadiah", "Bumbliberg", 75);
		Faculty f42 =  new Faculty("Jared", "Smith", 15);
		Faculty f52=  new Faculty("Abraham", "Kaynes", 85);
		
		
		
		
		
		
	}
	
	
}
