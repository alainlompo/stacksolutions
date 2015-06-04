package stack.commons.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoColumnsComparisonDemo {
	
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		users.add(new User("Alain","Lompo",37));
		users.add(new User("Anis","Khai",37));
		users.add(new User("Anis","Grandison Finey",37));
		users.add(new User("Omar","Taimi",35));
		users.add(new User("Abdelhadi","Crowti",55));
		users.add(new User("Frantzo","Ribbs",67));
		users.add(new User("Frantzo","Fisherman",67));
		users.add(new User("Donald","Bodega",19));
		users.add(new User("Mister","No",62));
		users.add(new User("Charles","Xavier",65));
		
		Collections.sort(users, new TwoColumnsComparator());
		for (User u: users) {
			System.out.println(u);
		}
	}

}
