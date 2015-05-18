package stack.commons.algorithms.linkedlists.swapandreplace;

import java.util.Scanner;

public class Node<E extends Comparable> {
	
	private E num;
	private Comparable info;
	
	private Node<E> head;
	private Node<E> lead;
	private Node<E> tail;
	private Node<E> next;
	
	public void setInfo(Comparable info) {
		this.info = info;
	}
	
	public Node<E> lastNode() {
		
		Node<E> currentNode = this.head;
		if (null == currentNode) {
			return null;
		}
		
		while (null != currentNode.next) {
			currentNode = currentNode.next;
		}
		
		return currentNode;
	}
	
	
	public  Node<E> getPrev() {
		Node<E> current = this.head;
		
		while (null != current.next && current.next != this) {
			current = current.next;
		}
		
		return (current.next == this)? current: null;
			
	}
	
	public void add(E num) {
		
		Node<E> temp = new Node<E>(num);
		temp.setInfo(num );
	    
		if (this.head == null) {
	        
			this.head = temp;
	        System.out.println("Was empty");
	    
		} else {

		
	        Node<E> lead = this.head;
	        Node<E> tail = this.head;


	        while (lead != null) {

	        	
	            if (lead.info.compareTo(temp.info) == -1) {//If the lead.info is less than the argument then -1 is returned.

	            	if (temp != lastNode()) {
	            		lastNode().next = temp; // adds to the end of linked list
	            	}
	            	
	            	temp.head = this.head;
	                //System.out.println("it works");

	            } 
	            
	            
	            if (lead.info.compareTo(temp.info) == 1) { //if the greater than we swap out

	            	temp.head = this.head;
	                
	                Node<E> prevNode = lead.getPrev();
	              	                
	                Node<E> lastNode = lastNode();
	                assert lastNode != null;
	                Node<E> lastNodePrev = lastNode.getPrev();
	                
	                lastNodePrev.next = null;
	                
	                prevNode.next = temp;
	                temp.next = lead;
	                break;
	                
	            }
	            lead=lead.next;

	        }
	    }
	}
	
	
	public void showNodes() {
		
		Node<E> initial = this;
		
		Node<E> current = initial;
		System.out.print(current.num);
		
		while (null != current.next) {
			
			current = current.next;
			System.out.print(" , " +   current.num );
			
		}
		
		System.out.println();
	}
	
	
	public Node (E num) {
		this.num = num;
	}
	
	public static void main(String[] args) {

		Node<Integer> node0 = new Node<Integer>(2);
		node0.setInfo(2);
		
		Node<Integer> node1 = new Node<Integer>(3);
		node1.setInfo(3);
		
		Node<Integer> node2 = new Node<Integer>(8);
		node2.setInfo(8);
		
		Node<Integer> node3 = new Node<Integer>(11);
		node3.setInfo(11);
		
		Node<Integer> node4 = new Node<Integer>(15);
		node4.setInfo(15);
		
		node0.head = node0;
		node0.next = node1;
		node0.tail = node4;
				
		node1.head = node0;
		node1.next = node2;
		node1.tail = node4;
		
		node2.head = node0;
		node2.next = node3;
		node2.tail = node4;
		
		node3.head = node0;
		node3.next = node4;
		node3.tail = node4;
		
		node4.head = node0;
		node4.next = null;
		node4.tail = node4;
		
		node0.showNodes();
		
		node2.add(25);
		
		node0.showNodes();
		
		node2.add(7);
		
		node0.showNodes();
		
				
	}

	
}
