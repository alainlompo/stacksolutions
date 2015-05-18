package stack.commons.samples.dataset;

import java.util.List;

public class JasonSet {
	
	private String name = "Lompo";
	private int age = 37;
	private List<String> messages = CollectionsUtils.getSampleList();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	

}
