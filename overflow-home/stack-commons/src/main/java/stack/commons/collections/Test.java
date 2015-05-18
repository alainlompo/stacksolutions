package stack.commons.collections;

public class Test 
{     

    public static void main(String[] args) 
    {
        ExampleLinkedList test1 = new ExampleLinkedList("Hello", null);
        ExampleLinkedList test2 = new ExampleLinkedList("Thanks", test1);
        ExampleLinkedList test3 = new ExampleLinkedList("Goodbye", test2);

        test1.addToEnd("AddedItem");
        System.out.println(test3);
    }
}
