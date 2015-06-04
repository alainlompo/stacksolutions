package stack.commons.collections;

public class User {
	
	private String firstName;
	private String lastName;
	private int age;
	
	public  User(String fN, String lN) {
		firstName = fN;
		lastName = lN;
	}
	
	public  User(String fN, String lN, int age) {
		this(fN,lN);
		this.age = age;
	}
	
	public String toString() {
		return firstName + "-" + lastName + "(" + age + ")";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
