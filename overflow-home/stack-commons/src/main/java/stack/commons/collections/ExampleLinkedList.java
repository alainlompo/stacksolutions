package stack.commons.collections;

public class ExampleLinkedList 
{
    private String data;
    private ExampleLinkedList next;

    public ExampleLinkedList(String data,ExampleLinkedList next)
    {
        this.data = data;
        this.next = next;
    }

    public void addToEnd(String item)
    {
    	ExampleLinkedList current;
    	ExampleLinkedList newList;
        while(next != null)
        {
           
            current = next;
            next = next.next;
            if (next == null) {
            	newList = new ExampleLinkedList(item,next);
            	current.next = newList;
            	
            }
           
        }
    }

    public boolean isEmpty()
    {
        if(next == null)
        {
            return true;
        }
        return false;
    }

    public String toString()
    {
        String result = data;
        while(next != null)
        {
            result = result + " " + next.data;
            next = next.next;
        }
        return result;
    }

}