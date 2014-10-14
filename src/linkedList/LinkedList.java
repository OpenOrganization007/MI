package linkedList;

public class LinkedList
{

    private Node head;

    /**
     * helper function will add node in linked list
     * @param item
     */
    public void add(int item)
    {
	if (head == null)
	{
	    head = new Node(item);
	}
	else
	{
	    Node temp = head;
	    while (temp.next != null)
	    {
		temp = temp.next;
	    }
	    temp.next = new Node(item);
	}
    }
    
    /**
     * utility function will reverse list
     */
    public void reverseList(){
	//Node temp =  
    }

    public void print()
    {
	Node temp = head;
	while (temp != null)
	{
	    System.out.print(" " + temp.data);
	    temp = temp.next;
	}
    }

    public static void main(String[] args)
    {
	LinkedList list = new LinkedList();
	for (int i = 1; i < 10; i++)
	{
	    list.add(i);
	}
	list.print();

    }

}
